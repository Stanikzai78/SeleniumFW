package com.frameworkaut.test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.driver.DriverFactory;
import com.framework.pages.LoginPagePOM;
import com.framework.utils.ConfigReader;

public class LoginTestPOM extends BaseTest {

    @Test
    public void verifyLoginSuccess() {
        LoginPagePOM loginPagepom = new LoginPagePOM();
        loginPagepom.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

        new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("dashboard"));

        Assert.assertTrue(
                DriverFactory.getDriver().getCurrentUrl().contains("dashboard"),
                "Login failed - dashboard URL was not reached");
    }
}