package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.base.BasePage;
import com.framework.driver.DriverFactory;
import com.framework.utils.WaitUtils;

public class EmergencyContactsPage extends BasePage {

    private final By formLoader = By.className("oxd-form-loader");
    private final By toast = By.className("oxd-toast");

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoMenu;
    @FindBy(xpath = "//a[normalize-space()='Emergency Contacts']")
    private WebElement emergencyContactsTab;
    @FindBy(xpath = "//h6[normalize-space()='Assigned Emergency Contacts']/following::button[contains(.,'Add')][1]")
    private WebElement addBtn;
    @FindBy(xpath = "//label[normalize-space()='Name']/following::input[1]")
    private WebElement nameInput;
    @FindBy(xpath = "//label[normalize-space()='Relationship']/following::input[1]")
    private WebElement relationshipInput;
    @FindBy(xpath = "//label[normalize-space()='Home Telephone']/following::input[1]")
    private WebElement homeInput;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveBtn;
    @FindBy(xpath = "(//button[.//i[contains(@class,'bi-pencil-fill')]])[1]")
    private WebElement editIcon;
    @FindBy(xpath = "(//button[.//i[contains(@class,'bi-trash')]])[1]")
    private WebElement deleteIcon;
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    private WebElement confirmDeleteBtn;
    @FindBy(xpath = "//h6[normalize-space()='Attachments']/following::button[contains(.,'Add')][1]")
    private WebElement addAttachmentBtn;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement fileInput;

    public void open() {
        click(myInfoMenu);
        click(emergencyContactsTab);
        WaitUtils.waitForInvisibility(formLoader);
    }

    public void add(String name, String relationship, String home) {
        click(addBtn);
        type(nameInput, name);
        type(relationshipInput, relationship);
        type(homeInput, home);
        click(saveBtn);
        WaitUtils.waitForInvisibility(formLoader);
        WaitUtils.waitForInvisibility(toast);
    }

    public void edit(String name, String relationship, String home) {
        WaitUtils.waitForInvisibility(toast);
        click(editIcon);
        type(nameInput, name);
        type(relationshipInput, relationship);
        type(homeInput, home);
        click(saveBtn);
        WaitUtils.waitForInvisibility(formLoader);
        WaitUtils.waitForInvisibility(toast);
    }

    public void deleteFirst() {
        WaitUtils.waitForInvisibility(toast);
        click(deleteIcon);
        click(confirmDeleteBtn);
        WaitUtils.waitForInvisibility(formLoader);
        WaitUtils.waitForInvisibility(toast);
    }

    public void uploadFile(String filePath) {
        click(addAttachmentBtn);
        fileInput.sendKeys(filePath);
        click(saveBtn);
        WaitUtils.waitForInvisibility(formLoader);
        WaitUtils.waitForInvisibility(toast);
    }
    

    // Returns true if a file with this name shows in the attachments table
    public boolean isAttachmentSaved(String fileName) {
        return isDisplayed(DriverFactory.getDriver()
            .findElement(By.xpath("//div[normalize-space()='" + fileName + "']")));
    }
}