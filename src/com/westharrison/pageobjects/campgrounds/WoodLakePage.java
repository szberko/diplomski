package com.westharrison.pageobjects.campgrounds;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.westharrison.pageutils.PageUtils;

public class WoodLakePage extends CampgroundsPage{
	
	public WoodLakePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.get();
	}

}
