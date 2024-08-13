package com.flash.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.flash.actiondriver.Action;
import com.flash.base.BaseClass;

public class RegestrationPage extends BaseClass {

	Action action = new Action();

	public RegestrationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "gender-male")
	WebElement gender;

	@FindBy(id = "FirstName")
	WebElement FirstName;

	@FindBy(id = "LastName")
	WebElement LastName;

	@FindBy(id = "Email")
	WebElement EmailId;
	
	@FindBy(id = "Company")
	WebElement companyName;
	
	
	@FindBy(id = "Newsletter")
	WebElement newsSetterBox;
	
	

	@FindBy(id = "Password")
	WebElement Password;
	
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPassword;
	
	

	@FindBy(xpath = "//button[@id='register-button'   and @type='submit']")
	WebElement registerBtn;
	
	////button[@id='register-button'   and @type='submit']
	
	

	public void selectgender() {
		action.click(driver, gender);

	}

	public void enterFirstName(String firstname) {
		action.type(FirstName, firstname);

	}

	public void enterLastName(String lastname) {
		action.type(FirstName, lastname);

	}
	public void clickOnNewsSetter()
	{
		action.click(driver, newsSetterBox);
	}

	public void dateOfBirth() throws InterruptedException {
		WebElement dayDropdown = driver.findElement(By.name("DateOfBirthDay"));
		Select daySelect = new Select(dayDropdown);
		daySelect.selectByVisibleText("29");

		WebElement monthDropdown = driver.findElement(By.name("DateOfBirthMonth"));
		Select monthSelect = new Select(monthDropdown);
		monthSelect.selectByVisibleText("April");

		WebElement yearDropdown = driver.findElement(By.name("DateOfBirthYear"));

		Select yearSelect = new Select(yearDropdown);
		yearSelect.selectByVisibleText("185");

	}
	
	public void enterCompanyName(String compname)
	{
		action.type(companyName, compname);
	}
	

	public void enterEmail(String email) {
		action.type(FirstName, email);

	}
	
	public void enterPassword(String password)
	{
		action.type(Password, password);
		
	}
	
	public void confirmPassword(String confpassword)
	{
		
		action.type(confirmPassword, confpassword);
	}
	
	public LogOutPage registerUser()
	{
		action.JSClick(driver, registerBtn);
		return new LogOutPage();
	}

}
