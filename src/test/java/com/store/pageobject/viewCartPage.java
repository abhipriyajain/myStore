package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class viewCartPage {

	WebDriver ldriver;
	public viewCartPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"do_action\"]/div[1]/div/div/a") WebElement proccedTocheckout;
	@FindBy(xpath="//*[@id=\"checkoutModal\"]/div/div/div[2]/p[1]") WebElement text;
	@FindBy(linkText="Logout") WebElement logout;
	
	public void clicklogout()
	{
		logout.click();
	}

	
	public void proceedTocheckout()
	{
		proccedTocheckout.click();
	}
	
	public String validateTheText()
	{
		return(text.getText());
	}
}
