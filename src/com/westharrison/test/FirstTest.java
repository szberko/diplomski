package com.westharrison.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.westharrison.enums.BrowserTypes;
import com.westharrison.pageobjects.MainPage;
import com.westharrison.pageutils.PageUtils;

public class FirstTest extends TestBase{

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
				+ "We have picnic tables and fire rings at every site and outhouses positioned around the property."},
	 };
	}
	
	@Test(dataProvider = "slideshow_smoketest")
	public void test(String campgroundName, String campgrundText){
		MainPage mainPage = new MainPage(driver).get();
		Assert.assertTrue(mainPage.getListOfSlides().size() == 5, "The count of slides is not equal with 5");
		
		pageUtils.moveToElement(mainPage.getSlideShow(), 20, 20);
		while(!mainPage.getCaptionOfActualSlide().equals(campgroundName)){
			mainPage.clickSlideShowNextBtn();
		}
		//Moving mouse into the slide show to pause it
		pageUtils.moveToElement(mainPage.getSlideShow(), 20, 20);
		Assert.assertEquals(mainPage.getTextOfActualSlide(), campgrundText, "There is a difference in text on the slide");
	}
}
