package com.westharrison.pageobjects.campgrounds;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.westharrison.pageutils.PageUtils;

public class WeaverLakePage extends CampgroundsPage{
	
	private WebDriver driver;
	private PageUtils pageUtils;

	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.equals("http://westharrisonreservations.com/weaver-lake"), "Not on the right page.");	
	}
	
	public WeaverLakePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.pageUtils = new PageUtils(driver);
		this.get();
	}
	
	

}
