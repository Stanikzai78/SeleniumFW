package com.frameworkaut.test;

import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.pages.Geolocation;

public class GeoLocationTest extends BaseTest{
	@Test
	public void GeoLocationValidation() {
		Geolocation page = new Geolocation();
		page.clickgeolocationlink();
		page.clickLocationButton();
		page.clickGoogleLink();
		
	}

}
