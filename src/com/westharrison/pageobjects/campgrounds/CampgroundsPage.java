package com.westharrison.pageobjects.campgrounds;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.westharrison.enums.MenuItemsEnum;
import com.westharrison.pageobjects.AbstractPageObject;
import com.westharrison.pageobjects.AreaAttractionPage;
import com.westharrison.pageobjects.ContactUsPage;
import com.westharrison.pageobjects.FAQPage;
import com.westharrison.pageobjects.MainPage;
import com.westharrison.pageobjects.MakeAReservationPage;
import com.westharrison.pageutils.ContactUsSection;

public class CampgroundsPage extends AbstractPageObject<CampgroundsPage>{
	
	@Override
	protected void isLoaded() throws Error {
		try{
			Assert.assertTrue(super.driver.findElement(By.cssSelector(".entry-title")).isDisplayed(), "The page is not loaded fully");
		}catch(NoSuchElementException ex){
			throw new AssertionError();
		}
	}
	
	@Override
	protected void load() {
		super.load();
		pageUtils.waitForElementToAppear(By.cssSelector(".soliloquy-viewport"));
	}
	
	private ContactUsSection contactUsSection;

	public CampgroundsPage(WebDriver driver){
		super(driver);
		this.contactUsSection = new ContactUsSection(driver);
		PageFactory.initElements(driver, this);
		this.get();
	}
	
	public void fillContactUsForm(String name, String email, String subject, String message){
		contactUsSection.fillName(name);
		contactUsSection.fillEmail(email);
		contactUsSection.fillSubject(subject);
		contactUsSection.fillMessage(message);
		contactUsSection.clickSendBtn();
		WebElement response = pageUtils.waitForElementToAppear(By.xpath(".//div[@role='alert'][@class!='screen-reader-response']"));
		Assert.assertEquals(response.getText(), "Your message was sent successfully. Thanks.", "The response message is not the expected");
	}
	
	@FindBy(css = "#goto_overview")
	private WebElement gotoOverview;
	
	@FindBy(css = "#goto_reserve")
	private WebElement gotoReserve;
	
	@FindBy(css = "#goto_list_of_campsites")
	private WebElement gotoCampsites;
	
	@FindBy(css = "#goto_map_of_campground")
	private WebElement gotoMapOfCampground;
	
	@FindBy(css = "#goto_driving_directions")
	private WebElement gotoDrivingDirections;
	
	@FindBy(css = "#goto_weather")
	private WebElement gotoWeather;
	
	@FindBy(css = "#goto_contactform")
	private WebElement gotoContactForm;
	
	@FindBy(css = "#goto_guidlines")
	private WebElement gotoGuidlines;

	
	public void clickOverview(){
		pageUtils.waitForElementToBeClickable(gotoOverview).click();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#overview")).isDisplayed(), "Overview section is not displayed");
	}
	
	public MakeAReservationPage clickReserveNow(){
		pageUtils.waitForElementToBeClickable(gotoReserve).click();
		return new MakeAReservationPage(driver);
	}
	
	public void clickCampsites(){
		pageUtils.waitForElementToBeClickable(gotoCampsites).click();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#list_of_campsites")).isDisplayed(), "List of campsites section is not displayed");
	}
	
	public void clickMapOfCampground(){
		pageUtils.waitForElementToBeClickable(gotoMapOfCampground).click();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#map_of_camp")).isDisplayed(), "Map of campground section is not displayed");
	}
	
	public void clickDrivingDirections(){
		pageUtils.waitForElementToBeClickable(gotoDrivingDirections).click();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#google-map")).isDisplayed(), "Driving directions map section is not displayed");
	}
	
	public void clickWeather(){
		pageUtils.waitForElementToBeClickable(gotoWeather).click();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#weather")).isDisplayed(), "Weather section is not displayed");
	}
	
	public void clickContactUs(){
		pageUtils.waitForElementToBeClickable(gotoContactForm).click();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#contact_form")).isDisplayed(), "Contact Us section is not displayed");
	}
	
	public void clickGuidelines(){
		pageUtils.waitForElementToBeClickable(gotoGuidlines).click();
		Assert.assertTrue(pageUtils.waitForElementToAppear(By.cssSelector("#guidelines")).isDisplayed(), "Guidelines section is not displayed");
	}
	
	private void clickOnCampground(WebElement campground){
		pageUtils.moveToElement(campgroundsMenuItem);
		pageUtils.waitForElementToAppear(campground).click();
	}
	
	public Object clickMenuItem(MenuItemsEnum menuItem){
		switch (menuItem) {
		case HOME:{
			driver.findElement(menuItem.getLocator()).click();
			return new MainPage(driver);
		}

		case CAMPGROUND_CHEHALIS_RIVER:{
			clickOnCampground(driver.findElement(menuItem.getLocator()));
			return new ChehalisRiverPage(driver);
		}

		case CAMPGROUND_CHEHALIS_RIVER_NORTH_GROUP_SITE:{
			clickOnCampground(driver.findElement(menuItem.getLocator()));
			return new ChehalisRiverNorthGroupSitePage(driver);
		}

		case CAMPGROUND_GRACE_LAKE:{
			clickOnCampground(driver.findElement(menuItem.getLocator()));
			return new GraceLakePage(driver);
		}

		case CAMPGROUND_SKWELLEPIL_CREEK:{
			clickOnCampground(driver.findElement(menuItem.getLocator()));
			return new SkwellepilCreekPage(driver);
		}

		case CAMPGROUND_TWENTY_MILE_BAY:{
			clickOnCampground(driver.findElement(menuItem.getLocator()));
			return new TwentyMileBayPage(driver);
		}

		case CAMPGROUND_WEAVER_LAKE:{
			clickOnCampground(driver.findElement(menuItem.getLocator()));
			return new WeaverLakePage(driver);
		}

		case CAMPGROUND_WEAVER_LAKE_GROUP_SITE:{
			clickOnCampground(driver.findElement(menuItem.getLocator()));
			return new WeaverLakeGroupSitePage(driver);
		}

		case CAMPGROUND_WOLF_LAKE:{
			clickOnCampground(driver.findElement(menuItem.getLocator()));
			return new WolfLakePage(driver);
		}

		case CAMPGROUND_WOOD_LAKE:{
			clickOnCampground(driver.findElement(menuItem.getLocator()));
			return new WoodLakePage(driver);
		}

		case CAMPGROUND_WOOD_LAKE_GROUP_SITE:{
			clickOnCampground(driver.findElement(menuItem.getLocator()));
			return new WoodLakeGroupSitePage(driver);
		}
			
		case MAKE_A_RESERVATION:{
			driver.findElement(menuItem.getLocator()).click();
			return new MakeAReservationPage(driver);
		}
			
		case AREA_ATTRACTION:{
			driver.findElement(menuItem.getLocator()).click();
			return new AreaAttractionPage(driver);
		}
			
		case FAQ:{
			driver.findElement(menuItem.getLocator()).click();
			return new FAQPage(driver);
		}
			
		case CONTACT_US:{
			driver.findElement(menuItem.getLocator()).click();
			return new ContactUsPage(driver);
		}
			

		default:
			return null;
		}
	}

}
