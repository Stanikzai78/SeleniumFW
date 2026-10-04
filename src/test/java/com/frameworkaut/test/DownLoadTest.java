package com.frameworkaut.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTestNoLogin;
import com.framework.pages.DownloadPage;

public class DownLoadTest extends BaseTestNoLogin {

    @Test
    public void downLoadPageValidation() {
        DownloadPage downLoad = new DownloadPage();
        downLoad.openPage();
        downLoad.navigateToPDF();

        Assert.assertTrue(downLoad.isDownLoadsMenuVisible(), "Downloads menu is not visible");
        Assert.assertTrue(downLoad.isPdfButtonVisible(), "PDF button is not visible");
    }
}


