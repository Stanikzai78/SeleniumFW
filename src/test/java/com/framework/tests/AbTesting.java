package com.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbTesting {

		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://the-internet.herokuapp.com/");
////	    <a href="/abtest">A/B Testing</a>
////	        WebElement abTestingClick = driver.findElement(By.linkText("A/B Testing"));
////	        abTestingClick.click();
////	     <a href="/add_remove_elements/">Add/Remove Elements</a>
//	        WebElement addremoveelement = driver.findElement(By.linkText("Add/Remove Elements"));
//	        addremoveelement.click();
//	        Thread.sleep(5000);
//////	       <button onclick="addElement()">Add Element</button> 
//	        WebElement addElementBtn = driver.findElement(By.xpath("//button[text()='Add Element']"));
//	        addElementBtn.click();
//////	        <button class="added-manually" onclick="deleteElement()">Delete</button>       
//	        WebElement deleteBtn = driver.findElement(By.xpath("//button[@class='added-manually']"));
//	        deleteBtn.click();
//	        
//	        WebElement brokenImages = driver.findElement(By.linkText("Broken Images"));
//	        brokenImages.click();
//	//
//	        // Verify we are on Broken Images page by checking the <h3> text
	        WebElement verifyBrokenImageHeading =
	                driver.findElement(By.xpath("//h3[text()='Broken Images']"));
	//
	        if (verifyBrokenImageHeading.isDisplayed()) {
	            System.out.println("verifyBrokenImageHeading passed");
	        } else {
	            System.out.println("verifyBrokenImageHeading failed");
	        }
	       
	        WebElement bazField = driver.findElement(By.xpath("//[@class='button']"));
	        bazField.click();
	    
	        WebElement challengingDom = driver.findElement(By.linkText("Challenging DOM"));
	        challengingDom.click();
//	        <a id="65e2fdd0-3452-013f-1f55-4eb7cec980a9" href="" class="button">baz</a>
//	        the baz field changes frequently in order to avoid that I added 1 on it
	        WebElement blueButton = driver.findElement(By.xpath("(//a[@class='button'])[1]"));
	        blueButton.click();
	        
	        WebElement barButton = driver.findElement(By.xpath("(//a[@class='button alert'])[1]"));
	        barButton.click();
	        
	        
		}

	}


	


