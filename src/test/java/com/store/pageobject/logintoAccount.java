package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logintoAccount {

	WebDriver ldriver;
	
	public logintoAccount(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]") WebElement emailadd;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div/form/button") WebElement signbtn;
	@FindBy(xpath="/html/body/header/div/div/div/div[1]/div/a/img") WebElement home;

	public void clickonhome()
	{
		home.click();
	}
	
	public void enterEmail(String ema)
	{
		emailadd.sendKeys(ema);
	}
	
	public void enterPass(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickonsignin()
	{
		signbtn.click();
	}
	
	
}
