package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class productPage {

	WebDriver ldriver;
	
	public productPage(WebDriver rdriver){
	
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="/html/body/section[2]/div[1]/div/div[2]/div[1]/div[9]/div/div[2]/ul/li/a") WebElement viewProduct;
	@FindBy(xpath="/html/body/section[2]/div/div/div[2]/div[1]/div[9]/div/div[1]/div[2]/div/a") WebElement addToCart;
	@FindBy(linkText="/view_cart") WebElement viewCart;
	
	public void viewProd() {
		viewProduct.click();
	}
	
	public void addToCart()
	{
		addToCart.click();
	}
	
	public void viewCart()
	{
		viewCart.click();
	}
}
