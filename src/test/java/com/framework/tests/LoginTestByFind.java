package com.framework.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.driver.DriverFactory;
import com.framework.pages.LoginPageByFind;

public class LoginTestByFind {
	
	LoginPageByFind loginPage;
	
	@BeforeMethod
	public void setUpMethod() {
		
DriverFactory.getDriver().get("https://demo.guru99.com/test/login.html");
	loginPage = new LoginPageByFind();		
	}
	
	@Test
	public void guru99LoginTest() {
		
	}

}
