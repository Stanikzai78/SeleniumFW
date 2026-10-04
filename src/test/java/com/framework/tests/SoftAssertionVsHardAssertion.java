package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SoftAssertionVsHardAssertion {

    @Test
    public void verifyHardAssertion() {
        System.out.println("Executing hard assertion test...");
        Assert.assertEquals(10, 10);
        System.out.println("Assertion passed");
    }
}