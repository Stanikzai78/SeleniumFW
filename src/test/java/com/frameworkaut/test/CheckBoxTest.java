package com.frameworkaut.test;
import com.framework.base.BaseTestNoLogin;
import com.framework.driver.DriverFactory;
import com.framework.pages.CheckBoxes;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTestNoLogin {
    @Test
    public void checkboxesValidation() {
        DriverFactory.getDriver().get("https://the-internet.herokuapp.com/");
        CheckBoxes boxes = new CheckBoxes();
        boxes.openCheckBox();
        boxes.clickCheckBox1();
        Assert.assertTrue(boxes.isCheckBox1Marked(), "Checkbox 1 should be selected");
        boxes.goBack();
        boxes.openContextMenu();
        Assert.assertTrue(boxes.isContextMenuDisplayed(), "Context Menu page should be displayed");
    }
}