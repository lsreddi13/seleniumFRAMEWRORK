package com.crm.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

//call base class
public class LoginPage extends TestBase {
	Logger log = LogManager.getLogger(LoginPage.class);
	// define object repository
	// page factory
	@FindBy(name = "email")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input/../../../div[contains(text(), 'Login')]")
	WebElement loginBtn;

	@FindBy(xpath = "//button[contains(text(), 'Sign Up')]")
	WebElement singUpBtn;

	@FindBy(linkText = "Forgot your password?")
	WebElement forgotPwdLink;

	@FindBy(linkText = "Classic CRM")
	WebElement ClassicCRMLink;

	@FindBy(linkText = "Sign Up")
	WebElement SignUpLink;

	@FindBy(xpath = "//div[@class='header']/..")
	WebElement errorText;

	// create method.
	// how to initialize the apge factory
	// creating constructor
	public LoginPage() {
		// PageFacotry is a class
		// all the webelements are initialized this the driver.
		log.info("initializing the elements");
		PageFactory.initElements(driver, this);
	}

	// Actions :
	// validate page title method
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	// validate the forgot password link displayed or not.
	public boolean validateForgotPwdLink() {
		return forgotPwdLink.isDisplayed();
	}

	// validate classic CRM link text displayed or not
	public boolean validateClassicCRMLink() {
		return ClassicCRMLink.isDisplayed();

	}

	// validate signup link text displayed or not
	public boolean validateSignUpLink() {
		return SignUpLink.isDisplayed();
	}

	// login method
	// passing 2 string arguments as uName and pwd for username and password.
	// this method returns homepage.
	public HomePage testLogin(String email, String pwd) {
		log.info("enter user name");
		userName.sendKeys(email);
		log.info("enter password");
		password.sendKeys(pwd);
		log.info("click login button");
		loginBtn.click();

		return new HomePage();

	}

	public HomePage login(String uName, String pwd) {
		userName.clear();
		userName.sendKeys(uName);
		password.clear();
		password.sendKeys(pwd);
		
		loginBtn.click();
		// home page is the landing page after login.
		// this return home page object
		return new HomePage();
	}

	public String loginInvalid(String uName, String pwd, String invalid) {
		userName.clear();
		userName.sendKeys(uName);
		password.clear();
		password.sendKeys(pwd);
		loginBtn.click();
		// home page is the landing page after login.
		// this return home page object
		String errorGuess = errorText.getText();
		return errorGuess;
	}

	public ClassicLoginPage clickClassicLogin() {
		validateClassicCRMLink();
		if (validateClassicCRMLink()) {
			ClassicCRMLink.click();
		}
		return new ClassicLoginPage();

	}
}
