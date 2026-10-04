package com.frameworkaut.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.framework.base.BaseTest;
import com.framework.pages.ClaimPage;
public class ClaimConfigTest extends BaseTest {
    @Test
    public void openEventsFromConfiguration() throws InterruptedException {
        ClaimPage config = new ClaimPage();
        config.openClaim();
        config.openEvents();
        Assert.assertTrue(config.isEventsPageShown(), "Should navigate to the Claim Events page");
        config.submitClaim();
        Thread.sleep(5000);
        config.addExpense();
    }
}



//Refer id 202606090000012
