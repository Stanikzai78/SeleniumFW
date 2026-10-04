package com.framework.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptAlert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	driver.get("https://the-internet.herokuapp.com");
    	
    	WebElement JSAlert = driver.findElement(By.xpath("//a[text()='JavaScript Alerts']"));
    	JSAlert.click();
    	
    	WebElement clickJSAlert = driver.findElement(By.xpath("//button[@onclick ='jsAlert()']"));
    	clickJSAlert.click();  	
    	Alert alert = driver.switchTo().alert();
    	String text = alert.getText();
    	System.out.println("Alert text:"+ text);
    	alert.accept();
    	
    	WebElement clickJSConfirm = driver.findElement(By.xpath("//button[@onclick ='jsConfirm()']"));
    	clickJSConfirm.click();
    	Alert alert1 = driver.switchTo().alert();
    	System.out.println("Actual text: " + alert1.getText());
    	alert.dismiss();
    	
    	WebElement clickJSPrompt = driver.findElement(By.xpath("//button[@onclick ='jsPrompt()']"));
    	clickJSPrompt.click();
    	Alert alert2 = driver.switchTo().alert();
    	System.out.println("Alert text:"+ alert2.getText());   	
    	alert.sendKeys("Hi Ruya");
    	alert.accept();

	}

}
