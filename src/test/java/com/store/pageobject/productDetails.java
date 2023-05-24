package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productDetails {

	WebDriver ldriver;
	
	public productDetails(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="name") WebElement name;
	@FindBy(id="email") WebElement email;
	@FindBy(id="review") WebElement review;
	@FindBy(id="button-review") WebElement submit;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button") WebElement addd;
	@FindBy(xpath="//u[normalize-space()='View Cart']") WebElement viewCart;
	@FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a") WebElement logout;
	public void clicklogout()
	{
		logout.click();
	}

	
	public void viewCart()
	
	{
		viewCart.click();
	}
	
	public void addtocart()
	{
		addd.click();
	}
	
	public void enterName(String nm)
	{
		name.sendKeys(nm);
	}
	
	public void enterEmail(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void enterReview(String rvw)
	{
		review.sendKeys(rvw);
	}
	
	public void submitTheReview()
	{
		submit.click();
	}
	
}
