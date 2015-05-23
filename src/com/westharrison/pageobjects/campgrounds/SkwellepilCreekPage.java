package com.westharrison.pageobjects.campgrounds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.westharrison.pageobjects.MakeAReservationPage;

public class SkwellepilCreekPage extends CampgroundsPage{
	
	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.equals("http://westharrisonreservations.com/skwellepil-creek"), "Not on the right page.");
	}
	
	public SkwellepilCreekPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.get();
	}
	
	public void checkSubMenuItems(){
		clickCampsites();
		clickMapOfCampground();
		clickDrivingDirections();
		clickWeather();
		clickContactUs();
		clickGuidelines();
		clickOverview();
		clickReserveNow();
	}

}
