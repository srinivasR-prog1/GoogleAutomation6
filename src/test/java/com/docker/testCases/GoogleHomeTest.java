package com.docker.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.docker.pageObjects.BaseClass;
import com.docker.pageObjects.GoogleHomePage;

public class GoogleHomeTest extends BaseClass {
	
	@Test	
	public void searchTest()
	{
	driver.get("https://www.google.com/");
	GoogleHomePage gp = new GoogleHomePage(driver);
	gp.isDisplayed();
	Assert.assertEquals(driver.getTitle(), "Google");
	
	}
	

}
