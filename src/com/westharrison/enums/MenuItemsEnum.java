package com.westharrison.enums;

import org.openqa.selenium.By;

public enum MenuItemsEnum {
	
	HOME(".//div[@class='menu']//span[text()='Home']"),
	CAMPGROUND_CHEHALIS_RIVER(".//div[@class='menu']//span[text()='Chehalis River']"),
	CAMPGROUND_CHEHALIS_RIVER_NORTH_GROUP_SITE(".//div[@class='menu']//span[text()='Chehalis River North Group Site']"),
	CAMPGROUND_GRACE_LAKE(".//div[@class='menu']//span[text()='Grace Lake']"),
	CAMPGROUND_SKWELLEPIL_CREEK(".//div[@class='menu']//span[text()='Skwellepil Creek']"),
	CAMPGROUND_TWENTY_MILE_BAY(".//div[@class='menu']//span[text()='Twenty Mile Bay']"),
	CAMPGROUND_WEAVER_LAKE(".//div[@class='menu']//span[text()='Weaver Lake']"),
	CAMPGROUND_WEAVER_LAKE_GROUP_SITE(".//div[@class='menu']//span[text()='Weaver Lake Group Site']"),
	CAMPGROUND_WOLF_LAKE(".//div[@class='menu']//span[text()='Wolf Lake']"),
	CAMPGROUND_WOOD_LAKE(".//div[@class='menu']//span[text()='Wood Lake']"),
	CAMPGROUND_WOOD_LAKE_GROUP_SITE(".//div[@class='menu']//span[text()='Wood Lake Group Site']"),
	MAKE_A_RESERVATION(".//div[@class='menu']//span[text()='Make A Reservation']"),
	AREA_ATTRACTION(".//div[@class='menu']//span[text()='Area Attraction']"),
	FAQ(".//div[@class='menu']//span[text()='Frequently Asked Questions']"),
	CONTACT_US(".//div[@class='menu']//span[text()='Contact us']");
	
	

	private String locator;

	private MenuItemsEnum(String locator) {
		this.locator = locator;
	}

	public By getLocator() {
		return By.xpath(locator);
	}

}
