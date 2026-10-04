package com.testpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excercise3 {
public static void main(String[] args) {
		
		// Launch Chrome Browser
		WebDriver driver = new ChromeDriver();

		// Open URL
		driver.get("https://proleed.academy/exercises/selenium/selenium-element-locators-practice-form.php");

		// Locate full name by xpath locator
		WebElement fullname = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/form/input[1]"));
		fullname.sendKeys("Enter Full Name here");

		// Locate email address by xpath locator
		WebElement emailaddress = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/form/input[2]"));
		emailaddress.sendKeys("example@gmail.com");

		// Locate mobile number by css selector
		WebElement message = driver
				.findElement(By.cssSelector("body > div.asgWrapper > div > div > div > form > textarea"));
		message.sendKeys("Enter message here");

		// Locate submit button by xpath locator and click on it
		WebElement submit = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/form/input[3]"));
		submit.click();
	}

}
