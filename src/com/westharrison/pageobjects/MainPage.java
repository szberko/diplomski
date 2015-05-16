package com.westharrison.pageobjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class MainPage extends LoadableComponent<MainPage>{

	private WebDriver driver;
	private HashMap<String, String> slidesText;
	
	@Override
	protected void isLoaded() throws Error {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.equals("http://westharrisonreservations.com/"), "Not on the right page.");
	}

	@Override
	protected void load() {
		driver.get("http://westharrisonreservations.com");
	}
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		this.slidesText = new HashMap<String, String>();
		initSlidesText();
		
		PageFactory.initElements(driver, this);
	}
	
	public void initSlidesText(){
		slidesText.put("Weaver Lake", 
				"There is no better way to spend a day than on the water. "
				+ "Weaver Lake is a medium sized lake, large enough to spend a few days exploring, "
				+ "but not large enough to get lost. Bring your own boat, use the public boat launch, "
				+ "spend a memorable day on the water.");
		slidesText.put("Weaver Lake Group Site", 
				"Enjoy exclusive use of this group site for your family or group gatherings. "
				+ "This site is located at the north east side of Weaver Lake and boasts a wharf, "
				+ "10 tenting pad sites and a communal fire ring. "
				+ "will actually climb the mountain for you.");
		slidesText.put("Grace Lake", 
				"Enjoy this small but popular camping site located next to Grace Lake. "
				+ "There is even a floating dock to fish from. A nice feature of this recreation site "
				+ "is the designated staging area and parking lot for motorized "
				+ "recreation that accesses the West Harrison Riding Area.");
		slidesText.put("Wolf Lake", 
				"A favorite small group campsite situated next to Wolf Lake. "
				+ "Enjoy fishing off the wharf. There are 3 designated sites with picnic tables, fire rings and an outhouse.");
		slidesText.put("Wood Lake", 
				"A large semi-open site with two camping areas, one on each side of the lake. "
				+ "Access is by gravel road and no power boats are allowed. "
				+ "We have picnic tables and fire rings at every site and outhouses positioned around the property.");
	}
	
	public String getSlideText(String key){
		return slidesText.get(key);
	}
	
	@FindBy(css = ".nivo-prevNav")
	private WebElement slideshowPreviousBtn;
	
	@FindBy(css = ".nivo-nextNav")
	private WebElement slideshowNextBtn;
	
	@FindBy(css = ".nivo-imageLink")
	private List<WebElement> listOfSlides;
	
	@FindBy(css = "#slider")
	private WebElement slideShow;
	
	public void clickSlideShowPreviousBtn(){
		slideshowPreviousBtn.click();
	}
	
	public void clickSlideShowNextBtn(){
		slideshowNextBtn.click();
	}
	
	public List<WebElement> getListOfSlides(){
		return listOfSlides;
	}
	
	public WebElement getSlideShow(){
		return slideShow;
	}
	
	public String getCaptionOfActualSlide(){
		String caption = driver.findElement(By.cssSelector(".nivo-caption h2")).getText();
		return caption;
	}
	
	public String getTextOfActualSlide(){
		String text = driver.findElement(By.cssSelector(".nivo-caption .slide-text")).getText();
		return text;
	}
	

}
