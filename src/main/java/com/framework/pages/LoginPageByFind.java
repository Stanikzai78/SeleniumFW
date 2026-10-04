package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.driver.DriverFactory;

public class LoginPageByFind {

    public LoginPageByFind() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "passwd")
    private WebElement password;

    @FindBy(name = "SubmitLogin")
    private WebElement loginBtn;

    @FindBy(xpath = "//h3")
    private WebElement loggedSuccessful;

    public void login(String userEmail, String userPassword) {
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        loginBtn.click();
    }

    public String getSuccessMessage() {
        return loggedSuccessful.getText().trim();
    }
}