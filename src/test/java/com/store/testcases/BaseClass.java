package com.store.testcases;



import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.sore.utilities.readConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	readConfig readcon = new readConfig();
	
	String url = readcon.getBaseUrl();
	String browser=readcon.getbrowser();
	
	public static WebDriver driver;
	public static Logger logger;	

	@BeforeClass
	public void setup()
	{
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();	
			driver = new FirefoxDriver();
			break;
			
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		default:
			driver=null;
			break;
						
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		logger = LogManager.getLogger("StoreTest");
		
	}
	
//	@AfterClass
	/*public void teardown()
	{
		driver.close();
		driver.quit();
	}*/
	
	
}
