package com.framework.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.framework.base.BasePage;

public class HorizontalSliderPage extends BasePage {

    @FindBy(linkText = "Horizontal Slider")
    private WebElement horizontalSlider;

    @FindBy(xpath = "//input[@type='range']")
    private WebElement slider;

    public void openHorizontalSlider() {
        click(horizontalSlider);
    }

    public void moveSlider() {
        slider.sendKeys(Keys.ARROW_RIGHT);
        slider.sendKeys(Keys.ARROW_RIGHT);
        slider.sendKeys(Keys.ARROW_LEFT);
        slider.sendKeys(Keys.ARROW_LEFT);
    }

    public boolean isHorizontalSliderDisplayed() {
        return slider.isDisplayed();
    }
}
	

