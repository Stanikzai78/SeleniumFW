//package com.framework.pages;
//
//	import com.framework.base.BasePage;
//	import com.framework.utils.WaitUtils;
//	import org.openqa.selenium.WebElement;
//	import org.openqa.selenium.support.FindBy;
//
//	public class MyInfoDupicate extends BasePage {
//
//	    @FindBy(xpath = "//span[text()='My Info']")
//	    private WebElement myInfo;
//
//	    @FindBy(name = "firstName")
//	    private WebElement firstNameInput;
//
//	    @FindBy(name = "lastName")
//	    private WebElement lastNameInput;
//
//	    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Save']")
//	    private WebElement saveButton;
//
//	    public MyInformation clickMyInfo() {
//	        click(myInfo);
//	       
//	        WaitUtils.waitForVisibility(firstNameInput);
//	        try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
//	        return this;
//	    }
//
//	 
//	    private void setReactInput(WebElement element, String value) {
//	        WaitUtils.waitForVisibility(element);
//	    }
//
//	    public MyInformation enterFirstName(String firstName) {
//	        setReactInput(firstNameInput, firstName);
//	        return this;
//	    }
//
//	    public MyInformation enterLastName(String lastName) {
//	        setReactInput(lastNameInput, lastName);
//	        return this;
//	    }
//
//	    public MyInformation clickSave() {
//	        click(saveButton);
//	        return this;
//	    }
//
//	  
//	    public String getFirstName() {
//	        WaitUtils.waitForVisibility(firstNameInput);
//	        return firstNameInput.getAttribute("value");
//	    }
//
//	    public String getLastName() {
//	        WaitUtils.waitForVisibility(lastNameInput);
//	        return lastNameInput.getAttribute("value");
//	    }
//
//	 
//	    public MyInformation updateName(String firstName, String lastName) {
//	        clickMyInfo();
//	        enterFirstName(firstName);
//	        enterLastName(lastName);
//	        try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
//	        clickSave();
//	        return this;
//	    }
//	}
//
//}
