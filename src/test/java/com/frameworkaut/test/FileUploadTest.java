package com.frameworkaut.test;

	import com.framework.base.BaseTest;
	import com.framework.pages.FileUpload;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	public class FileUploadTest extends BaseTest {

	    @Test
	    public void fileUploadValidation() {
	        FileUpload page = new FileUpload();
	        page.openPage();
	        page.uploadFile("C:\\Users\\mssta\\OneDrive\\Desktop\\Resumes\\coverletter.docx");

	        Assert.assertEquals(page.getUploadedFileName(), "coverletter.docx", "Uploaded file name should be displayed");
	    }
	}
	
