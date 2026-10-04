
package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.base.BasePage;
import com.framework.utils.WaitUtils;

public class ImmigrationPage extends BasePage {

    private final By formLoader = By.className("oxd-form-loader");
    private final By toast = By.className("oxd-toast");
    private final By successToast =
        By.xpath("//div[contains(@class,'oxd-toast') and contains(.,'Success')]");

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoMenu;
    @FindBy(xpath = "//a[normalize-space()='Immigration']")
    private WebElement immigrationTab;
    @FindBy(xpath = "//h6[normalize-space()='Assigned Immigration Records']/following::button[contains(.,'Add')][1]")
    private WebElement addImmigrationBtn;
    @FindBy(xpath = "//label[contains(.,'Passport')]")
    private WebElement passportRadio;
    @FindBy(xpath = "//label[normalize-space()='Number']/following::input[1]")
    private WebElement numberInput;
    @FindBy(xpath = "//label[normalize-space()='Issued Date']/following::input[1]")
    private WebElement issuedDateInput;
    @FindBy(xpath = "//label[normalize-space()='Expiry Date']/following::input[1]")
    private WebElement expiryDateInput;
    @FindBy(xpath = "//label[normalize-space()='Eligible Status']/following::input[1]")
    private WebElement eligibleStatusInput;
    @FindBy(xpath = "//label[normalize-space()='Issued By']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement issuedByDropdown;
    @FindBy(xpath = "//label[normalize-space()='Eligible Review Date']/following::input[1]")
    private WebElement eligibleReviewDateInput;
    @FindBy(xpath = "//label[normalize-space()='Comments']/following::textarea[1]")
    private WebElement commentsTextarea;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveBtn;

    public void open() {
        click(myInfoMenu);
        click(immigrationTab);
        WaitUtils.waitForInvisibility(formLoader);
    }

    public boolean add(String number, String issuedDate, String expiryDate, String eligibleStatus,
                       String issuedBy, String reviewDate, String comments) {
        click(addImmigrationBtn);
        click(passportRadio);
        type(numberInput, number);
        type(issuedDateInput, issuedDate);
        type(expiryDateInput, expiryDate);
        type(eligibleStatusInput, eligibleStatus);
        selectFromDropdown(issuedByDropdown, issuedBy);
        type(eligibleReviewDateInput, reviewDate);
        type(commentsTextarea, comments);
        click(saveBtn);
        WaitUtils.waitForInvisibility(formLoader);
        boolean saved = isSaveSuccessful();
        WaitUtils.waitForInvisibility(toast);
        return saved;
    }

    private boolean isSaveSuccessful() {
        try {
            return WaitUtils.waitForVisibility(successToast).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
