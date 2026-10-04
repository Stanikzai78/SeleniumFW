package com.framework.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssortion {
	
	    @Test
	    public void verifySoftAssertion() {

	        System.out.println("Executing soft assertion test...");

	        // Create a SoftAssert instance
	        SoftAssert softAssert = new SoftAssert();

	        // Soft assertion: test CONTINUES even if this fails
	        // "apple" does NOT equal "app" → failure is recorded but test keeps running
	        softAssert.assertEquals("apple", "app", "Soft assertion failed: 'apple' does not equal 'app'");

	        // This line WILL execute even if the soft assertion above failed
	        System.out.println("This line WILL print even if soft assertion fails");

	        // MANDATORY: assertAll() must be called at the end to report all collected failures
	        // Without this, soft assertion failures will be silently ignored
	        softAssert.assertAll();
	    }
	}


	


