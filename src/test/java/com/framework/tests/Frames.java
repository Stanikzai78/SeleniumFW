package com.framework.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

    private WebDriver driver;

    @BeforeMethod
    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com");
    }

    @Test
    public void frameValidation() throws InterruptedException {

        WebElement frames = driver.findElement(By.linkText("Frames"));
        frames.click();

        WebElement nestedFrames = driver.findElement(By.linkText("Nested Frames"));
        nestedFrames.click();

        // Optional: verify page heading
        WebElement content = driver.findElement(By.xpath("//div[@id='content']"));
        System.out.println(content.getText());

        // Switch to top frame container
        driver.switchTo().frame("frame-top");

        // Switch to middle frame
        driver.switchTo().frame("frame-middle");
        Thread.sleep(5000);
        // Inside middle frame; locate the text
        String middleText = driver.findElement(By.id("content")).getText();
        System.out.println(middleText);
        Thread.sleep(5000);
        // Always switch back to default content if needed later
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}