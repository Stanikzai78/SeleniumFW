package com.testpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Excercise6 {

	public static void main(String[] args) {

		// Launch Chrome browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Open Url
		driver.get("https://proleed.academy/exercises/selenium/hotel-reservation-form-for-practice.php");

		driver.findElement(By.id("firstname")).sendKeys("enter first name here");
		driver.findElement(By.id("lastname")).sendKeys("enter last name");
		driver.findElement(By.name("address1")).sendKeys("enter address1 here");
		driver.findElement(By.name("address2")).sendKeys("enter address2 here");
		driver.findElement(By.id("city")).sendKeys("enter city name here");
		driver.findElement(By.id("state")).sendKeys("enter state here");
		driver.findElement(By.id("zipcode")).sendKeys("enter zip code");
		driver.findElement(By.id("phone")).sendKeys("enter mobile number");
		driver.findElement(By.id("email")).sendKeys("example@gmail.com");
		driver.findElement(By.id("checkindate")).sendKeys("17/08/2023");
		driver.findElement(By.id("checkintime")).sendKeys("05:59");
		driver.findElement(By.id("checkoutdate")).sendKeys("20/08/2023");
		driver.findElement(By.id("checkouttime")).sendKeys("04:59");

		clickJS(js, driver.findElement(By.id("deluxe")));

		// Select class for drop-down
		Select adults = new Select(driver.findElement(By.name("adults")));
		adults.selectByVisibleText("12");

		Select children = new Select(driver.findElement(By.name("children")));
		children.selectByIndex(3);

		driver.findElement(By.id("idproof"))
				.sendKeys("C:\\Users\\mssta\\OneDrive\\Desktop\\Resumes\\coverletter.docx");

		clickJS(js, driver.findElement(By.id("add")));

//		Alert alert = driver.switchTo().alert();
//		String alertText = alert.getText();
//		String expectedalertText = "Thanks! Your booking is confirmed.";
//		System.out.println(alertText);
//
//		if (expectedalertText.equals(alertText)) {
//			System.out.println("Alert message is correct");
//		} else {
//			System.out.println("Unexpected alert message: " + alertText);
//		}
//		alert.dismiss();
	}

	// Helper: scroll element into view, then click it via JavaScript
	private static void clickJS(JavascriptExecutor js, WebElement element) {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
		js.executeScript("arguments[0].click();", element);
	}

}