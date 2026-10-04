package com.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckOutTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        
////        <a href="/checkboxes">Checkboxes</a>
        WebElement addElementBtn = driver.findElement(By.linkText("Checkboxes"));
        addElementBtn.click();
        
        WebElement addElementBtn1 = driver.findElement(By.xpath("//input[@type='checkbox']"));
       addElementBtn1.click();
//        
//     // Check
        if (!addElementBtn1.isSelected()) {
        	addElementBtn1.click();
            System.out.println("Checked");
        } else {
            System.out.println("Already checked");
        }
       
//     // Uncheck
        if (addElementBtn1.isSelected()) {
        	addElementBtn1.click();
            System.out.println("Unchecked");
        } else {
            System.out.println("Already unchecked");
        }
        
        WebElement ContextMenue = driver.findElement(By.linkText("Context Menu"));
        ContextMenue .click();
//        <h3>Context Menu</h3>
        WebElement displayedContextMenu =
                driver.findElement(By.xpath("//h3[contains(text(),'Context Menu')]"));

        System.out.println(displayedContextMenu.getText());
  

	}

}
