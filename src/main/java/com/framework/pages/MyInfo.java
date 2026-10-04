package com.framework.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyInfo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement username = driver.findElement(By.name("username"));
		username.clear(); username.sendKeys("Admin");
		WebElement password = driver.findElement(By.name("password"));
		password.clear(); password.sendKeys("admin123");
		driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7");
		driver.findElement(By.xpath("//span[text()='My Info']")).click();Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='orangehrm-tabs-item --active']")).click();
		
		WebElement firstNameInput = driver.findElement(By.name("firstName"));
		wait.until(d -> !firstNameInput.getAttribute("value").isEmpty());
		firstNameInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		firstNameInput.sendKeys("Mohammad");
		WebElement lastNameInput = driver.findElement(By.name("lastName"));
		wait.until(d -> !lastNameInput.getAttribute("value").isEmpty());
		lastNameInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		lastNameInput.sendKeys("Stanikzai");
		
		WebElement driverLicenseInput = driver.findElement(By.xpath("//label[contains(.,'Driver')]/following::input[1]"));
		driverLicenseInput.clear(); driverLicenseInput.sendKeys("1111111");
		WebElement licenseExpiryInput = driver.findElement(By.xpath("//label[normalize-space()='License Expiry Date']/following::input[1]"));
		licenseExpiryInput.clear(); licenseExpiryInput.sendKeys("2026-11-06");

		driver.findElement(By.xpath("//label[normalize-space()='Nationality']/following::div[contains(@class,'oxd-select-text')][1]")).click();
		driver.findElement(By.xpath("//div[@role='listbox']//span[normalize-space()='Afghan']")).click();


		WebElement maleRadio = driver.findElement(By.xpath("//label[normalize-space()='Male']/input[@type='radio']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", maleRadio);


		driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Save'])[1]")).click();

		driver.findElement(By.xpath("//label[normalize-space()='Blood Type']/following::div[contains(@class,'oxd-select-text')][1]")).click();
		driver.findElement(By.xpath("//div[@role='listbox']//span[normalize-space()='B+']")).click();


		driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Save'])[2]")).click();

		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\mssta\\OneDrive\\Desktop\\Resumes\\coverletter.docx");
		driver.findElement(By.xpath("//h6[normalize-space()='Add Attachment']/following::button[normalize-space()='Save'][1]")).click();

		driver.findElement(By.xpath("(//div[contains(@class,'oxd-table-card')]//button)[last()]")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Yes, Delete']")).click();

		driver.quit();
	}
}