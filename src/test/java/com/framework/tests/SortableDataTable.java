package com.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortableDataTable {

	public static void main(String[] args) {
		   WebDriverManager.chromedriver().setup();

	        WebDriver driver = new ChromeDriver();

	        driver.manage().window().maximize();

	        driver.get("https://the-internet.herokuapp.com/tables");

	        // First row data
	        WebElement firstRow = driver.findElement(
	                By.xpath("(//table[@id='table2']//tr)[5]"));

	        // Print complete first row
	        System.out.println(firstRow.getText());

//	        driver.quit();

	}

}
