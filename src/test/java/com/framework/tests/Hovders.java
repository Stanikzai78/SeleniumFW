package com.framework.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hovders {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	driver.get("https://the-internet.herokuapp.com");
    	
    	WebElement hoversButton = wait.until(
    	        ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Hovers']"))
    	);hoversButton.click();
    	WebElement firstImage = wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@alt='User Avatar'])[1]"))
    	);
    	Actions actions = new Actions(driver);
    	actions.moveToElement(firstImage).perform();
    	Thread.sleep(5000);
   	
    	WebElement firstAvatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='figure'])[1]")));
        actions.moveToElement(firstAvatar).perform();
        Thread.sleep(5000);

    	WebElement secondAvatar =
    	driver.findElement(By.xpath("(//img[@alt='User Avatar'])[2]"));
    	actions.moveToElement(secondAvatar).perform();
    	Thread.sleep(5000);
        WebElement user1Name = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.xpath("//h5[text()='name: user1']")));
        System.out.println("Hover text: " + user1Name.getText()); // prints: name: user1


	}

}
