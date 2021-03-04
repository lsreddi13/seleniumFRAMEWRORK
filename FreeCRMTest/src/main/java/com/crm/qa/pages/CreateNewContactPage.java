package com.crm.qa.pages;

//import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateNewContactPage extends TestBase {
	//to write logs created log object from Logger class.
	Logger log = LogManager.getLogger(CreateNewContactPage.class);
	
	// page factory elements are initialized.
	public CreateNewContactPage() {
		PageFactory.initElements(driver, this);
	}
	//Save button Webelement
	@FindBy(xpath = "//button[contains(text(), 'Save')]")
	WebElement saveBtn;
	
	//Cancel button Webelement
	@FindBy(xpath = "//button[contains(text(), 'Cancel')]")
	WebElement cancelBtn;
	
	//First name input box webelement
	@FindBy(name = "first_name")
	WebElement f_Name;
	
	//last name input box webelement
	@FindBy(name = "last_name")
	WebElement l_Name;
	
	//verify page contact new page is displayed?
	public String verifyNewContactPageTitle() {
		
		return driver.getTitle();
	}
	
	//verify page contact new page is url?
		public String verifyNewContactPageurl() {
			return driver.getCurrentUrl();
		}
	
	
		public boolean verifyFirstName() {
			return f_Name.isDisplayed();
		}
	//method to enter first name input value
	public void enterFName(String FName) {
		f_Name.clear();
		log.info("cleared first name field.");
		f_Name.sendKeys(FName);
		log.info(" first name entered. ");
		
	}
	
	//method to enter last name input value
	public void enterLName(String LName) {
		l_Name.clear();
		log.info("cleared send name field. ");
		l_Name.sendKeys(LName);
		log.info("entered send name. ");
	}
	
	////method to fill all the values in the create new contact page.
	public void VerifyCreateNewContact(String FName, String LName) {
		enterFName(FName);
		enterLName(LName);
	}
}
