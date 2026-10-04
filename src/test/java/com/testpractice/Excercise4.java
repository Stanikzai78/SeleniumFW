package com.testpractice;   // match your actual package

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Excercise4 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://proleed.academy/exercises/selenium/automation-practice-form-with-radio-button-check-boxes-and-drop-down.php");

		// Use Select class
		Select prefix = new Select(driver.findElement(By.id("prefix")));
		prefix.selectByIndex(1);

		driver.findElement(By.id("firstname")).sendKeys("Enter your Name");
		driver.findElement(By.id("lastname")).sendKeys("Enter last name");

		// styled radios/checkboxes -> JS click avoids "not clickable at point" interception
		jsClick(driver, driver.findElement(By.id("pension")));

		driver.findElement(By.name("fathername")).sendKeys("Enter Father Name");
		driver.findElement(By.name("mothername")).sendKeys("Enter Mother Name");

		jsClick(driver, driver.findElement(By.id("studentid")));

		driver.findElement(By.id("identity_number")).sendKeys("Enter Identity number");

		jsClick(driver, driver.findElement(By.id("male")));

		Select month = new Select(driver.findElement(By.id("dob_month")));
		month.selectByVisibleText("December");

		Select date = new Select(driver.findElement(By.id("dob_date")));
		date.selectByVisibleText("25");

		Select year = new Select(driver.findElement(By.id("dob_year")));
		year.selectByVisibleText("1985");

		jsClick(driver, driver.findElement(By.id("single")));

		Select countrycode = new Select(driver.findElement(By.id("country_code")));
		countrycode.selectByVisibleText("Australia (+61)");

		driver.findElement(By.id("mobile")).sendKeys("Enter mobile number here");

		Select nationality = new Select(driver.findElement(By.id("nationality")));
		nationality.selectByVisibleText("American");

		driver.findElement(By.name("address")).sendKeys("enter address here");
		driver.findElement(By.id("state")).sendKeys("enter state here");

		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByVisibleText("Antarctica");

		WebElement submit = driver.findElement(
				By.xpath("/html/body/div[3]/div/div[2]/div/form/div[15]/div[2]/input"));
		jsClick(driver, submit);
	}

	// scrolls element to center, then clicks via JavaScript
	public static void jsClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
		js.executeScript("arguments[0].click();", element);
	}
}