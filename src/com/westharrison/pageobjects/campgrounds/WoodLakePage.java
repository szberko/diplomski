package com.westharrison.pageobjects.campgrounds;

import org.openqa.selenium.WebDriver;

import com.westharrison.pageutils.PageUtils;

public class WoodLakePage extends CampgroundsPage{
	
	private WebDriver driver;
	private PageUtils pageUtils;
	
	public WoodLakePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.pageUtils = new PageUtils(driver);
		this.get();
	}

}
