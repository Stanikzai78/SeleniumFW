
package com.frameworkaut.test;

import com.framework.base.BaseTest;
import com.framework.pages.ScrollPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScrollTest extends BaseTest {

    @Test
    public void scrollPageValidation() throws InterruptedException {
        ScrollPage page = new ScrollPage();
        page.openScrollPage();

        Assert.assertTrue(page.isHeaderDisplayed(), "Infinite Scroll page header should be displayed");

        int initialCount = page.getLoadedParagraphCount();
        page.scrollDown();
        Thread.sleep(2000);
        page.scrollDown();
        Thread.sleep(2000);

        int afterScrollCount = page.getLoadedParagraphCount();
        Assert.assertTrue(afterScrollCount > initialCount,
            "More paragraphs should load after scrolling (was " + initialCount + ", now " + afterScrollCount + ")");
    }
}
