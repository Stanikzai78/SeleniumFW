package com.framework.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShiftingContents {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
    try {
    	    driver.get("https://the-internet.herokuapp.com");

    	    WebElement shiftingContent = wait.until(
    	            ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Shifting Content']")));
    	    shiftingContent.click();
    	    
            WebElement menuElement = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[text()='Example 1: Menu Element']")));
            menuElement.click();
         
            WebElement home = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[text()='Home']")));
            home.click();
            
            WebElement shiftingContent1 = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[text()='Shifting Content']")));
            shiftingContent1.click();
                  
            WebElement image = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[text()='Example 2: An image']")));
            image.click();
            
            WebElement imageDisplays = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//img[@class='shift']")));
                System.out.println("Verify image: Displayed = "
                    + imageDisplays.isDisplayed()); // prints: true

                // ✅ Navigate back to reach Example 3
//                driver.navigate().back();
                
            WebElement displaysList = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(
                            By.xpath("//div[@class='large-6 columns large-centered']")));
                    System.out.println("Verify list: " + displaysList.getText()); 

    } catch (org.openqa.selenium.WebDriverException e) {
        System.out.println("WebDriver error: " + e.getMessage());
        
    } finally {
        // ✅ Always quit safely
        if (driver != null) {
            driver.quit();	    
    	    
    	    
    	}
	}
}


}
