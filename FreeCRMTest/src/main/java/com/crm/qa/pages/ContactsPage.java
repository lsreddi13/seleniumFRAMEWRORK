package com.crm.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	Logger log = LogManager.getLogger(HomePage.class);
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(text(), 'Show Filters')]")
	WebElement showFilterBtn;

	@FindBy(xpath = "//button[contains(text(), 'Export')]")
	WebElement exportBtn;

	@FindBy(xpath = "//button[contains(text(), 'New')]")
	WebElement newBtn;

	public void verifyNewBtn() {
		newBtn.isDisplayed();
		log.info("new button displayed.");
	}

	public CreateNewContactPage clickNew() {
		newBtn.click();
		log.info("new button clicked. ");
		return new CreateNewContactPage();
	}
	
	
	
}
