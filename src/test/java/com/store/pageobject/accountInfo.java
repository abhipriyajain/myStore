package com.store.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountInfo {
	
	WebDriver ldriver;
	
	public accountInfo(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="uniform-id_gender2") WebElement title;
	@FindBy(id="password") WebElement password;
	@FindBy(id="days") WebElement days;
	@FindBy(id="months") WebElement months;
	@FindBy(id="years") WebElement years;
	@FindBy(id="first_name") WebElement fname;
	@FindBy(id="last_name") WebElement lname;
	@FindBy(id="address1") WebElement address;
	@FindBy(id="newsletter") WebElement news;
	@FindBy(id="state") WebElement state;
	@FindBy(id="city") WebElement city;
	@FindBy(id="zipcode") WebElement zipcode;
	@FindBy(id="mobile_number") WebElement mobile;
	@FindBy(xpath="/html/body/section/div/div/div/div[1]/form/button") WebElement Createaccntbtn;
	
	
	public void selecttitle()
	{
		title.click();
	}
	
	public void enterpassword(String pswd)
	{
		password.sendKeys(pswd);
	}
	
	public void enterdays(String daystext)
	{
		Select obj = new Select(days);
		obj.selectByVisibleText(daystext);
	}
	
	public void entermonths(String monthstext)
	{
		Select obj = new Select(months);
		obj.selectByVisibleText(monthstext);
	}
	
	public void enteryears(String yearstext)
	{
		Select obj = new Select(years);
		obj.selectByVisibleText(yearstext);
	}
	
	
	public void enterfirstname(String finame)
	{
		fname.sendKeys(finame);
	}
	
	public void tickoncheckboxfornewsletter()
	{
		news.click();
	}
	
	public void enterlastname(String laname)
	{
		lname.sendKeys(laname);
	}
	
	public void enteraddress1(String add1)
	{
		address.sendKeys(add1);
	}
	
	public void enterstate(String stt)
	{
		state.sendKeys(stt);
	}
	
	
	public void entercity(String ct)
	{
		city.sendKeys(ct);
	}
	
	
	public void enterzipcode(String zip)
	{
		zipcode.sendKeys(zip);
	}
	
	
	public void entermobilenum(String num)
	{
		mobile.sendKeys(num);
	}
	
	public void clickonCreateAccount()
	{

		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].scrollIntoView();", Createaccntbtn);
		Createaccntbtn.click();
	}
	
		
	

}
