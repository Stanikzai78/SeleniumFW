package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;
import com.framework.utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage();

        HomePage homePage = loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        Assert.assertTrue(homePage.isDashboardDisplayed());
        Assert.assertEquals(homePage.getDashboardHeaderText(), "Dashboard");
    }
}