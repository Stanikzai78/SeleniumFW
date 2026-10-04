package com.testpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NgParameterizedTest {
	public static WebDriver driver;

	@Test
	@Parameters({ "EmailAddress", "Password" })
	public void loginMethod(@Optional("mstanikzai@yahoo.com") String EmailAddress,
			@Optional("yourPassword") String Password) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php");
		driver.findElement(By.id("email")).sendKeys(EmailAddress);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.id("login")).click();
	}
}