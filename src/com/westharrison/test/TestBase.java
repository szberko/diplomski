package com.westharrison.test;

import java.awt.Toolkit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.westharrison.enums.BrowserTypes;

public class TestBase {
	
	protected final static Logger logger = LoggerFactory.getLogger(TestBase.class);
	protected WebDriver driver = null;
	
	public WebDriver getDriver(){
		return driver;
	}
	
	@Parameters("browser")
	@BeforeTest
	public void before(@Optional("chrome") String type){
		BrowserTypes browser = BrowserTypes.valueOf(type);
		initBrowser(browser);
		driver.get("http://westharrisonreservations.com");
	}
	
	@AfterTest
	public void tearDown(){
		driver.close();
	}
	
	private void initBrowser(BrowserTypes type){
		switch (type) {
		case chrome:{
				driver = new ChromeDriver();
			break;
		}

		case firefox:{
				driver = new FirefoxDriver();
			break;
		}

		case safari:{
				driver = new SafariDriver();
			break;
		}

		default:{
			driver = new ChromeDriver();
			break;
		}
		}
		
		Point targetPosition = new Point(0, 0);
		driver.manage().window().setPosition(targetPosition);
		
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();

		driver.manage().window().setSize(new Dimension(width, height));
	}
}
