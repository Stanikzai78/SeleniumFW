
package com.framework.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.base.BasePage;
import com.framework.driver.DriverFactory;

public class DragAndDrop extends BasePage {

    private static final String PAGE_URL = "https://the-internet.herokuapp.com/drag_and_drop";

    // HTML5 native drag-and-drop is NOT triggered by Selenium's Actions class on this
    // page, so we simulate the dragstart/drop/dragend sequence via JavaScript instead.
    private static final String DRAG_DROP_JS =
            "var src = arguments[0], tgt = arguments[1];\n" +
            "function makeEvent(type) {\n" +
            "  var e = document.createEvent('CustomEvent');\n" +
            "  e.initCustomEvent(type, true, true, null);\n" +
            "  e.dataTransfer = {\n" +
            "    data: {},\n" +
            "    setData: function (k, v) { this.data[k] = v; },\n" +
            "    getData: function (k) { return this.data[k]; }\n" +
            "  };\n" +
            "  return e;\n" +
            "}\n" +
            "function fire(el, e, dt) {\n" +
            "  if (dt !== undefined) { e.dataTransfer = dt; }\n" +
            "  el.dispatchEvent(e);\n" +
            "}\n" +
            "var start = makeEvent('dragstart');\n" +
            "fire(src, start);\n" +
            "var drop = makeEvent('drop');\n" +
            "fire(tgt, drop, start.dataTransfer);\n" +
            "var end = makeEvent('dragend');\n" +
            "fire(src, end, start.dataTransfer);";

    @FindBy(id = "column-a")
    private WebElement columnA;

    @FindBy(id = "column-b")
    private WebElement columnB;

    public void openPage() {
        DriverFactory.getDriver().get(PAGE_URL);
    }

    public void performDragAndDrop() {
        waitUntilVisible(columnA);
        ((JavascriptExecutor) DriverFactory.getDriver())
                .executeScript(DRAG_DROP_JS, columnA, columnB);
    }

    public String getSourceText() {
        return getText(columnA);
    }

    public String getTargetText() {
        return getText(columnB);
    }
}









//
//package com.framework.pages;
//
//import com.framework.base.BasePage;
//import com.framework.driver.DriverFactory;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//
//public class DragAndDrop extends BasePage {
//
//    @FindBy(linkText = "Drag and Drop")
//    private WebElement dragAndDropLink;
//    @FindBy(id = "column-a")
//    private WebElement source;
//    @FindBy(id = "column-b")
//    private WebElement target;
//
//    public void openPage() {
//        click(dragAndDropLink);
//    }
//
//    public void performDragAndDrop() {
//        new Actions(DriverFactory.getDriver()).dragAndDrop(source, target).perform();
//    }
//
//    public String getSourceText() { return getText(source); }
//    public String getTargetText() { return getText(target); }
//}
