package com.westharrison.pageobjects.campgrounds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.westharrison.pageobjects.MakeAReservationPage;
import com.westharrison.pageutils.PageUtils;

public class GraceLakePage extends CampgroundsPage{
	
	@Override
	protected void isLoaded() throws Error {
		super.isLoaded();
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.equals("http://westharrisonreservations.com/grace-lake"), "Not on the right page.");
	}
	
	public GraceLakePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.get();
	}
	
	public void checkSubMenuItems(){
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#overview")).isDisplayed(), "Overview section is not displayed");
		clickMapOfCampground();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#map_of_camp")).isDisplayed(), "Map of campground section is not displayed");
		clickDrivingDirections();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#google-map")).isDisplayed(), "Driving directions map section is not displayed");
		clickWeather();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#weather")).isDisplayed(), "Weather section is not displayed");
		clickContactUs();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#contact_form")).isDisplayed(), "Contact Us section is not displayed");
		clickGuidelines();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#guidelines")).isDisplayed(), "Guidelines section is not displayed");
		clickOverview();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#overview")).isDisplayed(), "Overview section is not displayed");
	}

}
