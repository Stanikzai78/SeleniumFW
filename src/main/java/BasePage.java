


	

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

	public class BasePage {

	    private static final int MAX_RETRIES = 3;
	    private static final long RETRY_DELAY_MS = 300;
	    private WebDriver driver;

	    public BasePage() {
	        this.driver = DriverFactory.getDriver();
	        PageFactory.initElements(driver, this);
	    }

	    public BasePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    // ============ CLICK ACTIONS ============
	    public void click(WebElement element) {
	        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
	            try {
	                WaitUtils.waitForClickable(element);
	                element.click();
	                log("Clicked element: " + describeElement(element));
	                return;
	            } catch (ElementClickInterceptedException e) {
	                scrollIntoView(element);
	                jsClick(element);
	                return;
	            } catch (StaleElementReferenceException e) {
	                if (attempt == MAX_RETRIES) throw e;
	                pause();
	            }
	        }
	    }

	    public void click(By locator) {
	        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
	            try {
	                WebElement element = WaitUtils.waitForVisibility(locator);
	                element.click();
	                log("Clicked locator: " + locator);
	                return;
	            } catch (ElementClickInterceptedException e) {
	                WebElement element = WaitUtils.waitForVisibility(locator);
	                scrollIntoView(element);
	                jsClick(element);
	                return;
	            } catch (StaleElementReferenceException e) {
	                if (attempt == MAX_RETRIES) throw e;
	                pause();
	            }
	        }
	    }

	    public void jsClick(WebElement element) {
	        WaitUtils.waitForVisibility(element);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	        log("Clicked via JavaScript: " + describeElement(element));
	    }

	    // ============ TYPE ACTIONS ============
	    public void type(WebElement element, String value) {
	        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
	            try {
	                WaitUtils.waitForVisibility(element);
	                clearAndType(element, value);
	                log("Typed into element: " + value);
	                return;
	            } catch (StaleElementReferenceException e) {
	                if (attempt == MAX_RETRIES) throw e;
	                pause();
	            }
	        }
	    }

	    public void type(By locator, String value) {
	        WebElement element = WaitUtils.waitForVisibility(locator);
	        type(element, value);
	    }

	    public void clear(WebElement element) {
	        WaitUtils.waitForVisibility(element);
	        element.clear();
	        log("Cleared element: " + describeElement(element));
	    }

	    private void clearAndType(WebElement element, String value) {
	        element.click();
	        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	        element.sendKeys(Keys.DELETE);
	        element.sendKeys(value);
	    }

	    // ============ SELECT/DROPDOWN ============
	    public void selectDropdown(WebElement dropdown, String value) {
	        click(dropdown);
	        By optionLocator = By.xpath("//div[@role='option' and normalize-space()='" + value + "']");
	        click(optionLocator);
	        log("Selected dropdown value: " + value);
	    }

	    // ============ READ ACTIONS ============
	    public String getText(WebElement element) {
	        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
	            try {
	                WaitUtils.waitForVisibility(element);
	                String text = element.getText().trim();
	                log("Read text: " + text);
	                return text;
	            } catch (StaleElementReferenceException e) {
	                if (attempt == MAX_RETRIES) throw e;
	                pause();
	            }
	        }
	        return "";
	    }

	    public String getText(By locator) {
	        return getText(WaitUtils.waitForVisibility(locator));
	    }

	    public String getAttribute(WebElement element, String attributeName) {
	        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
	            try {
	                WaitUtils.waitForVisibility(element);
	                String value = element.getAttribute(attributeName);
	                log("Read attribute '" + attributeName + "': " + value);
	                return value;
	            } catch (StaleElementReferenceException e) {
	                if (attempt == MAX_RETRIES) throw e;
	                pause();
	            }
	        }
	        return "";
	    }

	    public String getAttribute(By locator, String attributeName) {
	        return getAttribute(WaitUtils.waitForVisibility(locator), attributeName);
	    }

	    // ============ VERIFICATION ACTIONS ============
	    public boolean isDisplayed(WebElement element) {
	        try {
	            WaitUtils.waitForVisibility(element);
	            return element.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public boolean isDisplayed(By locator) {
	        try {
	            WaitUtils.waitForVisibility(locator);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public boolean isEnabled(WebElement element) {
	        try {
	            return element.isEnabled();
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public boolean isSelected(WebElement element) {
	        try {
	            return element.isSelected();
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    // ============ WAIT ACTIONS ============
	    public void waitForVisibility(WebElement element) {
	        WaitUtils.waitForVisibility(element);
	    }

	    public void waitForClickable(WebElement element) {
	        WaitUtils.waitForClickable(element);
	    }

	    public void waitForInvisibility(WebElement element) {
	        WaitUtils.waitForInvisibility(element);
	    }

	    public void waitForInvisibility(By locator) {
	        WaitUtils.waitForInvisibility(locator);
	    }

	    public void waitForText(WebElement element, String text) {
	        WaitUtils.waitForTextToBePresent(element, text);
	    }

	    public void waitForSelected(WebElement element) {
	        WaitUtils.waitForElementToBeSelected(element);
	    }

	    // ============ FRAME HANDLING ============
	    public void switchToFrame(int frameIndex) {
	        driver.switchTo().frame(frameIndex);
	        log("Switched to frame index: " + frameIndex);
	    }

	    public void switchToFrame(String frameNameOrId) {
	        driver.switchTo().frame(frameNameOrId);
	        log("Switched to frame: " + frameNameOrId);
	    }

	    public void switchToFrame(WebElement frameElement) {
	        WaitUtils.waitForVisibility(frameElement);
	        driver.switchTo().frame(frameElement);
	        log("Switched to frame element");
	    }

	    public void switchToFrame(By frameLocator) {
	        WebElement frameElement = WaitUtils.waitForVisibility(frameLocator);
	        driver.switchTo().frame(frameElement);
	        log("Switched to frame by locator: " + frameLocator);
	    }

	    public void switchToDefaultContent() {
	        driver.switchTo().defaultContent();
	        log("Switched to default content");
	    }

	    public void switchToParentFrame() {
	        driver.switchTo().parentFrame();
	        log("Switched to parent frame");
	    }

	    // ============ SCROLL ACTIONS ============
	    public void scrollIntoView(WebElement element) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	        log("Scrolled to element");
	    }

	    public void scrollToTop() {
	        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
	        log("Scrolled to top");
	    }

	    public void scrollToBottom() {
	        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        log("Scrolled to bottom");
	    }

	    // ============ NAVIGATION ============
	    public void navigateTo(String url) {
	        driver.navigate().to(url);
	        log("Navigated to URL: " + url);
	    }

	    public void refresh() {
	        driver.navigate().refresh();
	        log("Page refreshed");
	    }

	    public String getCurrentUrl() {
	        String url = driver.getCurrentUrl();
	        log("Current URL: " + url);
	        return url;
	    }

	    public String getPageTitle() {
	        String title = driver.getTitle();
	        log("Page title: " + title);
	        return title;
	    }

	    // ============ UTILITY ACTIONS ============
	    public void acceptAlert() {
	        driver.switchTo().alert().accept();
	        log("Alert accepted");
	    }

	    public void dismissAlert() {
	        driver.switchTo().alert().dismiss();
	        log("Alert dismissed");
	    }

	    public String getAlertText() {
	        String alertText = driver.switchTo().alert().getText();
	        log("Alert text: " + alertText);
	        return alertText;
	    }

	    public void typeInAlert(String text) {
	        driver.switchTo().alert().sendKeys(text);
	        log("Typed in alert: " + text);
	    }

	    // ============ LOGGING ============
	    private void log(String message) {
	        System.out.println("[ACTION] " + message);
	    }

	    // ============ HELPER METHODS ============
	    private String describeElement(WebElement element) {
	        try {
	            return element.toString();
	        } catch (Exception e) {
	            return "<unknown element>";
	        }
	    }

	    private void pause() {
	        try {
	            Thread.sleep(RETRY_DELAY_MS);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }

	    public WebDriver getDriver() {
	        return driver;
	    }
	}
}
