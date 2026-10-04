package com.frameworkaut.test;

import com.framework.base.BaseTest;
import com.framework.pages.HoverActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest extends BaseTest {

    @Test
    public void hoverValidation() {
        HoverActions hover = new HoverActions();
        hover.openHoversPage();

        hover.hoverFirstImage();
        Assert.assertTrue(hover.isFirstImageDisplayed(), "First image should be displayed");

        hover.hoverSecondImage();
        Assert.assertTrue(hover.isSecondImageDisplayed(), "Second image should be displayed");
    }
}