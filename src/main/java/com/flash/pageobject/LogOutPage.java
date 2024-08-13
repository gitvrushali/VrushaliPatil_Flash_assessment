package com.flash.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flash.actiondriver.Action;
import com.flash.base.BaseClass;

public class LogOutPage  extends BaseClass{
	Action action = new Action();
	
	
	@FindBy(xpath = "//div[contains(text(),'Your registration completed')]")

	String registerMsg;
	
	
	@FindBy(css ="a.ico-logout")

	WebElement logOutBtn;
	

	@FindBy(xpath="//a[contains(text(),'Computers ')]")

	WebElement computertab;
	
	
	
	//a[contains(text(),'Computers ')]
	
	public LogOutPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public  String varifyRegistrationMsg()
	{
		return registerMsg;

		
		//return registerMsg;
	}
	
	public HomePage clickOnLogoutBtn()
	{
	   action.click(driver, logOutBtn);	
	   return new HomePage();
	}
	
	public void clickoncomputertab() {
		action.mouseOverElement(driver, computertab);
	}
	
	public DesktopsPage selectOptionComputerTab(String value)
	{
		
		List<WebElement> Compptions = driver.findElements(By.cssSelector("ul.sublist.first-level[1]"));
		
		
		
		System.out.println(Compptions);
		for (WebElement option : Compptions) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}
		
		return new DesktopsPage();
	}
	
	
	


}


//[contains(text(),'Your registration completed')]
