package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountCreatedPage {

	WebDriver ldriver;
	
	public accountCreatedPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div/h2/b") WebElement acctCreated;
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div/div/a") WebElement continutBtn;
	
	
	public void verifythetextaccountcreated()
	{
		System.out.println(acctCreated.getText());

	}
	
	public void cliconcontinueButton()
	{
		continutBtn.click();
	}
}
