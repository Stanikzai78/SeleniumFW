package com.framework.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropTest {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @Test
    public void dragAndDrop() {
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);
 
        actions.moveToElement(source).clickAndHold()
                .pause(Duration.ofSeconds(2))
                .moveToElement(target)
                .pause(Duration.ofSeconds(1))
                .release()
                .build()
                .perform();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}