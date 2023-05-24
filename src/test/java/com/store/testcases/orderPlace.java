package com.store.testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.pageobject.productDetails;
import com.store.pageobject.productPage;
import com.store.pageobject.viewCartPage;

public class orderPlace extends BaseClass{
	
	
	@Test(priority=2)
	public void orderWithoutLogin() throws IOException
	{
		logger.info("order some product without logging in");
		productPage ppg = new productPage(driver);
		ppg.viewProd();
		logger.info("Product View page loaded");
		
		productDetails pd = new productDetails(driver);
		pd.addtocart();
		logger.info("product added to cart");
		pd.viewCart();
		
		viewCartPage vcp = new viewCartPage(driver);
		vcp.proceedTocheckout();
		String actualmsg = vcp.validateTheText();
		String expectedAlertMsg = "Register / Login account to proceed on checkout.";
		if(actualmsg.equals(expectedAlertMsg))
		{
			logger.info("verifyAddToCartWithoutLogin - passed"); 
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("verifyAddToWishlistWithoutLogin - failed"); 
			captureScreenshot(driver,"verifyAddToWishlistWithoutLogin");
			Assert.assertTrue(false);
		}
		
		
		
		
		
		
		
		
	}

}
