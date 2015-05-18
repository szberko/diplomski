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
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#overview")).isDisplayed(), "Overview section is not displayed");
		clickCampsites();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#list_of_campsites")).isDisplayed(), "List of campsites section is not displayed");
		clickMapOfCampground();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#map_of_camp")).isDisplayed(), "Map of campground section is not displayed");
		clickDrivingDirections();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#driving_directions_text")).isDisplayed(), "Driving Directions description section is not displayed");
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#google-map")).isDisplayed(), "Driving directions map section is not displayed");
		clickWeather();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#weather")).isDisplayed(), "Weather section is not displayed");
		clickContactUs();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#contact_form")).isDisplayed(), "Contact Us section is not displayed");
		clickGuidelines();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#guidelines")).isDisplayed(), "Guidelines section is not displayed");
		clickOverview();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#overview")).isDisplayed(), "Overview section is not displayed");
		MakeAReservationPage makeAReservationPage = clickReserveNow();
		Assert.assertTrue(makeAReservationPage.getTitle().equals("Make A Reservation"), "This is not the Make A Reservation page");
	}

}
