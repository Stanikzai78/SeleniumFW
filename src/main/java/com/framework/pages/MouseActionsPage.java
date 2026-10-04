package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.framework.base.BasePage;
import com.framework.driver.DriverFactory;
import com.framework.utils.WaitUtils;

public class MouseActionsPage extends BasePage {

    private final By hoverDropdown = By.id("myDropdown");
    private final By optionOne     = By.id("dropOption1");
    private final By optionTwo     = By.id("dropOption2");
    private final By optionThree   = By.id("dropOption3");

    private void hoverThenClick(By optionLocator) {
        WebElement menu = WaitUtils.waitForVisibility(hoverDropdown);
        scrollIntoView(menu);
        new Actions(DriverFactory.getDriver()).moveToElement(menu).perform();

        WebElement option = WaitUtils.waitForVisibility(optionLocator);
        new Actions(DriverFactory.getDriver()).moveToElement(option).click().perform();
    }

    public void openHoverDropDownPage() {
        WebElement menu = WaitUtils.waitForVisibility(hoverDropdown);
        scrollIntoView(menu);
        new Actions(DriverFactory.getDriver()).moveToElement(menu).perform();
    }

    public void clickLinkOne()   { hoverThenClick(optionOne); }
    public void clickLinkTwo()   { hoverThenClick(optionTwo); }
    public void clickLinkThree() { hoverThenClick(optionThree); }

    public boolean isLinkThreeDisplayed() {
        openHoverDropDownPage();                 // reveal the options first
        try {
            return WaitUtils.waitForVisibility(optionThree).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
}