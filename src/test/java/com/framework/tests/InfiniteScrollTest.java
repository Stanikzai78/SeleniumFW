package com.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InfiniteScrollTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com");

            WebElement scrollButton = driver.findElement(By.xpath("//a[@href='/infinite_scroll']"));
            scrollButton.click();

            JavascriptExecutor js = (JavascriptExecutor) driver;

            long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

            while (true) {
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(2000);

                long newHeight = (long) js.executeScript("return document.body.scrollHeight");

                if (newHeight == lastHeight) {
                    break;
                }

                lastHeight = newHeight;
            }

        } finally {
            driver.quit();

	}

	}
}
