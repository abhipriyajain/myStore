package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loggedinPage {

	WebDriver ldriver;
	
	public loggedinPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/text()") WebElement loggedinas;
	@FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a") WebElement deleteAccountbtn;
	
	public void getloggedinastext()
	{
		loggedinas.isDisplayed();
	}
	
	public void clickondeleteaccountbtn() {
		deleteAccountbtn.click();
	}
	
	
}
