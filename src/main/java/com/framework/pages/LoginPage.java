package com.framework.pages;

import com.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    public LoginPage enterUsername(String username) {
        type(usernameInput, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordInput, password);
        return this;
    }

    public HomePage clickLogin() {
        click(loginButton);
        return new HomePage();
    }

    public HomePage login(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickLogin();
    }
}