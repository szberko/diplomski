package com.westharrison.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.westharrison.pageutils.BookingCalendarIframe;
import com.westharrison.pageutils.PageUtils;

public class MakeAReservationPage extends AbstractPageObject<MakeAReservationPage>{
	
	public MakeAReservationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.get();
	}

	@Override
	protected void isLoaded() throws Error {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.equals("http://westharrisonreservations.com/make-reservation"), "Not on the right page.");
		
		try{
			Assert.assertTrue(super.driver.findElement(By.cssSelector(".entry-title")).isDisplayed(), "The page is not loaded fully");
		}catch(NoSuchElementException ex){
			throw new AssertionError();
		}		
	}

	@Override
	protected void load() {
		
	}
	
	@FindBy(css = "#bookingcalendar")
	private WebElement bookingCalendarIframe;
	
	public BookingCalendarIframe switchToBookingCalendar(){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(bookingCalendarIframe);
		return new BookingCalendarIframe(driver);
	}
	
	public void switchToDefaultContent(){
		driver.switchTo().defaultContent();
	}

}
