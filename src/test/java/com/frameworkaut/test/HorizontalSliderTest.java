package com.frameworkaut.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.pages.HorizontalSliderPage;

public class HorizontalSliderTest extends BaseTest{
	@Test
	public void HorizontalSliderTestValidation() {
		HorizontalSliderPage page = new HorizontalSliderPage();
		page.openHorizontalSlider();
		page.moveSlider();
		Assert.assertTrue(page.isHorizontalSliderDisplayed(),"It is displayed");
	}

	}
