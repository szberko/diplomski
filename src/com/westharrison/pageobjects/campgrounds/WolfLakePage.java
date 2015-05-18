package com.westharrison.pageobjects.campgrounds;

import org.openqa.selenium.WebDriver;

import com.westharrison.pageutils.PageUtils;

public class WolfLakePage extends CampgroundsPage{

	public WolfLakePage(WebDriver driver) {
		super(driver);
		this.get();
	}
}
