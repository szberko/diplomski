package com.westharrison.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.glass.ui.Menu;
import com.westharrison.enums.MenuItemsEnum;
import com.westharrison.pageobjects.ContactUsPage;
import com.westharrison.pageobjects.GmailPage;
import com.westharrison.pageobjects.GoogleLoginPage;
import com.westharrison.pageobjects.MainPage;
import com.westharrison.pageobjects.campgrounds.CampgroundsPage;
import com.westharrison.pageutils.PageUtils;

public class FunctionalTests extends TestBase{

	private WebDriver driver;
	private PageUtils pageUtils;
	
	@BeforeMethod
	public void before(){
		this.driver = getDriver();
		this.pageUtils = new PageUtils(driver);
	}
	
	
	@DataProvider(name = "contactforms_functional")
	public Object[][] createCampgroundData() {
		return new Object[][] {
	   { "Weaver Lake", MenuItemsEnum.CAMPGROUND_WEAVER_LAKE},
	   { "Weaver Lake Group Site", MenuItemsEnum.CAMPGROUND_WEAVER_LAKE_GROUP_SITE},
	   { "Grace Lake", MenuItemsEnum.CAMPGROUND_GRACE_LAKE},
	   { "Wolf Lake", MenuItemsEnum.CAMPGROUND_WOLF_LAKE},
	   { "Wood Lake", MenuItemsEnum.CAMPGROUND_WOOD_LAKE},
	   { "Wood Lake Group Site", MenuItemsEnum.CAMPGROUND_WOOD_LAKE_GROUP_SITE},
	   { "Twenty Mile Bay", MenuItemsEnum.CAMPGROUND_TWENTY_MILE_BAY},
	   { "Chehalis River", MenuItemsEnum.CAMPGROUND_CHEHALIS_RIVER},
	   { "Chehalis River North Group Site", MenuItemsEnum.CAMPGROUND_CHEHALIS_RIVER_NORTH_GROUP_SITE},
	   { "Skwellepil Creek", MenuItemsEnum.CAMPGROUND_SKWELLEPIL_CREEK}
	 };
	}
	
	@Test(dataProvider = "contactforms_functional")
	public void test(String campgroundName, MenuItemsEnum campground){
		MainPage mainPage = new MainPage(driver);
		CampgroundsPage campgroundsPage = (CampgroundsPage)mainPage.clickMenuItem(campground);
		Assert.assertEquals(campgroundsPage.getTitle(), campgroundName, "Webpage is not the expected one.");
		campgroundsPage.clickContactUs();
		campgroundsPage.fillContactUsForm("Automated Tester", "tester@example.com", "AUTOMATED_TEST_RUN_SUBJECT", "AUTOMATED_TEST_RUN_TEXT");
		GoogleLoginPage googleLoginPage = new GoogleLoginPage(driver);
		GmailPage gmailPage = googleLoginPage.login();
		gmailPage.clickOnFirstEmail();
		Assert.assertEquals(gmailPage.getEmailTitle(), "AUTOMATED_TEST_RUN_SUBJECT", "Email title is not as expected.");
		Assert.assertTrue(gmailPage.getMessageBody().contains("Automated Tester"), "Email doesn't contains the sender's name.");
		Assert.assertTrue(gmailPage.getMessageBody().contains("tester@example.com"), "Email doesn't contains the sender's email address.");
		Assert.assertTrue(gmailPage.getMessageBody().contains("AUTOMATED_TEST_RUN_TEXT"), "Email doesn't contains the sender's text.");
		Assert.assertTrue(gmailPage.getMessageBody().contains(campgroundName), "Email doesn't contains the campgrounds name from the email was sent.");
	}
	
	@DataProvider(name = "global_contactForm")
	public Object[][] createCampgroundsList() {
		String[] campgroundsCombo1 = new String[]{"Grace Lake"};
		String[] campgroundsCombo2 = new String[]{"Weaver Lake", "Weaver Lake Group Site", "Grace Lake"};
		String[] campgroundsCombo3 = new String[]{"Weaver Lake", "Weaver Lake Group Site", "Grace Lake", "Wolf Lake", "Wood Lake", "Wood Lake Group Site", "Twenty Mile Bay", "Chehalis River", "Chehalis River North Group Site", "Skwellepil Creek"};
		return new Object[][] {
	   { campgroundsCombo1 },
	   { campgroundsCombo2 },
	   { campgroundsCombo3 },
	 };
	}
	@Test(dataProvider = "global_contactForm")
	public void testGoogeLogin(String[] campgrounds){
		MainPage mainPage = new MainPage(driver);
		ContactUsPage contactUsPage = (ContactUsPage)mainPage.clickMenuItem(MenuItemsEnum.CONTACT_US);
		contactUsPage.fillContactUsForm("Automated Tester", "tester@example.com", "AUTOMATED_TEST_RUN_SUBJECT", "AUTOMATED_TEST_RUN_TEXT", campgrounds);
		GoogleLoginPage googleLoginPage = new GoogleLoginPage(driver);
		GmailPage gmailPage = googleLoginPage.login();
		gmailPage.clickOnFirstEmail();
		Assert.assertEquals(gmailPage.getEmailTitle(), "AUTOMATED_TEST_RUN_SUBJECT", "Email title is not as expected.");
		Assert.assertTrue(gmailPage.getMessageBody().contains("Automated Tester"), "Email doesn't contains the sender's name.");
		Assert.assertTrue(gmailPage.getMessageBody().contains("tester@example.com"), "Email doesn't contains the sender's email address.");
		Assert.assertTrue(gmailPage.getMessageBody().contains("AUTOMATED_TEST_RUN_TEXT"), "Email doesn't contains the sender's text.");
		for (String campground : campgrounds) {
			Assert.assertTrue(gmailPage.getMessageBody().contains(campground), "Email doesn't contains the campgrounds name from the email was sent.");
		}
	}
	
}
