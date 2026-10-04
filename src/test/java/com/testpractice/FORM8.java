package com.testpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FORM8 {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://proleed.academy/exercises/selenium/emi-calculator-for-home-loan.php");

		driver.manage().window().maximize();
		WebElement loan = driver.findElement(By.id("loanamount"));

		// Using Actions Class
		Actions a = new Actions(driver);
		a.moveToElement(loan).click().sendKeys("100000", Keys.TAB).sendKeys("2", Keys.TAB).sendKeys("12", Keys.TAB)
				.sendKeys(Keys.ENTER).perform();

		String calculatedEMI = driver.findElement(By.id("emi")).getAttribute("value");

		String expectedEMI = "8424";

		if (calculatedEMI.equals(expectedEMI)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fails");
		}
		driver.close();
	}
}
