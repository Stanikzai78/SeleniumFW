package com.framework.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickTest {

	
	  WebDriver driver;

	    @BeforeMethod
	    public void setUpMethod() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();   // fixed here

	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://demo.guru99.com/test/newtours/index.php");
	    }
	@Test
	public void seleniumlink() throws InterruptedException {
	    WebElement seleniumlink = driver.findElement(By.xpath("//a[normalize-space()='Selenium']"));
	    
	 // Initialize Actions class
        Actions actions = new Actions(driver);
        Thread.sleep(10000);
        // Right-click on the link, navigate down the context menu, and press Enter
       
        actions.contextClick(seleniumlink)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.RETURN)
                .perform();
        Thread.sleep(10000);

}
}
