package com.framework.pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.framework.base.BasePage;
import com.framework.driver.DriverFactory;
import com.framework.utils.ConfigReader;
public class DemoPage extends BasePage {
    @FindBy(id = "myTextInput")
    private WebElement textInput;
    @FindBy(css = "textarea.area1")
    private WebElement textArea;
    @FindBy(name = "preText2")
    private WebElement preFilledField;
    @FindBy(id = "myDropdown")
    private WebElement hoverDropdown;
    @FindBy(id = "dropOption2")
    private WebElement dropOptionTwo;
    @FindBy(css = "button#myButton")
    private WebElement greenButton;
    @FindBy(id = "pText")
    private WebElement paragraphText;
    @FindBy(id = "mySlider")
    private WebElement slider;
    @FindBy(id = "mySelect")
    private WebElement selectDropdown;
    @FindBy(id = "radioButton2")
    private WebElement radioButtonTwo;
    @FindBy(id = "checkBox1")
    private WebElement checkBoxOne;
    public void open() {
        DriverFactory.getDriver().get(ConfigReader.get("demoUrl"));
    }
    public void enterText(String value)      { type(textInput, value); }
    public void enterTextArea(String value)  { type(textArea, value); }
    public void enterPreFilled(String value) { type(preFilledField, value); }
    public String getTextInputValue() { return getAttribute(textInput, "value"); }
    public void hoverAndClickOption2() {
        scrollIntoView(hoverDropdown);
        new Actions(DriverFactory.getDriver())
                .moveToElement(hoverDropdown)
                .pause(Duration.ofMillis(300))
                .perform();
        ((JavascriptExecutor) DriverFactory.getDriver())
                .executeScript("arguments[0].click();", dropOptionTwo);
    }
    public String getHeadingText() { return getText(headingH3()); }
    private WebElement headingH3() {
        return DriverFactory.getDriver().findElement(By.tagName("h3"));
    }
    public void clickGreenButton()   { click(greenButton); }
    public String getParagraphText() { return getText(paragraphText); }
    public void setSlider(String value) {
        ((JavascriptExecutor) DriverFactory.getDriver())
                .executeScript("arguments[0].value=arguments[1];"
                        + "arguments[0].dispatchEvent(new Event('input'));"
                        + "arguments[0].dispatchEvent(new Event('change'));", slider, value);
    }
    public void selectPercent(String optionText) {
        new Select(selectDropdown).selectByVisibleText(optionText);
    }
    public void clickRadioTwo()         { click(radioButtonTwo); }
    public boolean isRadioTwoSelected() { return radioButtonTwo.isSelected(); }
    public void clickCheckBoxOne()         { click(checkBoxOne); }
    public boolean isCheckBoxOneSelected() { return checkBoxOne.isSelected(); }
    public boolean isImageInFrame1Visible() {
        var driver = DriverFactory.getDriver();
        driver.switchTo().frame("myFrame1");
        boolean visible = driver.findElement(By.tagName("img")).isDisplayed();
        driver.switchTo().defaultContent();
        return visible;
    }
}