package com.westharrison.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.westharrison.enums.BrowserTypes;

public class FirstTest extends TestBase{

	private WebDriver driver;
	
	@BeforeTest
	public void before(){
		this.driver = getDriver();
	}
	
	@Test
	public void test(){
		System.out.println("TEST!!!!!");
	}

}
