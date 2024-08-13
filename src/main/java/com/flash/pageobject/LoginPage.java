package com.flash.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flash.actiondriver.Action;
import com.flash.base.BaseClass;

public class LoginPage extends BaseClass{
	
	Action action =new Action();
	
	
	@FindBy(xpath ="//input[@id='Email']")

	WebElement Email;

	
	@FindBy(xpath ="//input[@id='Password']")

	WebElement Password;
	
	@FindBy(css ="button.button-1.login-button")

	WebElement loginBtn;
	
	
	public LogOutPage login(String email ,String password)
	{
		action.type(Email, email);
		action.type(Password, password);
		action.JSClick(driver, loginBtn);
		return new LogOutPage();
		
		
		//
	}
	
	
	
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

}
