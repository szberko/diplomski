package com.westharrison.pageobjects.campgrounds;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.westharrison.enums.MenuItemsEnum;
import com.westharrison.pageobjects.AreaAttractionPage;
import com.westharrison.pageobjects.ContactUsPage;
import com.westharrison.pageobjects.FAQPage;
import com.westharrison.pageobjects.MainPage;
import com.westharrison.pageobjects.MakeAReservationPage;
import com.westharrison.pageutils.PageUtils;

public class CampgroundsPage extends LoadableComponent<CampgroundsPage>{
	
	private WebDriver driver;
	private PageUtils pageUtils;

	@Override
	protected void isLoaded() throws Error {
		try{
			Assert.assertTrue(driver.findElement(By.cssSelector("#slideshow")).isDisplayed(), "The page is not loaded fully");
		}catch(NoSuchElementException ex){
			throw new AssertionError();
		}
	}

	@Override
	protected void load() {
		
	}
	
	public CampgroundsPage(WebDriver driver){
		this.driver = driver;
		this.pageUtils = new PageUtils(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".entry-title")
	private WebElement title;
	
	@FindBy(xpath = ".//div[@class='menu']//span[text()='Campgrounds']")
	private WebElement campgroundsMenuItem;
	
	public String getTitle(){
		return title.getText();
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
