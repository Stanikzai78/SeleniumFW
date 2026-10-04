package com.framework.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQuireyUIMenus {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
//    	driver.manage().window().maximize();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	driver.get("https://the-internet.herokuapp.com");
    	
    	WebElement jqueryUi = driver.findElement(By.xpath("//a[text()='JQuery UI Menus']"));
    	jqueryUi.click();
    	
    	WebElement EnabledButton = driver.findElement(By.xpath("//a[text()='Enabled']"));
    	EnabledButton.click();
    	
    	WebElement downloaddButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Downloads']")));
    	downloaddButton.click();
    	
    	WebElement pdfButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='PDF']")));
    	pdfButton.click();

	}

}
