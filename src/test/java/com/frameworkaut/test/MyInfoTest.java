
package com.frameworkaut.test;

import com.framework.base.BaseTest;
import com.framework.pages.LoginPagePOM;
import com.framework.pages.MyInformation;
import com.framework.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyInfoTest extends BaseTest {

    @Test
    public void verifyMyInfoSuccess() throws InterruptedException {
        new LoginPagePOM().login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        MyInformation page = new MyInformation();
        page.fillPersonalDetails("Mohammad", "Stanikzai", "12345", "2027-15-06", "Afghan", "B+");
        Thread.sleep(5000);

        Assert.assertEquals(page.getFirstName(), "Mohammad");
        Assert.assertEquals(page.getLastName(), "Stanikzai");
        Assert.assertEquals(page.getDriverLicense(), "12345");
        Assert.assertEquals(page.getNationality(), "Afghan");
        Assert.assertEquals(page.getLicenseExpiry(), "2027-15-06");
        Assert.assertEquals(page.getBloodType(), "B+");

        page.addAttachment("C:\\Users\\mssta\\OneDrive\\Desktop\\Resumes\\coverletter.docx");
        Thread.sleep(3000);
        Assert.assertTrue(page.isAttachmentVisible(), "Attachment should be visible after upload");
    }
}
