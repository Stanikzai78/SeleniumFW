package com.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.framework.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static void initDriver() {
        String browser = ConfigReader.get("browser");

        if (browser != null && browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}













//package com.framework.driver;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class DriverFactory {
//
//    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
//
//    public static void initDriver(String browser) {
//        WebDriver driver;
//
//        switch (browser.toLowerCase()) {
//            case "firefox":
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver(new FirefoxOptions());
//                break;
//
//            case "edge":
//                WebDriverManager.edgedriver().setup();
//                driver = new EdgeDriver(new EdgeOptions());
//                break;
//
//            case "chrome":
//            default:
//                WebDriverManager.chromedriver().setup();
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--remote-allow-origins=*");
//                driver = new ChromeDriver(options);
//                break;
//        }
//
//        driver.manage().window().maximize();
//        DRIVER.set(driver);
//    }
//
//    public static WebDriver getDriver() {
//        if (DRIVER.get() == null) {
//            throw new IllegalStateException("Driver is not initialized. Call initDriver() first.");
//        }
//        return DRIVER.get();
//    }
//
//    public static void quitDriver() {
//        if (DRIVER.get() != null) {
//            DRIVER.get().quit();
//            DRIVER.remove();
//        }
//    }
//}