package com.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Inputs {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
//    	driver.manage().window().maximize();
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	driver.get("https://the-internet.herokuapp.com");
    	
    	WebElement inputs = driver.findElement(By.xpath("//a[@href='/inputs']"));
    	inputs.click();
    	
    	WebElement numberInputs = driver.findElement(By.xpath("//input[@type='number']"));
    	numberInputs.click();
    	
    	WebElement numberField = driver.findElement(By.tagName("input"));
        numberField.click();
        numberField.sendKeys(Keys.ARROW_UP);
        Thread.sleep(5000);
        numberField.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(5000);
        
        numberField.clear();
        numberField.sendKeys("10");

	}

}
