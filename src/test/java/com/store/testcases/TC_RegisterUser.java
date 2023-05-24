package com.store.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.pageobject.accountCreatedPage;
import com.store.pageobject.accountDeleted;
import com.store.pageobject.accountInfo;
import com.store.pageobject.indexPage;
import com.store.pageobject.loggedinPage;
import com.store.pageobject.loginPage;
import com.store.pageobject.logintoAccount;

public class TC_RegisterUser extends BaseClass {
	
	@Test(enabled=false)
	public void registerTheUser() throws IOException
	{
		
		indexPage pg = new indexPage(driver);
		pg.clickonSignIn();
		
		loginPage loginpg = new loginPage(driver);
		loginpg.ValdiatethetitleforSignUp();		
		loginpg.enterName("Abhip");
		loginpg.enterEmailAddress("abhitest221@asm.com");
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
//		captureScreenshot(driver,"registerTheUser");
//		Assert.assertTrue(false);
		
		acsucpage.cliconcontinueButton();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.switchTo().alert().dismiss();

		
		
		/*loggedinPage lgpg = new loggedinPage(driver);
		lgpg.getloggedinastext();
		logger.info("account logged in as of now");
		lgpg.clickondeleteaccountbtn();
		
		accountDeleted adpg = new accountDeleted(driver);
		adpg.verifyaccountdeletedtext();
		logger.info("Account deleted successfully");
		adpg.clickoncontbtn();
		logger.info("Testcase completed");
		logger.info("just for GIT");*/
	}

	@Test
	public void verifyLogin() throws IOException {
		
		logger.info("verify Login testcase started..");
		
		indexPage pg = new indexPage(driver);
		pg.clickonSignIn();
		
		logger.info("Cliked on signed in");
		logintoAccount la = new logintoAccount(driver);
		la.enterEmail("abhitest221@asm.com");
		la.enterPass("abhi12243");
		la.clickonsignin();
		
		loggedinPage lgpg = new loggedinPage(driver);
		String uname=lgpg.getUserName();
		
		if (uname.equals("Abhip"))
		{
			logger.info("VerifyLogin - Passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("VerifyLogin - Failed");
			captureScreenshot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
			

		
	}

	
	
	
	

}
