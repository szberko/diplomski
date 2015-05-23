package com.westharrison.pageobjects.campgrounds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.westharrison.pageobjects.MakeAReservationPage;
import com.westharrison.pageutils.PageUtils;

public class ChehalisRiverPage extends CampgroundsPage{
	
	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.equals("http://westharrisonreservations.com/chehalis-river"), "Not on the right page.");
	}

	public ChehalisRiverPage(WebDriver driver) {
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
