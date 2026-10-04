package com.framework.pages;

import com.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    // FIXED: Removed WebDriver constructor - BasePage handles driver via DriverFactory
    // FIXED: Changed By locators to @FindBy WebElement fields to match BasePage methods

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardHeader;

    public boolean isDashboardDisplayed() {
        return isDisplayed(dashboardHeader);
    }
}
