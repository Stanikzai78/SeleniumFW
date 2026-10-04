package com.framework.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDrException {

	public static void main(String[] args) {
		WebDriver driver = null;

        try {
            // ✅ Selenium 4.11+ manages chromedriver automatically
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get("https://example.com");

            System.out.println("Page title: " + driver.getTitle());

        } catch (WebDriverException e) {
            // ✅ Now correctly catches Selenium's WebDriverException
            System.out.println("WebDriver exception occurred: " + e.getMessage());

            // ✅ Log the cause
            System.out.println("Cause: " + e.getCause());

            // ✅ Retry logic placeholder
            System.out.println("Retrying...");

        } finally {
            // ✅ Always quit driver to release resources
            if (driver != null) {
                driver.quit();
            }
        }

	}

}
