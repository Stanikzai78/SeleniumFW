package com.frameworkaut.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyInfo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// 1) LOGIN PAGE
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// wait for the React form to actually render
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

		// 2) LOG IN
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
		
		
	}
}