package com.flash.pageobject;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flash.actiondriver.Action;
import com.flash.base.BaseClass;

public class HomePage extends BaseClass {
	
	Action action =new Action();
	
	@FindBy(xpath = "//a[@class='ico-register']")

	WebElement registerBtn;
	
	
	@FindBy(css = "a.ico-login")

	WebElement logInBtn;
	
	

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public RegestrationPage clickOnRegisterBtn()
	{
		 
		action.JSClick(driver, registerBtn);
		return new RegestrationPage();
	}
	
	
	public LoginPage clickOnLoginBtn()
	{
		action.JSClick(driver, logInBtn);
		return new LoginPage();
	}
	
	
	
	
	
	
	




}
