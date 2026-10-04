package com.frameworkaut.test;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyInfoTN {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void loginTest() {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        WebElement passWord = driver.findElement(By.name("password"));
        passWord.sendKeys("admin123");
        WebElement loginBtn = driver.findElement(By.cssSelector("button.orangehrm-login-button"));
        loginBtn.click();
        WebElement dashboardHeader = driver.findElement(By.cssSelector("header .oxd-topbar-header-breadcrumb h6.oxd-text"));
        String actualHeader = dashboardHeader.getText();
        assertEquals(actualHeader,"Dashboard","Dashboard header is incorrect after loging");
        
//     
        
    }
}

