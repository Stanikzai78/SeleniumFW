package com.framework.base;

import java.time.Duration;

import com.framework.driver.DriverFactory;
import com.framework.utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static final int MAX_RETRIES = 3;
    private static final long RETRY_DELAY_MS = 300;
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(15);

    public BasePage() {}

    public BasePage(WebDriver driver) {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    private WebDriverWait getWait() {
        return new WebDriverWait(DriverFactory.getDriver(), DEFAULT_TIMEOUT);
    }

    public void click(WebElement element) {
        StaleElementReferenceException stale = null;
        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                WaitUtils.waitForClickable(element);
                element.click();
                return;
            } catch (ElementClickInterceptedException e) {
                scrollIntoView(element);
                jsClick(element);
                return;
            } catch (StaleElementReferenceException e) {
                stale = e;
                pause();
            } catch (TimeoutException e) {
                if (attempt == MAX_RETRIES) {
                    if (isPresent(element)) {
                        scrollIntoView(element);
                        jsClick(element);
                        return;
                    }
                    throw notClickable(describe(element), e);
                }
                pause();
            }
        }
        throw new StaleElementReferenceException("Element stayed stale after " + MAX_RETRIES
                + " attempts: " + describe(element), stale);
    }

    public void click(By locator) {
        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                WebElement element = getWait().until(ExpectedConditions.elementToBeClickable(locator));
                element.click();
                return;
            } catch (ElementClickInterceptedException e) {
                WebElement element = getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
                scrollIntoView(element);
                jsClick(element);
                return;
            } catch (StaleElementReferenceException e) {
                pause();
            } catch (TimeoutException e) {
                if (attempt == MAX_RETRIES) {
                    WebElement present = findIfPresent(locator);
                    if (present != null) {
                        scrollIntoView(present);
                        jsClick(present);
                        return;
                    }
                    throw notClickable(locator.toString(), e);
                }
                pause();
            }
        }
        throw new StaleElementReferenceException("Element stayed stale after " + MAX_RETRIES
                + " attempts: " + locator);
    }

    public void type(WebElement element, String value) {
        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                WaitUtils.waitForVisibility(element);
                clearAndType(element, value);
                return;
            } catch (ElementClickInterceptedException e) {
                scrollIntoView(element);
                jsClick(element);
                clearAndType(element, value);
                return;
            } catch (StaleElementReferenceException e) {
                pause();
            }
        }
        throw new StaleElementReferenceException("Element stayed stale while typing: " + describe(element));
    }

    private void clearAndType(WebElement element, String value) {
        element.click();
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
        element.sendKeys(value);
    }

    public void selectFromDropdown(WebElement dropdown, String value) {
        click(dropdown);
        By optionLocator = By.xpath("//div[@role='option' and normalize-space()='" + value + "']");
        click(optionLocator);
    }

    public void jsClick(WebElement element) {
        WaitUtils.waitForVisibility(element);
        ((JavascriptExecutor) DriverFactory.getDriver())
                .executeScript("arguments[0].click();", element);
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) DriverFactory.getDriver())
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    public String getText(WebElement element) {
        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                WaitUtils.waitForVisibility(element);
                return element.getText().trim();
            } catch (StaleElementReferenceException e) {
                pause();
            }
        }
        throw new StaleElementReferenceException("Element stayed stale while reading text: " + describe(element));
    }

    public boolean isDisplayed(WebElement element) {
        try {
            WaitUtils.waitForVisibility(element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getAttribute(WebElement element, String attributeName) {
        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                WaitUtils.waitForVisibility(element);
                return element.getAttribute(attributeName);
            } catch (StaleElementReferenceException e) {
                pause();
            }
        }
        throw new StaleElementReferenceException("Element stayed stale while reading attribute: " + describe(element));
    }

    public void waitUntilVisible(WebElement element) {
        WaitUtils.waitForVisibility(element);
    }

    public void waitUntilClickable(WebElement element) {
        WaitUtils.waitForClickable(element);
    }

    public void waitUntilInvisible(WebElement element) {
        WaitUtils.waitForInvisibility(element);
    }

    public void waitUntilTextPresent(WebElement element, String text) {
        WaitUtils.waitForTextToBePresent(element, text);
    }

    public void waitUntilSelected(WebElement element) {
        WaitUtils.waitForElementToBeSelected(element);
    }

    private boolean isPresent(WebElement element) {
        try {
            element.isEnabled();
            return true;
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    private WebElement findIfPresent(By locator) {
        try {
            return DriverFactory.getDriver().findElement(locator);
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return null;
        }
    }

    private TimeoutException notClickable(String target, Throwable cause) {
        return new TimeoutException("Element never became clickable after " + MAX_RETRIES
                + " attempts and was not found in the DOM."
                + "\n  Target : " + target
                + "\n  URL    : " + currentUrl()
                + "\n  Title  : " + title()
                + "\n  Hint   : the driver is most likely on the wrong page. Verify navigation/login before this click.",
                cause);
    }

    private String currentUrl() {
        try {
            return DriverFactory.getDriver().getCurrentUrl();
        } catch (Exception e) {
            return "<unavailable>";
        }
    }

    private String title() {
        try {
            return DriverFactory.getDriver().getTitle();
        } catch (Exception e) {
            return "<unavailable>";
        }
    }

    private void pause() {
        try {
            Thread.sleep(RETRY_DELAY_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private String describe(WebElement element) {
        try {
            return element.toString();
        } catch (Exception e) {
            return "<unknown element>";
        }
    }
}
