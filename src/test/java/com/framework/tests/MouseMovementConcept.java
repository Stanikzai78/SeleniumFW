package com.framework.tests;



	import java.time.Duration;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class MouseMovementConcept {

		WebDriver driver;

	    @BeforeMethod
	    public void setUpMethod() throws InterruptedException {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://seleniumbase.github.io/demo_page?utm_source=chatgpt.com");}
	    
	    @Test
	    public void mouseAction() throws InterruptedException{
	           {
	        	   WebElement hoverDropdown = driver.findElement(By.id("myDropdown"));
	        	   Actions actions = new Actions(driver);
	        	   actions.moveToElement(hoverDropdown).perform();
	               Thread.sleep(1000);
	            // 2) Hover Link One
	               WebElement linkOne = driver.findElement(By.id("dropOption1"));
	               actions.moveToElement(linkOne).perform();
	               Thread.sleep(1000);
	               // 3) Hover Link Two
	               WebElement linkTwo = driver.findElement(By.id("dropOption2"));
	               actions.moveToElement(linkTwo).perform();
	               Thread.sleep(1000); 
	            // 4) Hover Link Three
	               WebElement linkThree = driver.findElement(By.id("dropOption3"));
	               actions.moveToElement(linkThree).perform();
	               Thread.sleep(1000);
	               linkThree.click();




	}

}
}