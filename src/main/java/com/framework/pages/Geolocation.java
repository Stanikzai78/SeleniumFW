package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.framework.base.BasePage;

public class Geolocation extends BasePage {
	  
	  @FindBy(linkText="Geolocation")
      private WebElement geoLocationLink;
      @FindBy(xpath="//button[@onclick='getLocation()']")
      private WebElement locationButton;
      @FindBy(linkText="See it on Google")
      private WebElement googleLink;
      
      public void clickgeolocationlink() {
    	  click(geoLocationLink);
      }
      public void clickLocationButton() {
    	  click(locationButton);
      }
      public void clickGoogleLink() {
    	  click(googleLink);
      }
      
}
