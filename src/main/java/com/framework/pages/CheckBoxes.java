package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.framework.base.BasePage;
import com.framework.driver.DriverFactory;

public class CheckBoxes extends BasePage {
    
    @FindBy(xpath = "//a[contains(text(), 'Checkboxes')]")
    private WebElement checkBoxesLink;
    
    @FindBy(xpath = "//input[@type='checkbox'][1]")
    private WebElement checkBox1;
    
    @FindBy(xpath = "//a[contains(text(), 'Context Menu')]")
    private WebElement contextMenuLink;
    
    @FindBy(xpath = "//h3[contains(text(), 'Context Menu')]")
    private WebElement contextMenuHeader;

//    public void openCheckBox() { 
//        click(checkBoxesLink); 
//    }

    public void clickCheckBox1() { 
        click(checkBox1); 
    }

    public void openContextMenu() { 
        click(contextMenuLink); 
    }

    public boolean isCheckBox1Marked() { 
        return checkBox1.isSelected(); 
    }

    public boolean isContextMenuDisplayed() { 
        return isDisplayed(contextMenuHeader); 
    }

    public void goBack() {
        DriverFactory.getDriver().navigate().back();
    }
      

}