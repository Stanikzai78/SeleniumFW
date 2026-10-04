package com.framework.pages;

import com.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = ".oxd-topbar-header-title")
    private WebElement dashboardHeader;

    public String getDashboardHeaderText() {
        return getText(dashboardHeader);
    }

    public boolean isDashboardDisplayed() {
        return isDisplayed(dashboardHeader);
    }
}