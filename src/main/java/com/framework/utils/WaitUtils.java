package com.framework.utils;

import java.time.Duration;

import com.framework.driver.DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private static final int TIMEOUT = 10;

    public static WebElement waitForVisibility(By locator) {
        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForVisibility(WebElement element) {
        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForClickable(WebElement element) {
        new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForInvisibility(WebElement element) {
        new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForTextToBePresent(WebElement element, String text) {
        new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void waitForElementToBeSelected(WebElement element) {
        new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.elementToBeSelected(element));
    }
    public static void waitForInvisibility(org.openqa.selenium.By locator) {
        new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}