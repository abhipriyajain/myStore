package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver ldriver;
	
	public loginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="name") WebElement name;
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]") WebElement email;
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/h2") WebElement text;
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/button") WebElement signUpbtn;
	
	public void enterName(String fname)
	{
		name.sendKeys(fname);
	}
	
	public void enterEmailAddress(String emailadd)
	{
		email.sendKeys(emailadd);
	}
	
	public void ValdiatethetitleforSignUp()
	{
		System.out.println(text.getText());
		
		}
	
	public void clickonSignUp()
	{
		signUpbtn.click();
	}
	

}
