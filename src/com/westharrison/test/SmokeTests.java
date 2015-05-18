package com.westharrison.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.westharrison.enums.BrowserTypesEnums;
import com.westharrison.enums.MenuItemsEnum;
import com.westharrison.pageobjects.MainPage;
import com.westharrison.pageobjects.campgrounds.CampgroundsPage;
import com.westharrison.pageobjects.campgrounds.ChehalisRiverPage;
import com.westharrison.pageobjects.campgrounds.WeaverLakePage;
import com.westharrison.pageutils.Constants;
import com.westharrison.pageutils.PageUtils;

public class SmokeTests extends TestBase{

	private WebDriver driver;
	private PageUtils pageUtils;
	
	@BeforeMethod
	public void before(){
		this.driver = getDriver();
		this.pageUtils = new PageUtils(driver);
	}
	
	@DataProvider(name = "slideshow_smoketest")
	public Object[][] createSlideShowData() {
		return new Object[][] {
	   { "Weaver Lake", 
		   			"There is no better way to spend a day than on the water. "
				+ "Weaver Lake is a medium sized lake, large enough to spend a few days exploring, "
				+ "but not large enough to get lost. Bring your own boat, use the public boat launch, "
				+ "spend a memorable day on the water." },
	   { "Weaver Lake Group Site", 
					"Enjoy exclusive use of this group site for your family or group gatherings. "
				+ "This site is located at the north east side of Weaver Lake and boasts a wharf, "
				+ "10 tenting pad sites and a communal fire ring. "
				+ "will actually climb the mountain for you."},
	   { "Grace Lake", 
					"Enjoy this small but popular camping site located next to Grace Lake. "
				+ "There is even a floating dock to fish from. A nice feature of this recreation site "
				+ "is the designated staging area and parking lot for motorized "
				+ "recreation that accesses the West Harrison Riding Area."},
	   { "Wolf Lake", 
					"A favorite small group campsite situated next to Wolf Lake. "
				+ "Enjoy fishing off the wharf. There are 3 designated sites with picnic tables, fire rings and an outhouse."},
	   { "Wood Lake", 
					"A large semi-open site with two camping areas, one on each side of the lake. "
				+ "Access is by gravel road and no power boats are allowed. "
				+ "We have picnic tables and fire rings at every site and outhouses positioned around the property."}
	 };
	}
	
	@Test(dataProvider = "slideshow_smoketest", enabled = false)
	public void testCheckContentOfSlideShow(String campgroundName, String campgrundText){
		MainPage mainPage = new MainPage(driver);
		Assert.assertTrue(mainPage.getListOfSlides().size() == 5, "The count of slides is not equal with 5");
		
		while(!mainPage.getCaptionOfActualSlide().equals(campgroundName)){
			pageUtils.moveToElement(mainPage.getSlideShow(), 20, 20);
			mainPage.clickSlideShowNextBtn();
		}
		//Moving mouse into the slide show to pause it
		pageUtils.moveToElement(mainPage.getSlideShow(), 20, 20);
		Assert.assertEquals(mainPage.getTextOfActualSlide(), campgrundText, "There is a difference in text on the slide");
	}
	
	@DataProvider(name = "columns_smoketest")
	public Object[][] createColumnsData() {
		return new Object[][] {
	   { "Weaver Lake", 
		   			"There is no better way to spend a day than on the water. "
		   			+ "Weaver Lake is a medium sized lake, large enough to spend a few days exploring, "
		   			+ "but not large enough to get lost. Bring your own boat, use the public boat launch, spend a memorable day on the water." },
	   { "Weaver Lake Group Site", 
					"Enjoy exclusive use of this group site for your family or group gatherings. "
					+ "This site is located at the north east side of Weaver Lake and boasts a wharf, "
					+ "10 tenting pad sites and a communal fire ring."},
	   { "Grace Lake", 
					"Enjoy this small but popular camping site located next to Grace Lake. "
					+ "There is even a floating dock to fish from. "
					+ "A nice feature of this recreation site is the designated staging area and parking lot for "
					+ "motorized recreation that accesses the West Harrison Riding Area."},
	   { "Wolf Lake", 
					"A favorite small group campsite situated next to Wolf Lake. "
					+ "Enjoy fishing off the wharf. There are 3 designated sites with picnic tables, "
					+ "fire rings and an outhouse."},
	   { "Wood Lake", 
					"A large semi-open site with two camping areas, one on each side of the lake. "
					+ "Access is by gravel road and no power boats are allowed. "
					+ "We have picnic tables and fire rings at every site and outhouses positioned around the property."},
	   { "Wood Lake Group Site", 
					"This site is a large semi-open site with 6 camping sites. "
					+ "You are given a key for the gate, so you can come and go as you please. "
					+ "There is lots of room for extra vehicles by the campsites. "
					+ "Access is by gravel road and no power boats are allowed."},
	   { "Twenty Mile Bay", 
					"The sites are nestled in an old growth forest and is situated on a peninsula with over 1.5 km’s "
					+ "beaches facing North and South on the West shore of Harrison Lake. "
					+ "We have Picnic tables and fire pits at every site and outhouses positioned around the property."},
	   { "Chehalis River", 
					"This is a beautiful site situated amongst mature timber. "
					+ "It borders the Chehalis River, which offers excellent steelhead fishing opportunities. "
					+ "There are two smaller sites situated across the road that also border the river. "
					+ "The two smaller sites are used mainly as group sites and for day-use activities."},
	   { "Chehalis River N. Group Site", 
					"Chehalis River North Group Rec Site is located along the banks of Chehalis River. "
					+ "Access is by paved road. We have Picnic tables and fire pits at every site and outhouses positioned on the property. "
					+ "We offer a beautiful walking trail through the forest that terminates at the river downstream from the campground."},
	   { "Skwellepil Creek", 
					"Come out and enjoy this freshly restored site. "
					+ "Enjoy the large beautiful lake that is 10 km in length and is located in the Chehalis Valley, west of Harrison Lake. "
					+ "A boat launch is available for those interested in fishing, or exploring the coves and bays along the shoreline."}
	 };
	}
	
	@Test(dataProvider = "columns_smoketest", enabled = false)
	public void testCheckContentOfColumns(String campgroundName, String campgrundText){
		MainPage mainPage = new MainPage(driver);
		Assert.assertEquals(mainPage.getListOfColumns().size(), Constants.countOfCampgrounds, "Count of columns are not " + Constants.countOfCampgrounds + ".");
		Assert.assertEquals(mainPage.getColumnText(campgroundName), campgrundText, "Campground promotion text is not as expected.");
		CampgroundsPage campgroundPage = mainPage.clickOnReadMore(campgroundName);
		Assert.assertEquals(campgroundPage.getTitle(), campgroundName.replace("N.", "North"), "The title is not same as campground name");
	}

	@Test
	public void test(){
		MainPage mainPage = new MainPage(driver);
		ChehalisRiverPage chehalisRiverPage = (ChehalisRiverPage)mainPage.clickMenuItem(MenuItemsEnum.CAMPGROUND_CHEHALIS_RIVER);
		chehalisRiverPage.checkSubMenuItems();
	}
}
