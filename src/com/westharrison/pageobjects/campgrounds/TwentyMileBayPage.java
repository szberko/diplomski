package com.westharrison.pageobjects.campgrounds;

import org.openqa.selenium.WebDriver;

import com.westharrison.pageutils.PageUtils;

public class TwentyMileBayPage extends CampgroundsPage{
	
	
	public TwentyMileBayPage(WebDriver driver) {
		super(driver);
		this.get();
	}

}
