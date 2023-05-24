package com.store.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sore.utilities.readExcelFile;
import com.store.pageobject.accountCreatedPage;
import com.store.pageobject.accountInfo;
import com.store.pageobject.indexPage;
import com.store.pageobject.loggedinPage;
import com.store.pageobject.loginPage;
import com.store.pageobject.logintoAccount;

public class TC_RegisterUser_DataDriven extends BaseClass {
	
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

	@Test(dataProvider = "LoginDataProvider")
	public void verifyLogin(String email, String pswd, String expectedUname) throws IOException {
		
		logger.info("verify Login testcase started..");
		
		indexPage pg = new indexPage(driver);
		pg.clickonSignIn();
		
		logger.info("Cliked on signed in");
		logintoAccount la = new logintoAccount(driver);
		la.enterEmail(email);
		logger.info("email address entered");
		la.enterPass(pswd);
		logger.info("Password entered");
		la.clickonsignin();
		logger.info("Logging in");
		
		loggedinPage lgpg = new loggedinPage(driver);
		String uname=lgpg.getUserName();
		
		if (uname.equals(expectedUname))
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
			lgpg.clicklogout();

		
	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider() throws IOException
	{
		
		String filename = System.getProperty("user.dir") + "//testDataExcel//testData.xlsx";
		
		int ttlrows = readExcelFile.getRowCount(filename, "sheet1");
		int ttlcols = readExcelFile.getColCount(filename, "sheet1");
		
		String data[][] = new String [ttlrows-1][ttlcols];
		
		for (int i=1;i<ttlrows;i++)
		{
			for(int j=0;j<ttlcols;j++)
			{
				data[i-1][j]=readExcelFile.getCellValue(filename, "sheet1", i, j);
			}
		}
		return data;
	}
	
	
	

}
