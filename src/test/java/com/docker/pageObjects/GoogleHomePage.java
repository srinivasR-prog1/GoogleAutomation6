package com.docker.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage {

	public WebDriver driver;
	public WebDriverWait wait;
	List<WebElement> searchSuggestion;

	public GoogleHomePage(WebDriver driver) {
		this.driver = driver;

		this.wait = new WebDriverWait(driver, 3000L);

		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "q")
	@CacheLookup
	 WebElement searchBox;	 
	 


	public void searchText(String searchKey) {
 	    searchBox.clear();
		searchBox.sendKeys(searchKey);
		searchSuggestion =driver.findElements(By.xpath("//*[contains(text(),'"+searchKey+"')]"));
		System.out.println("search value :"+searchSuggestion.size());	

	}
	
	public void clickSuggestionByIndex(int index)
	{
		
		System.out.println("the values of searchsuggestion :"+searchSuggestion.size());
		
		for(int i=0;i<=searchSuggestion.size();i++)
		
		{
			if(i==index)
			{
				
				System.out.println(searchSuggestion.get(i).getText());
				
				searchSuggestion.get(i).click();
				break;
				
				
			}
			
			
		}
		
		
		
	}
	
	public boolean isDisplayed()
	{
		
		this.wait.until(ExpectedConditions.visibilityOf(searchBox));
		return true;
		
	}

}
