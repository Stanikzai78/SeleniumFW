package com.testpractice;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Excercise5 {

	public static void main(String[] args) {

		// Launch chrome browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Open Url
		driver.get("https://proleed.academy/exercises/selenium/automate-the-signup-form-using-selenium-webdriver.php");

		driver.findElement(By.name("firstname")).sendKeys("enter name");
		driver.findElement(By.name("lastname")).sendKeys("enter last name");

		// JS click to avoid overlay interception
		clickJS(js, driver.findElement(By.id("male")));

		// Select class for drop-down
		Select experience = new Select(driver.findElement(By.name("experience")));
		experience.selectByVisibleText("5");

		driver.findElement(By.id("date")).sendKeys("16/08/2023");

		clickJS(js, driver.findElement(By.id("automation")));

		// Find all checkboxes
		List<WebElement> skills = driver.findElements(By.name("skills"));
		System.out.println("No. of checkboxes are " + skills.size());

		clickJS(js, skills.get(2));
		clickJS(js, skills.get(5));

		// Select class for drop-down
		Select country = new Select(driver.findElement(By.name("country")));
		country.selectByVisibleText("Afghanistan");

		driver.findElement(By.name("photo"))
				.sendKeys("C:\\Users\\mssta\\OneDrive\\Desktop\\Resumes\\coverletter.docx");
		

		// Submit
		clickJS(js, driver.findElement(By.id("add")));

		// Switch to alert
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);

		if ("Form submitted".equals(alertText)) {
			System.out.println("Alert message is correct");
		} else {
			System.out.println("Unexpected alert message: " + alertText);
		}

		alert.accept();
	}

	// Helper: scroll element into view, then click it via JavaScript
	private static void clickJS(JavascriptExecutor js, WebElement element) {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
		js.executeScript("arguments[0].click();", element);
	}
}