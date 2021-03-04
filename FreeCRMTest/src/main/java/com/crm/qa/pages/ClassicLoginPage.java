package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

//call base class
public class ClassicLoginPage extends TestBase {
	// define object repository
	// page factory
	@FindBy(name = "username")
	WebElement userEmail;

	@FindBy(name = "password")
	WebElement userpassword;

	@FindBy(xpath = "//form[@id='loginForm']/input[@value='Login']")
	WebElement loginBtn;

	// create method.
	// how to initialize the apge factory
	// creating constructor
	public ClassicLoginPage() {
		// PageFacotry is a class
		// all the webelements are initialized this the driver.
		PageFactory.initElements(driver, this);
	}

	// Actions :
	// validate page title method
	public String validateClassicLoginPageTitle() {
		return driver.getTitle();
	}

	// login method
	// passing 2 string arguments as uName and pwd for username and password.
	// this method returns homepage.

	public HomePage login(String uName, String pwd) {

		userEmail.sendKeys(uName);
		userpassword.sendKeys(pwd);
		loginBtn.click();
		// home page is the landing page after login.
		// this return home page object
		return new HomePage();
	}

}
