package com.westharrison.pageobjects.campgrounds;

import org.openqa.selenium.WebDriver;

import com.westharrison.pageutils.PageUtils;

public class GraceLakePage extends CampgroundsPage{
	
	
	public GraceLakePage(WebDriver driver) {
		super(driver);
		this.get();
	}

}
