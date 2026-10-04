
package com.frameworkaut.test;

import com.framework.base.BaseTest;
import com.framework.pages.DragAndDrop;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {

    @Test
    public void dragAndDropValidation() {
        DragAndDrop page = new DragAndDrop();
        page.openPage();
        page.performDragAndDrop();

        Assert.assertEquals(page.getSourceText(), "B", "Source column should contain 'B' after drag");
        Assert.assertEquals(page.getTargetText(), "A", "Target column should contain 'A' after drag");
    }
}
