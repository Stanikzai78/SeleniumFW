package com.framework.base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.framework.driver.DriverFactory;
public class BaseTestNoLogin {
    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}