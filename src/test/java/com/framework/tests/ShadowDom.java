package com.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDom {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	driver.get("https://the-internet.herokuapp.com");
    	
    	WebElement ShadowInput = driver.findElement(By.xpath("//a[text() ='Shadow DOM']"));
    	ShadowInput .click();
    	
    	WebElement ShadowSimple = driver.findElement(By.xpath("//span[@slot ='my-text']"));
    	System.out.println("Display shadow:"+ ShadowSimple.getText());
    	

	}

}
