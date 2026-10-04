package com.framework.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.framework.driver.DriverFactory;
import com.framework.pages.LoginPage;
import com.framework.utils.ConfigReader;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get(ConfigReader.get("baseUrl"));
        new LoginPage().login(ConfigReader.get("username"), ConfigReader.get("password"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}