package com.store.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.pageobject.indexPage;
import com.store.pageobject.logintoAccount;
import com.store.pageobject.productDetails;
import com.store.pageobject.productPage;


public class tc_writeReview extends BaseClass{
	@Test(priority=1)
	public void writeReview() {
	logger.info("Execution started for placing the order...");
	indexPage ipg = new indexPage(driver);
	ipg.clickonSignIn();
	logger.info("Lets start with login");
	
	logintoAccount la = new logintoAccount(driver);
	la.enterEmail("abhitest221@asm.com");
	logger.info("email entered");
	la.enterPass("abhi12243");	
	logger.info("pswd entered");
	la.clickonsignin();
	logger.info("signin button clicked..User logging in");
	
	productPage ppg = new productPage(driver);
	ppg.viewProd();
	logger.info("View product page clicked");
	
   	productDetails ppd = new productDetails(driver);
	ppd.enterEmail("abhi@asd.com");
	logger.info("email entered for review");
	ppd.enterName("Abi");
	ppd.enterReview("Very good");
	logger.info("review given");
	ppd.submitTheReview();
	logger.info("review submitted");
	Assert.assertTrue(true);
			
	}
	
}
