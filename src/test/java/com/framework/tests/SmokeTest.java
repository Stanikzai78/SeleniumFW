package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.framework.base.BaseTest;

public class SmokeTest extends BaseTest {

    @Test
    public void testPageLoaded() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("seleniumbase"), "Page should load");
        System.out.println("? TEST PASSED - Page loaded: " + url);
    }
}
