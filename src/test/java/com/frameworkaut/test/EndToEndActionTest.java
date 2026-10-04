package com.frameworkaut.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

	public class EndToEndActionTest {

	    public static void main(String[] args) throws InterruptedException {

	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();

//	        driver.get("https://demoqa.com/menu");
////	        2. Mouse hover + click
	        Actions actions = new Actions(driver);
//	        WebElement mainMenu = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
//	        actions.moveToElement(mainMenu).build().perform();
//            Thread.sleep(5000);
//           
//            // 3. Double click
//	        driver.get("https://demoqa.com/buttons");
//            WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
//            actions.doubleClick(doubleClickBtn).build().perform();
//            Thread.sleep(5000);
//            
//         // 4. Right click (contextClick)
//            WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
//            actions.contextClick(rightClickBtn).build().perform();
//            Thread.sleep(5000);
                      
//         // 5. Click and hold + release
//            driver.get("https://demoqa.com/dragabble");
//            WebElement dragBox = driver.findElement(By.id("dragBox"));
//            actions.clickAndHold(dragBox).build().perform();
//            actions.release(dragBox).build().perform();
//            Thread.sleep(5000);
//            
//         // 6. Drag and drop
//            driver.get("https://demoqa.com/droppable");
//            WebElement source = driver.findElement(By.id("draggable"));
//            WebElement target = driver.findElement(By.id("droppable"));
//            actions.dragAndDrop(source, target).build().perform();
//            Thread.sleep(5000);
            
//	        // 8. Slider (clickAndHold + moveByOffset)
//            driver.get("https://demoqa.com/slider");
//            WebElement sliderHandle = driver.findElement(By.cssSelector("input[type='range']"));
//            actions.clickAndHold(sliderHandle)
//                   .moveByOffset(10, 0)
//                   .release()
//                   .build()
//                   .perform();
//            Thread.sleep(5000);
            
         // 9. Keyboard actions: keyDown, sendKeys, keyUp
            driver.get("https://demoqa.com/text-box");
            WebElement fullName = driver.findElement(By.id("userName"));
            fullName.click();
            actions.keyDown(Keys.SHIFT)
                   .sendKeys("automation tester")
                   .keyUp(Keys.SHIFT)
                   .build()
                   .perform();
            Thread.sleep(5000);
	        
	     
			// CTRL + A, CTRL + C, CTRL + V example
            actions.click(fullName).build().perform();
            Thread.sleep(5000);
            actions.keyDown(Keys.CONTROL)
                   .sendKeys("a")
                   .sendKeys("c")
                   .keyUp(Keys.CONTROL)
                   .build()
                   .perform();
            Thread.sleep(5000);
            
            WebElement email = driver.findElement(By.id("userEmail"));
            email.click();

            actions.keyDown(Keys.CONTROL)
                   .sendKeys("v")
                   .keyUp(Keys.CONTROL)
                   .build()
                   .perform();
            Thread.sleep(5000);

     
        }
    
	        }
	    
	