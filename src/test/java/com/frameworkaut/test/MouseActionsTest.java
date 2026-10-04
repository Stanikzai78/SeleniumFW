package com.frameworkaut.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.framework.base.BaseTest;
import com.framework.pages.MouseActionsPage;

public class MouseActionsTest extends BaseTest {

    @Test
    public void mouseActionsValidation() throws InterruptedException {
        MouseActionsPage actions = new MouseActionsPage();
        actions.openHoverDropDownPage();
        actions.clickLinkOne();
        Assert.assertTrue(true, "Mouse action executed successfully");
    }
}