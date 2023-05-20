package com.store.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.store.pageobject.accountCreatedPage;
import com.store.pageobject.accountDeleted;
import com.store.pageobject.accountInfo;
import com.store.pageobject.indexPage;
import com.store.pageobject.loggedinPage;
import com.store.pageobject.loginPage;

public class TC_RegisterUser extends BaseClass {
	
	@Test
	public void registerTheUser()
	{
		driver.get(url);
		driver.manage().window().maximize();
		logger.info("URL Opened, page viewed successfully");
			
		indexPage pg = new indexPage(driver);
		pg.clickonSignIn();
		
		loginPage loginpg = new loginPage(driver);
		loginpg.ValdiatethetitleforSignUp();		
		loginpg.enterName("Abhip");
		loginpg.enterEmailAddress("abhitest1233@asm.com");
		logger.info("Name and email entered");
		loginpg.clickonSignUp();
		logger.info("User ready to create account, enter the details now");		
		
		accountInfo acctpg = new accountInfo(driver);
		acctpg.selecttitle();
		acctpg.enterpassword("abhi12243");
		acctpg.enterdays("2");
		acctpg.entermonths("May");
		acctpg.enteryears("1985");
		acctpg.tickoncheckboxfornewsletter();
		acctpg.enterfirstname("Abhipr");
		acctpg.enterlastname("jain");
		acctpg.enteraddress1("schiess");
		acctpg.entercity("Indore");
		acctpg.enterstate("Maharastra");
		acctpg.enterzipcode("47300");
		acctpg.entermobilenum("8383909011");
		
		
		acctpg.clickonCreateAccount();
		
		logger.info("Account creation in progress...");
		
		accountCreatedPage acsucpage = new accountCreatedPage(driver);
		acsucpage.verifythetextaccountcreated();
		logger.info("Account is created successfully");
		acsucpage.cliconcontinueButton();
		
		loggedinPage lgpg = new loggedinPage(driver);
		lgpg.getloggedinastext();
		logger.info("account logged in as of now");
		lgpg.clickondeleteaccountbtn();
		
		accountDeleted adpg = new accountDeleted(driver);
		adpg.verifyaccountdeletedtext();
		logger.info("Account deleted successfully");
		adpg.clickoncontbtn();
		logger.info("Testcase completed");
	}
	

}
