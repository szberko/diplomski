package com.westharrison.pageutils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

public class BookingCalendarIframe extends LoadableComponent<BookingCalendarIframe>{

	@Override
	protected void isLoaded() throws Error {
		
	}

	@Override
	protected void load() {
		
	}
	
	private WebDriver driver;
	private PageUtils pageUtils;
	
	public BookingCalendarIframe(WebDriver driver) {
		this.driver = driver;
		this.pageUtils = new PageUtils(driver);
		PageFactory.initElements(driver, this);
		this.get();
	}
	
	public void selectCampground(String campgroundName){
		pageUtils.waitForElementToAppear(By.xpath(".//div[@class='item']//h3/a[text()='" + campgroundName + "']")).click();
		//Click on Book Now button
		pageUtils.moveToElementAndClick(By.cssSelector(".button-bar button"));
	}
	
	public void selectCamsite(String campsiteName){
		Select campsiteList = new Select(pageUtils.waitForElementToAppear(By.cssSelector("#uid")));
		campsiteList.selectByVisibleText(campsiteName);
	}
	
	public String reserveFirstTwoAvailableDays(){
		WebElement fromDateElement = pageUtils.waitForElementToAppear(By.xpath("/descendant::td[@class='av'][1]"));
		String date = fromDateElement.getAttribute("onclick");
		String fromDate = date.substring(date.indexOf('\'') + 1, date.lastIndexOf('\''));
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("M/d/YY");
		DateTime jodaFromDate;
		DateTime jodaToDate = formatter.parseDateTime(fromDate);
		
		String fromDateClassAttr = "";
		String toDateClassAttr = "";
		
		do{
			jodaFromDate = new DateTime(jodaToDate);
			fromDateClassAttr = pageUtils.waitForElementToAppear(By.xpath("//td[contains(@onclick,'" + jodaFromDate.toString(formatter) + "')]")).getAttribute("class");
			jodaToDate = jodaToDate.plusDays(1);
			toDateClassAttr = pageUtils.waitForElementToAppear(By.xpath("//td[contains(@onclick,'" + jodaToDate.toString(formatter) + "')]")).getAttribute("class");
		}while(!fromDateClassAttr.equals("av") || !toDateClassAttr.equals("av"));
		
		pageUtils.waitForElementToAppear(By.xpath("//td[@class='av'][contains(@onclick,'" + jodaFromDate.toString(formatter) + "')]")).click();
		pageUtils.waitForElementToAppear(By.xpath("//td[@class='av'][contains(@onclick,'" + jodaToDate.toString(formatter) + "')]")).click();
		
		return jodaFromDate.toString(formatter) + " - " + jodaToDate.toString(formatter);
	}
	
	public String reserveDateRange(DateTime fromDate, DateTime toDate){
		String fromDateString = fromDate.toString(DateTimeFormat.forPattern("M/d/YY"));
		String toDateString = toDate.toString(DateTimeFormat.forPattern("M/d/YY"));
		
		pageUtils.waitForElementToAppear(By.xpath("//td[@class='av'][contains(@onclick,'" + fromDateString + "')]")).click();
		pageUtils.waitForElementToAppear(By.xpath("//td[@class='av'][contains(@onclick,'" + toDateString + "')]")).click();
		
		return fromDateString + " - " + toDateString;
	}
	
	public void clickNext(){
		pageUtils.waitForElementToAppear(By.cssSelector("#btnAddToCart")).click();
	}
	
	public String getLastReservedCampsiteDetails(){
		WebElement lastReserverdCampsite = pageUtils.waitForElementToAppear(By.cssSelector(".last .desc:first-child"));
		return lastReserverdCampsite.getText();
	}
	
	public void clickOnViewProducts(){
		pageUtils.waitForElementToAppear(By.cssSelector("#btnViewProducts")).click();
	}
	
	public void removeCampsiteFromShoppingCart(String campsite, String dateRange){
		pageUtils.waitForElementToAppear(By.xpath("//div[@class='desc'][text()[contains(.,'" + campsite + "')] and text()[contains(.,'" + dateRange + "')]]/div[@class='removeitem']/a[2]")).click();
	}
	
	public void changeCampsiteFromShoppingCart(String campsite, String dateRange){
		pageUtils.waitForElementToAppear(By.xpath("//div[@class='desc'][text()[contains(.,'" + campsite + "')] and text()[contains(.,'" + dateRange + "')]]/div[@class='removeitem']/a[1]")).click();
	}
	
	////td[@class='av'][@onclick[contains(.,'6/1/15')]]
	////td[@class='av'][contains(@onclick,'6/4/15')]
}
