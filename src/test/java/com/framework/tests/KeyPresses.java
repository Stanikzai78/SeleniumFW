package com.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyPresses {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	driver.get("https://the-internet.herokuapp.com");
    	
    	WebElement keyPress= driver.findElement(By.xpath("//a[text()='Key Presses']"));
    	keyPress.click();
    	
    	WebElement keyPressInput= driver.findElement(By.xpath("//input[@id='target']"));
    	keyPressInput.click();
    	keyPressInput.sendKeys("Salam Ruyd");
    	
    	WebElement result = driver.findElement(By.id("result"));
    	System.out.println(result.getText());

	}

}
