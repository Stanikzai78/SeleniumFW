package com.framework.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsexecutorScrollTesting {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void scrollingPage() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/newtours/index.php");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement toursLink = driver.findElement(By.linkText("REGISTER"));
        Thread.sleep(5000);

        js.executeScript("arguments[0].scrollIntoView(true);", toursLink);
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}