package com.westharrison.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.westharrison.pageutils.PageUtils;

public class FAQPage extends LoadableComponent<FAQPage>{
	
	private WebDriver driver;
	private PageUtils pageUtils;
	
	public FAQPage(WebDriver driver) {
		this.driver = driver;
		this.pageUtils = new PageUtils(driver);
		this.get();
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

}
