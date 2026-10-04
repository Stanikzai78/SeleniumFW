package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.base.BasePage;
import com.framework.utils.WaitUtils;

public class ContactsDetials extends BasePage {

    private final By formLoader = By.className("oxd-form-loader");

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoMenu;

    @FindBy(xpath = "//a[text()='Contact Details']")
    private WebElement contactDetailsTab;

    @FindBy(xpath = "//label[text()='Street 1']/following::input[1]")
    private WebElement street1Input;

    @FindBy(xpath = "//label[text()='Country']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement countryDropDownMenu;

    @FindBy(xpath = "//label[text()='Mobile']/following::input[1]")
    private WebElement mobileInput;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveBtn;

    public void openContactDetails() {
        click(myInfoMenu);
        click(contactDetailsTab);
        WaitUtils.waitForInvisibility(formLoader);
    }

    public void enterStreet1(String street1) {
        type(street1Input, street1);
    }

    public void selectCountryDropDownMenu(String country) {
        selectFromDropdown(countryDropDownMenu, country);
    }

    public void enterMobileNumber(String mobile) {
        type(mobileInput, mobile);
    }

    public void clickSaveBtn() {
        click(saveBtn);
    }
}