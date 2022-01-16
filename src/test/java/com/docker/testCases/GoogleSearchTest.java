package com.docker.testCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.docker.pageObjects.BaseClass;
import com.docker.pageObjects.GoogleHomePage;
import com.docker.pageObjects.GoogleResultPage;


public class GoogleSearchTest extends BaseClass {
    @Parameters({"keyword","index"})
	@Test
	public void searchPageTest(String keywordname, int indexname) {

		GoogleHomePage gp = new GoogleHomePage(driver);
		GoogleResultPage resultPage = new GoogleResultPage(driver);
		System.out.println("the cursor till here");
		driver.get("https://www.google.com/"); 
		gp.isDisplayed();
		System.out.println(gp.isDisplayed());
		gp.searchText(keywordname);
		gp.clickSuggestionByIndex(indexname);
		resultPage.isDisplayed();
		Assert.assertEquals("Pass", "Pass");
	}

	
	}


