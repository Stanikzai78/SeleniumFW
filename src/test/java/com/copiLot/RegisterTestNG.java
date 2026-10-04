package com.copiLot;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTestNG {
	WebDriver driver;
	WebDriverWait wait;

@BeforeMethod

public void setup () {	    	    
	       	WebDriver driver = new ChromeDriver(); 	       
	        driver.manage().window().maximize();  
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));}

@AfterMethod
public void tearDown() {
	if (driver != null)
		driver.quit();
}
@Test
public void testRegister() {
	driver.get("https://parabank.parasoft.com/parabank/register.htm");		
	WebElement registerLink =  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register")));
	registerLink.click();
	WebElement firstName = driver.findElement(By.id("customer.firstName"));
	firstName.sendKeys("Mohammad");
	WebElement lastName =  driver.findElement(By.id("customer.lastName"));
	lastName.sendKeys("Stanikzai");
	WebElement stAddress = driver.findElement(By.id("customer.address.street"));
	stAddress.sendKeys("123 Main St");
	WebElement cityAddress = driver.findElement(By.id("customer.address.city"));
	cityAddress.sendKeys("Haymarket");
	WebElement stateAddress = driver.findElement(By.id("customer.address.state"));
	stateAddress.sendKeys("Virginia");
	WebElement zipAddress =  driver.findElement(By.id("customer.address.zipCode"));
	zipAddress.sendKeys("20169");
	WebElement phoneNumber = driver.findElement(By.id("customer.phoneNumber"));
	phoneNumber.sendKeys("1234567890");
	WebElement SSN =  driver.findElement(By.id("customer.ssn"));
	SSN.sendKeys("123456789");
	WebElement userName = driver.findElement(By.id("customer.username"));
	userName.sendKeys("Stanikzai78");
	WebElement passWord = driver.findElement(By.id("customer.password"));
	passWord.sendKeys("Ruya@2014");
	WebElement RePassWord = driver.findElement(By.id("repeatedPassword"));
	RePassWord.sendKeys("Ruya@2014");
	WebElement register = driver.findElement(By.cssSelector("input[value='Register']"));
	register.click();
	        
	WebElement welcomeHeading = driver.findElement( By.cssSelector("div#rightPanel h1.title"));
	String actualwelcomHeading = welcomeHeading.getText();
	assertEquals(actualwelcomHeading,"Welcome Stanikzai78",
	"Your account was created successfully. You are now logged in.");


	}      

}
