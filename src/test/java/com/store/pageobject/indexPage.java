package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {

	WebDriver ldriver;

	public indexPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//identify webelements
	@FindBy(linkText="Signup / Login") WebElement signUp;
	
	//perform action
	public void clickonSignIn() {
		signUp.click();
	}
	
			
	
}
