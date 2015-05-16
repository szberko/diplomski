package com.westharrison.pageutils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class PageUtils {

	private WebDriver driver;
	
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
}
