package com.testpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise1 {
	public static void main(String[] args) {

		// Launch Chrome Browser
		WebDriver driver = new ChromeDriver();

		// Open URL
		driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php");

		driver.manage().window().maximize();

		// Locate email address by ID locator
		WebElement emailaddress = driver.findElement(By.id("email"));
		emailaddress.sendKeys("example@gmail.com");

		// Locate password by ID locator
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("password123");

		// Locate submit button by ID locator and click on it
		WebElement submit = driver.findElement(By.id("login"));
		submit.click();

	}
}


