package com.framework.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Geolocation {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();                      // assign to field, not local
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void locationValidation() {

        WebElement geoLocationLink = driver.findElement(By.linkText("Geolocation"));
        geoLocationLink.click();

        WebElement locationButton =
                driver.findElement(By.xpath("//button[@onclick='getLocation()']"));
        locationButton.click();

        WebElement googleLink =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.linkText("See it on Google")));
        googleLink.click();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}