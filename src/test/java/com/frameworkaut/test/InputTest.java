package com.frameworkaut.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.pages.InputPage;

public class InputTest extends BaseTest {

    @Test
    public void inputPageValidation() throws InterruptedException {
        InputPage page = new InputPage();
        page.openInputs();
        Assert.assertTrue(page.isInputFieldDisplayed(), "Input field is not displayed");
        page.enterNumber();
    }
}
