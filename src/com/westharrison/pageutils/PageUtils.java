package com.westharrison.pageutils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageUtils {

	private WebDriver driver;
	protected static final int BASIC_WAIT_TIME_IN_SECONDS = 60;
	
	public PageUtils(WebDriver driver){
		this.driver = driver;
	}
	
	public void moveToElement(WebElement element){
		Actions builder = new Actions(driver);
		builder.moveToElement(element);
		Action moveToElement = builder.build();
		
		moveToElement.perform();
	}
	
	public void moveToElement(WebElement element, int xOffset, int yOffset){
		Actions builder = new Actions(driver);
		builder.moveToElement(element, xOffset, yOffset);
		Action moveToElement = builder.build();
		
		moveToElement.perform();
	}

	public void waitFor(Integer miliseconds){
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void refresh(){
		driver.navigate().refresh();
	}
	
	public Alert switchToAlert(){
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();
	}
	
	public void waitForJQueryToFinish() {
		int timeout = 0;
		while(timeout<400) {
			boolean ajaxWorking = (boolean) ((JavascriptExecutor) driver)
					.executeScript("return jQuery.active == 0");
			if(ajaxWorking) {
				break;
			}
			try{
				timeout++;
				Thread.sleep(500);
			} catch(Exception e) {

			}
		}
	}
	
	public WebElement waitForElementToAppear(WebElement element){
		int count = 0;
		while (count < 12){
			try {				
				WebDriverWait wait = new WebDriverWait(driver, BASIC_WAIT_TIME_IN_SECONDS / 12);	
				return wait.until(ExpectedConditions.visibilityOf(element));
			}catch (StaleElementReferenceException e){
				e.toString();
				System.out.println("Trying to recover from a stale element :" + e.getMessage());
				count = count+1;
			}
			catch (TimeoutException e) {
				count = count+1;
			}
		}

		Assert.fail("Element is not appeared: " + element);
		return null;
	}
	
	public WebElement waitForElementToAppear(By by){
		int count = 0;
		while (count < 12){
			try {				
				WebDriverWait wait = new WebDriverWait(driver, BASIC_WAIT_TIME_IN_SECONDS / 12);	
				return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			}catch (StaleElementReferenceException e){
				e.toString();
				System.out.println("Trying to recover from a stale element :" + e.getMessage());
				count = count+1;
			}
			catch (TimeoutException e) {
				count = count+1;
			}
		}

		Assert.fail("Element is not appeared: " + by);
		return null;
	}
	
	public void waitForElementToBeClickable(By locator) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 5);
		int count = 0; 
		while (count < 4){
			try {
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				return;
			} catch (StaleElementReferenceException e){
				e.toString();
				System.out.println("Trying to recover from a stale element :" + e.getMessage());
				count = count+1;
			}
			count = count+4;
		}
	}

	public WebElement waitForElementToBeClickable(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		int count = 0; 
		while (count < 4){
			try {
				return wait.until(ExpectedConditions.elementToBeClickable(element));
			} catch (StaleElementReferenceException e){
				System.out.println("Trying to recover from a stale element :" + e.getMessage());
				count = count+1;
			} catch (TimeoutException e) {
				count = count+1;
			}
		}
		
		throw new AssertionError("Element is not clickable after 20 sec");
	}
}
