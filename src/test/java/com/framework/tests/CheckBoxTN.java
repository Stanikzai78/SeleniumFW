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

public class CheckBoxTN {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void checkBoxValidation() {

    	 // Click Checkboxes link from home page
        WebElement checkboxesLink = driver.findElement(By.linkText("Checkboxes"));
        checkboxesLink.click();

        // Locate first checkbox specifically
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));

        // Check
        if (!checkbox1.isSelected()) {
            checkbox1.click();
            System.out.println("Checked");
        } else {
            System.out.println("Already checked");
        }

        // Uncheck
        if (checkbox1.isSelected()) {
            checkbox1.click();
            System.out.println("Unchecked");
        } else {
            System.out.println("Already unchecked");
        }

        // Go back to home page before clicking Context Menu
        driver.navigate().back();

        WebElement contextMenuLink = driver.findElement(By.linkText("Context Menu"));
        contextMenuLink.click();

        WebElement displayedContextMenu =
                driver.findElement(By.xpath("//h3[normalize-space()='Context Menu']"));

        System.out.println(displayedContextMenu.getText());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}