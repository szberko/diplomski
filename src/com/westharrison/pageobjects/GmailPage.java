package com.westharrison.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.westharrison.pageutils.PageUtils;

public class GmailPage extends LoadableComponent<GmailPage>{

	private WebDriver driver;
	private PageUtils pageUtils;
	
	@Override
	protected void isLoaded() throws Error {
		try{
			Assert.assertTrue(driver.findElement(By.cssSelector("img[alt='Gmail by Google']")).isDisplayed(), "The page is not loaded fully");
		}catch(NoSuchElementException ex){
			throw new AssertionError();
		}
	}

	@Override
	protected void load() {
		pageUtils.waitForElementToAppear(By.cssSelector("img[alt='Gmail by Google']"));
	}
	
	@FindBy(xpath = ".//table[@class='th']//tr[1]")
	private WebElement firstRow;
	
	public GmailPage(WebDriver driver){
		this.driver = driver;
		this.pageUtils = new PageUtils(driver);
		PageFactory.initElements(driver, this);
		this.get();
	}
	
	public void clickOnFirstEmail(){
		refreshThePageUntilTheNewMaiLComes();
		pageUtils.waitForElementToBeClickable(firstRow).click();
		
	}
	
	private void refreshThePageUntilTheNewMaiLComes(){
		while(!driver.findElement(By.xpath("//table[@class='th']//tbody//tr[1]")).getAttribute("bgcolor").equalsIgnoreCase("#FFFFFF")){
			pageUtils.waitFor(10000);
			driver.findElement(By.xpath("//a[text()='Refresh']")).click();
		}
	}
	
	public String getEmailTitle(){
		return pageUtils.waitForElementToAppear(By.xpath(".//table[@class='h']//h2//b")).getText();
	}
	
	public String getMessageBody(){
		return pageUtils.waitForElementToAppear(By.cssSelector("div.msg")).getText();
	}

}
