
//package com.framework.base;
//
//import com.framework.driver.DriverFactory;
//import com.framework.utils.WaitUtils;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
//
//public class BasePageDuplicated {
//
//    public BasePageDuplicated() {
//        PageFactory.initElements(DriverFactory.getDriver(), this);
//    }
//
//    public void type(WebElement element, String value) {
//        WaitUtils.waitForVisibility(element);
//        element.clear();
//        element.sendKeys(value);
//    }
//
//    public void click(WebElement element) {
//        WaitUtils.waitForClickable(element);
//        element.click();
//    }
//
//    public String getText(WebElement element) {
//        WaitUtils.waitForVisibility(element);
//        return element.getText().trim();
//    }
//
//    public boolean isDisplayed(WebElement element) {
//        WaitUtils.waitForVisibility(element);
//        return element.isDisplayed();
//    }
//}