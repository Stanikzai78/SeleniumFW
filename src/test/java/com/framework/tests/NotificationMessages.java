package com.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NotificationMessages {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	driver.get("https://the-internet.herokuapp.com");
    	
    	WebElement notificationMeassages = driver.findElement(By.xpath("//a[text() ='Notification Messages']"));
    	notificationMeassages .click();
    	
    	WebElement notificationMeassage = driver.findElement(By.xpath("//div[@class ='example']"));
    	notificationMeassage .click();
    	
    	System.out.println("Verify notification message:" +notificationMeassage.getText());


	}

}
