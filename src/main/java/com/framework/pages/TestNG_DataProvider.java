package com.framework.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.driver.DriverFactory;

public class TestNG_DataProvider {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void googleSearchText() {
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium" + Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.getTitle().toLowerCase().contains("selenium"));

        Assert.assertTrue(driver.getTitle().toLowerCase().contains("selenium"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}



