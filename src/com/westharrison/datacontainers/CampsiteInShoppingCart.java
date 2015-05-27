package com.westharrison.datacontainers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.westharrison.pageutils.PageUtils;

public class CampsiteInShoppingCart {

	private WebDriver driver;
	private PageUtils pageUtils;

	public CampsiteInShoppingCart(WebDriver driver){
		this.driver = driver;
		this.pageUtils = new PageUtils(driver);
	}

	private String campgroundName;
	private String campsiteName;
	private String dateFrom;
	private String dateTo;
	private String price;
	private WebElement change;
	private WebElement remove;
	
}
