package com.westharrison.pageobjects.campgrounds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.westharrison.pageobjects.MakeAReservationPage;
import com.westharrison.pageutils.PageUtils;

public class WoodLakeGroupSitePage extends CampgroundsPage{
	
	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.equals("http://westharrisonreservations.com/wood-lake-group-site"), "Not on the right page.");	
	}
	
	public WoodLakeGroupSitePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.get();
	}
	
	public void checkSubMenuItems(){
		clickMapOfCampground();
		clickDrivingDirections();
		clickWeather();
		clickContactUs();
		clickGuidelines();
		clickOverview();
		clickReserveNow();
	}

}
