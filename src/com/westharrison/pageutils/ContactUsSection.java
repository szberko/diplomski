package com.westharrison.pageutils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.westharrison.pageobjects.AbstractPageObject;

public class ContactUsSection extends LoadableComponent<ContactUsSection>{

	private WebDriver driver;
	private PageUtils pageUtils;
	
	@Override
	protected void isLoaded() throws Error {
		
	}

	@Override
	protected void load() {
		
	}

	public ContactUsSection(WebDriver driver) {
		this.driver = driver;
		this.pageUtils = new PageUtils(driver);
		PageFactory.initElements(driver, this);
		this.get();
	}
	
	@FindBy(name = "your-name")
	private WebElement nameInputField;
	
	@FindBy(name = "your-email")
	private WebElement emailInputField;
	
	@FindBy(name = "your-subject")
	private WebElement subjetInputField;
	
	@FindBy(name = "your-message")
	private WebElement messageInputField;
	
	@FindBy(xpath = ".//input[@type='submit']")
	private WebElement sendBtn;
	
	public void fillName(String name){
		nameInputField.sendKeys(name);
	}
	
	public void fillEmail(String email){
		emailInputField.sendKeys(email);
	}
	
	public void fillSubject(String subject){
		subjetInputField.sendKeys(subject);
	}
	
	public void fillMessage(String message){
		messageInputField.sendKeys(message);
	}
	
	public void clickSendBtn(){
		sendBtn.click();
	}
	
	public void selectCampground(String... campgrounds){
		if(campgrounds.length > 1){
			Actions builder = new Actions(driver);
			builder.keyDown(Keys.COMMAND);

			for (String campground : campgrounds) {
				builder.click(pageUtils.waitForElementToAppear(By.xpath(".//option[@value='" + campground + "']")));
			}

			builder.keyUp(Keys.COMMAND);
			Action selectCampground = builder.build();
			selectCampground.perform();
		}else{
			pageUtils.waitForElementToAppear(By.xpath(".//option[@value='" + campgrounds[0] + "']")).click();
		}
	}
}
