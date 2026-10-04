package com.framework.tests;

import org.testng.annotations.Test;
import com.framework.base.BaseTest;

public class DemoPageTest extends BaseTest {

    @Test
    public void testDemoPageLoaded() {
        String title = driver.getTitle();
        System.out.println("? Page title: " + title);
        System.out.println("? Page loaded successfully!");
    }

    @Test
    public void testDemoPageURL() {
        String url = driver.getCurrentUrl();
        System.out.println("? Current URL: " + url);
    }
}
