package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.framework.base.BasePage;
import com.framework.utils.WaitUtils;

public class ClaimPage extends BasePage {
    private final By formLoader = By.className("oxd-form-loader");

    @FindBy(xpath = "//span[normalize-space()='Claim']")
    private WebElement claimMenu;

    @FindBy(xpath = "//span[normalize-space()='Configuration']")
    private WebElement configurationMenu;

    @FindBy(xpath = "//a[normalize-space()='Events']")
    private WebElement eventsItem;

    @FindBy(xpath = "//a[normalize-space()='Expense Types']")
    private WebElement expenseTypesItem;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addBtn;

    @FindBy(xpath = "//label[normalize-space()='Event Name']/following::input[1]")
    private WebElement eventNameInput;

    @FindBy(xpath = "//h5[normalize-space()='Events'] | //h6[normalize-space()='Events']")
    private WebElement eventsHeading;

    @FindBy(xpath = "//a[normalize-space()='Submit Claim']")
    private WebElement submitClaimLink;

    @FindBy(xpath = "//label[normalize-space()='Event']/following::div[contains(@class,'oxd-select-text-input')][1]")
    private WebElement eventDropdown;

    @FindBy(xpath = "//label[normalize-space()='Currency']/following::div[contains(@class,'oxd-select-text-input')][1]")
    private WebElement currencyDropdown;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//h6[normalize-space()='Expenses']/following::button[normalize-space()='Add'][1]")
    private WebElement addExpenseBtn;

    @FindBy(xpath = "//label[normalize-space()='Expense Type']/following::div[contains(@class,'oxd-select-text-input')][1]")
    private WebElement expenseTypeDropdown;

    @FindBy(xpath = "//label[normalize-space()='Date']/following::input[1]")
    private WebElement dateInput;

    @FindBy(xpath = "//label[normalize-space()='Amount']/following::input[1]")
    private WebElement amountInput;

    @FindBy(xpath = "//div[contains(@class,'oxd-form-actions')]//button[normalize-space()='Save']")
    private WebElement saveExpenseBtn;

    @FindBy(xpath = "//button[normalize-space()='Back']")
    private WebElement backBtn;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement submitBtn;

    public void openClaim() {
        click(claimMenu);
        WaitUtils.waitForInvisibility(formLoader);
    }

    public void openEvents() {
        click(configurationMenu);
        click(eventsItem);
        WaitUtils.waitForInvisibility(formLoader);
    }

    public void addEvent(String eventName) {
        click(addBtn);
        type(eventNameInput, eventName);
        click(submitButton);
        WaitUtils.waitForInvisibility(formLoader);
    }

    public void openExpenseTypes() {
        click(configurationMenu);
        click(expenseTypesItem);
        WaitUtils.waitForInvisibility(formLoader);
    }

    public boolean isEventsPageShown() {
        return isDisplayed(eventsHeading);
    }

//    public void submitClaim() {
//        click(submitClaimLink);
//        selectFromDropdown(eventDropdown, "Travel Allowance");
//        selectFromDropdown(currencyDropdown, "Australian Dollar");
//        click(submitButton);
//    }

    public void addExpense() {
        click(addExpenseBtn);
        selectFromDropdown(expenseTypeDropdown, "Accommodation");
        type(dateInput, "2026-09-06");
        type(amountInput, "150");
        click(saveExpenseBtn);
        click(submitBtn);
        click(cancelBtn);
        click(backBtn);
    }
}
