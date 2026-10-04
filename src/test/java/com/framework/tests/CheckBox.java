package com.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");

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

        driver.quit();
    }

           

	}





	


