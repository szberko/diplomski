package com.westharrison.pageobjects.campgrounds;

import org.openqa.selenium.WebDriver;

import com.westharrison.pageutils.PageUtils;

public class WoodLakeGroupSitePage extends CampgroundsPage{
	
	public WoodLakeGroupSitePage(WebDriver driver) {
		super(driver);
		this.get();
	}

}
