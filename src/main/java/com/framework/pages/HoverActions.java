
package com.framework.pages;

import com.framework.base.BasePage;
import com.framework.driver.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HoverActions extends BasePage {

    @FindBy(xpath = "//a[normalize-space()='Hovers']")
    private WebElement hoversButton;
    @FindBy(xpath = "(//img[@alt='User Avatar'])[1]")
    private WebElement firstImage;
    @FindBy(xpath = "(//img[@alt='User Avatar'])[2]")
    private WebElement secondImage;

    public void openHoversPage() {
        click(hoversButton);
    }

    public void hover(WebElement element) {
        new Actions(DriverFactory.getDriver()).moveToElement(element).perform();
    }

    public void hoverFirstImage()  { hover(firstImage); }
    public void hoverSecondImage() { hover(secondImage); }

    public boolean isFirstImageDisplayed()  { return isDisplayed(firstImage); }
    public boolean isSecondImageDisplayed() { return isDisplayed(secondImage); }
}
