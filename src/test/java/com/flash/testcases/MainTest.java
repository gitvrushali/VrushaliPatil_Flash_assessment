package com.flash.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.flash.actiondriver.Action;
import com.flash.base.BaseClass;
import com.flash.pageobject.DesktopsPage;
import com.flash.pageobject.HomePage;
import com.flash.pageobject.LogOutPage;
import com.flash.pageobject.LoginPage;
import com.flash.pageobject.RegestrationPage;

public class MainTest extends BaseClass {
	
	HomePage homepage;
	 
	RegestrationPage  regestrationPage;
	LogOutPage logOutPage ;
	 LoginPage  loginPage;
	 DesktopsPage desktopsPage;
	
	
	//@BeforeClass
	@Test
	public void setUp() throws InterruptedException {
		launchApp();
	}
	
	@AfterClass
	public void tearDowb() {
		driver.quit();
	}

		
		@Test
		public void endtoend() throws InterruptedException
		{
			homepage =new HomePage(); 
			regestrationPage =new RegestrationPage();
			logOutPage =new LogOutPage();
			loginPage = new LoginPage();
			desktopsPage  =new DesktopsPage();
			homepage.clickOnRegisterBtn();
			regestrationPage.enterFirstName("Arav");
			regestrationPage.enterLastName("Sharma");
			regestrationPage.dateOfBirth();
			regestrationPage.enterEmail("arav123@gmail.com");
			regestrationPage.enterCompanyName("IBM Pvt.Ltd");
			regestrationPage.clickOnNewsSetter();
			regestrationPage.enterPassword("Arav@1101$$");
			regestrationPage.confirmPassword("Arav@1101$$");
			regestrationPage.registerUser();
			String Expected=logOutPage.varifyRegistrationMsg();
			String Actual ="Your registration completed";
			Assert.assertEquals(Expected, Actual);
			logOutPage.clickOnLogoutBtn();
			homepage.clickOnLoginBtn();
			String ActualTiltle=driver.getTitle();
			String ExpectedTitle ="Login";
			loginPage.login("arav123@gmail.com", "Arav@1101$$");
			String ActTiltle1=driver.getTitle();
			String ExpTitle ="nopCommerce demo store";
			desktopsPage.testSortAddToCartAndValidateTotalPrice();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}

		
		
		
		
		
		
	
	
		
	
	
	
	

}

