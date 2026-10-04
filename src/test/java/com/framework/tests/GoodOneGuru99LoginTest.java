package com.framework.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoodOneGuru99LoginTest {
	
	WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	driver.get("https://demo.guru99.com/test/login.html");
//    	WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
}
    @Test
    public void guru99LoginTest(){
    	
    	WebElement emailAddressInput = driver.findElement(By.id("email"));
    	emailAddressInput.sendKeys("sstanikzai78@gmail.com");
    	
    	WebElement passwordInput =driver.findElement(By.id("passwd"));
    	passwordInput.sendKeys("Ruya2014");
    	
    	WebElement signInBtn = driver.findElement(By.id("SubmitLogin"));
    	signInBtn.click();
    		
    	WebElement LoggedSuccessful = driver.findElement(By.xpath("//h3[text()='Successfully Logged in...']"));
    	
    	String actualMessage = LoggedSuccessful.getText();
    	System.out.println("LoggedSucessful:" + actualMessage);
    	if(actualMessage.equals("Successfully Logged in...")) {
    	System.out.println("Logged Successful");
    	}else {System.out.println("Logged Successful");
    	
    	String actualTitle = driver.getTitle();
    	System.out.println("Page Title: " + actualTitle);
    	}}
    	
    @AfterMethod
    public void tearDown() {
    if (driver!=null) {
    	driver.quit();
    }

    	
}
}
    	
    
    