package com.testpractice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise7 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// IMPORTANT: paste YOUR original working URL here (the one from the run
		// that got past the name field). The guessed one below may be wrong.
		driver.get("https://proleed.academy/exercises/selenium/online-job-application-form-for-practice.php");

		driver.findElement(By.id("name")).sendKeys("enter name");

		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("example@gma.com");

		driver.findElement(By.id("phone")).sendKeys("enter ");

		Select position = new Select(driver.findElement(By.name("position")));
		position.selectByVisibleText("Quality Analyst");

		clickJS(js, driver.findElement(By.id("employed")));

		driver.findElement(By.id("resume"))
				.sendKeys("C:\\Users\\mssta\\OneDrive\\Desktop\\Resumes\\coverletter.docx");

		Select platform = new Select(driver.findElement(By.name("platform")));
		platform.selectByVisibleText("Google Search");

		clickJS(js, driver.findElement(By.id("add")));

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		String expectedalertText = "Your application has been submitted";
		System.out.println(alertText);

		if (expectedalertText.equals(alertText)) {
			System.out.println("Alert message is correct");
		} else {
			System.out.println("Unexpected alert message: " + alertText);
		}

		alert.dismiss();
	}

	// Helper: scroll element into view, then click it via JavaScript
	private static void clickJS(JavascriptExecutor js, WebElement element) {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
		js.executeScript("arguments[0].click();", element);
	}

}