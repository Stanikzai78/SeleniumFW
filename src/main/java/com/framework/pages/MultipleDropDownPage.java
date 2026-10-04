package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MultipleDropDownPage {

    WebDriver driver;

    By dropdownLocator = By.xpath("//a[text()='Dropdown']");

    public MultipleDropDownPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDropdownElement() {
        return driver.findElement(dropdownLocator);
    }

    public Select getDropdown() {
        return new Select(getDropdownElement());
    }

    public void selectByVisibleText(String text) {
        getDropdown().selectByVisibleText(text);
    }

    public void selectByValue(String value) {
        getDropdown().selectByValue(value);
    }

    public void selectByIndex(int index) {
        getDropdown().selectByIndex(index);
    }

    public String getSelectedOption() {
        return getDropdown().getFirstSelectedOption().getText();
    }

    public boolean isMultiple() {
        return getDropdown().isMultiple();
    }
}
