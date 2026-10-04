
package com.framework.pages;

import com.framework.base.BasePage;
import com.framework.driver.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ScrollPage extends BasePage {

    @FindBy(linkText = "Infinite Scroll")
    private WebElement infiniteScrollLink;

    @FindBy(xpath = "//h3[normalize-space()='Infinite Scroll']")
    private WebElement scrollPageHeader;

    @FindBy(css = "div.jscroll-added")
    private List<WebElement> loadedParagraphs;

    public void openScrollPage() {
        click(infiniteScrollLink);
    }

    public void scrollDown() {
        ((JavascriptExecutor) DriverFactory.getDriver())
            .executeScript("window.scrollBy(0, document.body.scrollHeight);");
    }

    public boolean isHeaderDisplayed() {
        return isDisplayed(scrollPageHeader);
    }

    public int getLoadedParagraphCount() {
        return loadedParagraphs.size();
    }
}























//package com.framework.pages;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import com.framework.base.BasePage;
//
//public class ScrollPage extends BasePage {
//
//    @FindBy(linkText = "Infinite Scroll")
//    private WebElement infiniteScrollLink;
//
//    @FindBy(xpath = "//h3[text()='Infinite Scroll']")
//    private WebElement scrollPageHeader;
//
//    public void openScrollPage() {
//        click(infiniteScrollLink);
//    }
//    
//    actions.scrollFramOrigin(orgin, 0, 300).perform();
//    
//    public boolean isScrollPageDisplayed() {
//        return scrollPageHeader.isDisplayed();
////    }
////
////    public void scrollToBottom() throws InterruptedException {
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");
////
////        while (true) {
////            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
////            Thread.sleep(2000);
////
////            long newHeight = (long) js.executeScript("return document.body.scrollHeight");
////            if (newHeight == lastHeight) {
////                break;
////            }
////            lastHeight = newHeight;
//        }
//    }


