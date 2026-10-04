package com.framework.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.framework.base.BasePage;

public class InputPage extends BasePage {

    @FindBy(xpath = "//a[@href='/inputs']")
    private WebElement inputsLink;

    @FindBy(xpath = "//input[@type='number']")
    private WebElement numberField;

    public void openInputs() {
        click(inputsLink);
    }

    public void enterNumber() throws InterruptedException {
        numberField.sendKeys(Keys.ARROW_UP);
        Thread.sleep(2000);
        numberField.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        numberField.clear();
        numberField.sendKeys("10");
    }

    public boolean isInputFieldDisplayed() {
        return numberField.isDisplayed();
    }
}