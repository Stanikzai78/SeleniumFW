package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.pages.HorizontalSliderPage;

public class HorizontalSliderTest extends BaseTest {
    @Test
    public void HorizontalSliderValidation() {
        HorizontalSliderPage page = new HorizontalSliderPage();
        page.openHorizontalSlider();
        page.moveSlider();
        Assert.assertTrue(page.isHorizontalSliderDisplayed(), "Horizontal slider should be displayed");
    }
}