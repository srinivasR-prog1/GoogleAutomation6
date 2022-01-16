package com.docker.pageObjects;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class BaseClass {

//	public WebDriver driver = null;
	
	public WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void setUp(String browserName) throws MalformedURLException {
		
		String host = "selenium-hub";

		DesiredCapabilities dc = new DesiredCapabilities();

		if (browserName.equalsIgnoreCase("chrome")) {

			dc.setBrowserName(BrowserType.CHROME);

		} else if (browserName.equalsIgnoreCase("firefox")) {

			dc.setBrowserName(BrowserType.FIREFOX);

		}
		
		/*if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		    driver= new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			
		}*/
		
		String completeURL = "http://" + host + ":4444/wd/hub";
		driver = new RemoteWebDriver(new URL(completeURL), dc);
	//	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		

	
		

	}
	
	


	@AfterTest()
	public void tearDown() {

		driver.quit();

	}

}
