package com.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploads {

	public static void main(String[] args) {
     
        WebDriverManager.chromedriver().setup();
    	WebDriver driver1 = new ChromeDriver();
//    	driver.manage().window().maximize();
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	driver1.get("https://the-internet.herokuapp.com");
    	
    	
    	WebElement uploadFile = driver1.findElement(By.linkText("File Upload"));
    	uploadFile .click();
    	
    	// Send file path directly to the input (no .click() needed)
    	WebElement browseFile = driver1.findElement(By.id("file-upload"));
    	browseFile.sendKeys("C:\\Users\\mssta\\OneDrive\\Desktop\\Resumes\\coverletter.docx");
    	// Click Upload button
    	WebElement uploadBtn = driver1.findElement(By.id("file-submit"));
    	uploadBtn.click();
    	
    	
//    	<h3>File Uploaded!</h3>
//    	WebElement fileUploaded = driver1.findElement(By.tagName("h3"));
//    	
//    	String actualText = fileUploaded.getText();
//    	System.out.println("fileUploaded: " + actualText);
//
//    	if (actualText.equals("File Uploaded!")) {
//    	    System.out.println("File successfully uploaded");
//    	} else {
//    	    System.out.println("File upload failed");

	}

	}

