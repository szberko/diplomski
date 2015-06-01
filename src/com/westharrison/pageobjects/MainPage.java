package com.westharrison.pageobjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.westharrison.pageobjects.campgrounds.CampgroundsPage;
import com.westharrison.pageutils.PageUtils;

public class MainPage extends AbstractPageObject<MainPage>{

	
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
		super(driver);
		PageFactory.initElements(driver, this);
		this.get();
	}
	
	@FindBy(css = ".nivo-prevNav")
	private WebElement slideshowPreviousBtn;
	
	@FindBy(css = ".nivo-nextNav")
	private WebElement slideshowNextBtn;
	
	@FindBy(css = ".nivo-imageLink")
	private List<WebElement> listOfSlides;
	
	@FindBy(css = "#slider")
	private WebElement slideShow;
	
	@FindBy(xpath = "//div[@id = 'front-columns']/div")
	private List<WebElement> listOfColumns;
	
	public void clickSlideShowPreviousBtn(){
		slideshowPreviousBtn.click();
	}
	
	public void clickSlideShowNextBtn(){
		pageUtils.waitForElementToAppear(slideshowNextBtn).click();
	}
	
	public List<WebElement> getListOfSlides(){
		return listOfSlides;
	}
	
	public WebElement getSlideShow(){
		return slideShow;
	}
	
	public String getCaptionOfActualSlide(){
		String caption = "";
		try{
			caption = pageUtils.waitForElementToAppear(By.cssSelector(".nivo-caption h2")).getText();
		}catch(StaleElementReferenceException ex) {
			caption = pageUtils.waitForElementToAppear(By.cssSelector(".nivo-caption h2")).getText();
		}
		return caption;
	}
	
	public String getTextOfActualSlide(){
		String text = "";
		try{
			text = pageUtils.waitForElementToAppear(By.cssSelector(".nivo-caption .slide-text")).getText();
		}catch(StaleElementReferenceException ex){
			text = pageUtils.waitForElementToAppear(By.cssSelector(".nivo-caption .slide-text")).getText();
		}
		return text;
	}
	
	public List<WebElement> getListOfColumns(){
		return listOfColumns;
	}
	
	public String getColumnText(String campgroundName){
		WebElement columnImage = pageUtils.waitForElementToAppear(By.xpath("//div[@id = 'front-columns']/div//h3[text()='" + campgroundName + "']/../../div[@class='column-image']"));
		pageUtils.moveToElement(columnImage, 5, 5);
		WebElement columnText = pageUtils.waitForElementToAppear(By.xpath("//div[@id = 'front-columns']/div//h3[text()='" + campgroundName + "']/../..//div[@class = 'column-text']"));
		return columnText.getText();
	}
	
	public CampgroundsPage clickOnReadMore(String campgroundName){
//		WebElement campgrundColumn = pageUtils.waitForElementToAppear(By.xpath("//div[@id = 'front-columns']/div//h3[text()='" + campgroundName + "']/../..//div[@class='column-image']"));
//		pageUtils.moveToElement(campgrundColumn, 20, 20);
		pageUtils.waitForElementToAppear(By.xpath("//div[@id = 'front-columns']/div//h3[text()='" + campgroundName + "']/../..//div[@class='columnmore']/a")).click();
		return new CampgroundsPage(driver).get();
	}

}
