package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.base.BasePage;

public class LoginPagePOM extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public void login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
    }
}













//package com.framework.pages;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import com.framework.base.BasePage;
//
//public class LoginPagePOM extends BasePage {
//
//    @FindBy(name = "username")
//    private WebElement enterUsernameinput;
//
//    @FindBy(name = "password")
//    private WebElement enterPasswordinput;
//
//    @FindBy(css = "button[type='submit']")
//    private WebElement clickButtoninput;
//    
//    public LoginPagePOM enterUsernameinput(String username) {
//        type(enterUsernameinput, username);
//        return this;
//    }
//
//    public LoginPagePOM enterPasswordinput(String password) {
//        type(enterPasswordinput, password);
//        return this;
//    }
//
//    public HomePage clickLogininput() {
//        click(clickButtoninput);
//        return new HomePage();
//    }
//
//    public HomePage login(String username, String password) {
//        return enterUsernameinput(username)
//                .enterPasswordinput(password)
//                .clickLogininput();
//    }
//}