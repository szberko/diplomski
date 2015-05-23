package com.westharrison.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.westharrison.pageutils.ContactUsSection;
import com.westharrison.pageutils.PageUtils;

public class ContactUsPage extends AbstractPageObject<ContactUsPage>{
	
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
		this.contactUsSection = new ContactUsSection(driver);
		PageFactory.initElements(driver, this);
		this.get();
	}

	@Override
	protected void isLoaded() throws Error {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.equals("http://westharrisonreservations.com/contact-us"), "Not on the right page.");
		
		try{
			Assert.assertTrue(super.driver.findElement(By.cssSelector(".entry-title")).isDisplayed(), "The page is not loaded fully");
		}catch(NoSuchElementException ex){
			throw new AssertionError();
		}
	}

	@Override
	protected void load() {
		
	}
	
	private ContactUsSection contactUsSection;
	
	public void fillContactUsForm(String name, String email, String subject, String message, String... campgrounds){
		contactUsSection.fillName(name);
		contactUsSection.fillEmail(email);
		contactUsSection.fillSubject(subject);
		contactUsSection.fillMessage(message);
		contactUsSection.selectCampground(campgrounds);
		contactUsSection.clickSendBtn();
		WebElement response = pageUtils.waitForElementToAppear(By.xpath(".//div[@role='alert'][@class!='screen-reader-response']"));
		Assert.assertEquals(response.getText(), "Your message was sent successfully. Thanks.", "The response message is not the expected");
	}

}
