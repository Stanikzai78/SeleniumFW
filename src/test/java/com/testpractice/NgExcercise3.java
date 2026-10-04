package com.testpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public abstract class NgExcercise3 {

	@Test(dataProvider = "credentials")
	public void testlogin(String email, String password) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php");
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		
	}

	@DataProvider
	public Object[][] credentials() {
	return new Object[][] { 
	{"abc@gmail.com", "pass1"}, 
	{"xyz@gmail.com", "pass2"},
	{"abc@yahoo.com", "pass3"}
	};    
	}
	}