package com.westharrison.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.westharrison.pageutils.Constants;
import com.westharrison.pageutils.PageUtils;

public class GoogleLoginPage extends LoadableComponent<GoogleLoginPage>{

	private WebDriver driver;
	private PageUtils pageUtils;
	
	public GoogleLoginPage(WebDriver driver) {
		this.driver = driver;
		this.pageUtils = new PageUtils(driver);
		PageFactory.initElements(driver, this);
		this.get();
	}

	@Override
	protected void isLoaded() throws Error {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier", "You are not on the login page.");
	}

	@Override
	protected void load() {
		driver.get("https://www.gmail.com/intl/en/mail/help/about.html");
		pageUtils.waitForElementToAppear(By.cssSelector("#gmail-sign-in")).click();
	}
	
	@FindBy(css = "#Email")
	private WebElement emailInputField;
	
	@FindBy(css = "#next")
	private WebElement nextBtn;
	
	public GmailPage login(){
		emailInputField.sendKeys(Constants.email);
		nextBtn.click();
		getPasswordField().sendKeys(Constants.password);
		clickSignIn();
		
		return new GmailPage(driver);
	}
	
	private WebElement getPasswordField(){
		return pageUtils.waitForElementToAppear(By.cssSelector("#Passwd"));
	}
	
	private void clickSignIn(){
		pageUtils.waitForElementToAppear(By.cssSelector("#signIn")).click();
	}

}
