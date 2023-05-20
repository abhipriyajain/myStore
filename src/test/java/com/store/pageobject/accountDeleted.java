package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountDeleted {
WebDriver ldriver;
	
	public accountDeleted(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div/h2/b") WebElement accountdeletedtext;
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div/div/a") WebElement continuebtn;
	
	public void verifyaccountdeletedtext()
	{
		accountdeletedtext.isDisplayed();
	}
	
	public void clickoncontbtn() {
		continuebtn.click();
	}
	
	
}
