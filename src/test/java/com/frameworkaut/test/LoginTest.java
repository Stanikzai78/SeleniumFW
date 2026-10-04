package com.frameworkaut.test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.driver.DriverFactory;
import com.framework.pages.LoginPage;
import com.framework.utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password"));

        new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("dashboard"));

        Assert.assertTrue(
                DriverFactory.getDriver().getCurrentUrl().contains("dashboard"),
                "Login failed - dashboard URL was not reached");
    }
}