package com.testpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excercise2 {
	public static void main(String[] args) {
		// Launch Chrome Browser
		WebDriver driver = new ChromeDriver();

		// Open URL
		driver.get("https://proleed.academy/exercises/selenium/selenium-element-name-locators-practice-form.php");

		// Locate full name by name locator
		WebElement fullname = driver.findElement(By.name("name"));
		fullname.sendKeys("Enter Full Name here");

		// Locate mobile number by name locator
		WebElement mobilenumber = driver.findElement(By.name("mobile"));
		mobilenumber.sendKeys("Enter your mobile number here");

		// Locate email address by name locator
		WebElement emailaddress = driver.findElement(By.name("email"));
		emailaddress.sendKeys("example@gmail.com");

		// Locate password by name locator
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("password123");

		// Locate submit button by name locator and click on it
		WebElement submit = driver.findElement(By.name("submit"));
		submit.click();
	}

}
