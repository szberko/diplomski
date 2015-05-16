package com.westharrison.pageobjects.campgrounds;

import org.openqa.selenium.WebDriver;

import com.westharrison.pageutils.PageUtils;

public class GraceLakePage extends CampgroundsPage{
	
	private WebDriver driver;
	private PageUtils pageUtils;
	
	public GraceLakePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.pageUtils = new PageUtils(driver);
		this.get();
	}

}
