package com.framework.pages;

import com.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyInformation extends BasePage {

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoMenu;
    @FindBy(name = "firstName")
    private WebElement firstNameInput;
    @FindBy(name = "lastName")
    private WebElement lastNameInput;
    @FindBy(xpath = "//label[contains(text(),'License')]/../following-sibling::div//input")
    private WebElement driverLicenseInput;
    @FindBy(xpath = "//label[normalize-space()='Nationality']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")
    private WebElement nationalityDropdown;
    @FindBy(xpath = "//label[normalize-space()='Male']")
    private WebElement maleRadio;
    @FindBy(xpath = "//label[normalize-space()='License Expiry Date']/../following-sibling::div//input")
    private WebElement licenseExpiryInput;
    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Save']")
    private WebElement saveButton;
    @FindBy(xpath = "//label[normalize-space()='Blood Type']/ancestor::div[contains(@class,'oxd-grid-item')]//div[contains(@class,'oxd-select-text')]")
    private WebElement bloodTypeDropdown;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addAttachmentBtn;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement fileInput;
    @FindBy(xpath = "//div[contains(text(),'coverletter')]")
    private WebElement attachmentRow;
    @FindBy(xpath = "(//div[@class='oxd-table-card']//button)[last()]")
    private WebElement deleteAttachmentBtn;
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    private WebElement confirmDeleteBtn;

    public void fillPersonalDetails(String firstName, String lastName, String license, String expiry, String nationality, String bloodType) {
        click(myInfoMenu);
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(driverLicenseInput, license);
        type(licenseExpiryInput, expiry);
        selectFromDropdown(nationalityDropdown, nationality);
        click(maleRadio);
        selectFromDropdown(bloodTypeDropdown, bloodType);
        click(saveButton);
    }

    public void addAttachment(String filePath) {
        click(addAttachmentBtn);
        fileInput.sendKeys(filePath);
        click(saveButton);
    }

    public void deleteAttachment() {
        click(deleteAttachmentBtn);
        click(confirmDeleteBtn);
    }

    public String getFirstName()       { return getAttribute(firstNameInput, "value"); }
    public String getLastName()        { return getAttribute(lastNameInput, "value"); }
    public String getDriverLicense()   { return getAttribute(driverLicenseInput, "value"); }
    public String getNationality()     { return getText(nationalityDropdown); }
    public String getLicenseExpiry()   { return getAttribute(licenseExpiryInput, "value"); }
    public String getBloodType()       { return getText(bloodTypeDropdown); }
    public boolean isAttachmentVisible() { return isDisplayed(attachmentRow); }
}