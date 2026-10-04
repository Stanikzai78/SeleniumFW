package com.framework.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.framework.base.BasePage;
import com.framework.driver.DriverFactory;
import com.framework.utils.WaitUtils;
public class DownloadPage extends BasePage {
    @FindBy(xpath = "//a[normalize-space()='JQuery UI Menus']")
    private WebElement jqueryUiMenusLink;
    @FindBy(xpath = "//a[normalize-space()='Enabled']")
    private WebElement enabledMenu;
    @FindBy(xpath = "//a[normalize-space()='Downloads']")
    private WebElement downloadsMenu;
    @FindBy(xpath = "//a[normalize-space()='PDF']")
    private WebElement pdfButton;
    public void openPage() {
        DriverFactory.getDriver().get("https://the-internet.herokuapp.com/");
        click(jqueryUiMenusLink);
    }
    public void navigateToPDF() {
        Actions actions = new Actions(DriverFactory.getDriver());
        actions.moveToElement(enabledMenu).perform();
        WaitUtils.waitForVisibility(downloadsMenu);
        actions.moveToElement(downloadsMenu).perform();
        WaitUtils.waitForVisibility(pdfButton);
    }
    public boolean isDownLoadsMenuVisible() {
        return downloadsMenu.isDisplayed();
    }
    public boolean isPdfButtonVisible() {
        return pdfButton.isDisplayed();
    }
}
