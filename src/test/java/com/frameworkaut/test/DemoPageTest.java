package com.frameworkaut.test;

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.framework.base.BaseTestNoLogin;
	import com.framework.pages.DemoPage;

	public class DemoPageTest extends BaseTestNoLogin {

	    @Test
	    public void demoPageEndToEnd() {
	        DemoPage demo = new DemoPage();
	        demo.open();

	        // Text fields
	        demo.enterText("This is Automated");
	        Assert.assertEquals(demo.getTextInputValue(), "This is Automated");
	        demo.enterTextArea("Testing Time!");
	        demo.enterPreFilled("Typing Text!");

	        // Hover dropdown -> Link Two
	        demo.hoverAndClickOption2();
	        Assert.assertEquals(demo.getHeadingText(), "Link Two Selected");

	        // Green button changes paragraph color text
	        Assert.assertEquals(demo.getParagraphText(), "This Text is Green");
	        demo.clickGreenButton();
	        Assert.assertEquals(demo.getParagraphText(), "This Text is Purple");

	        // Slider drives the progress bar (set to 100)
	        demo.setSlider("100");

	        // Select dropdown drives the meter
	        demo.selectPercent("Set to 100%");

	        // Radio button
	        Assert.assertFalse(demo.isRadioTwoSelected());
	        demo.clickRadioTwo();
	        Assert.assertTrue(demo.isRadioTwoSelected());

	        // Checkbox
	        Assert.assertFalse(demo.isCheckBoxOneSelected());
	        demo.clickCheckBoxOne();
	        Assert.assertTrue(demo.isCheckBoxOneSelected());

	        // iframe image
	        Assert.assertTrue(demo.isImageInFrame1Visible(), "Image inside myFrame1 should be visible");
	    }
	}



