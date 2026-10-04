package com.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleDropdownTest {

 @Test
 public void multipleDropDownTest() {
	 WebDriverManager.chromedriver().setup();
 	WebDriver driver = new ChromeDriver();
// 	driver.manage().window().maximize();
// 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	driver.get("https://the-internet.herokuapp.com");
 	
 	Select multiSelect = new Select(driver.findElement(By.xpath("//a[normalize-space()='Dropdown']")));

    System.out.println("Is multiple selection supported: " + multiSelect.isMultiple());
    multiSelect.selectByValue("java");               // Select by value attribute
    multiSelect.selectByVisibleText("Python");       // Select by visible text
    multiSelect.selectByIndex(2);                    // Select by index (0-based)
    multiSelect.deselectAll();
}


        
    }
