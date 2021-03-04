package com.crm.qa.pages;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
//import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.Logger;
//import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {
//	Logger log = Logger.getLogger(ContactPage.class);
	Logger log = LogManager.getLogger(ContactPage.class);
	//page webElements

	// create construcotr
	public ContactPage() {
		// call initElements method from PageFactory class to load all webelements.
		PageFactory.initElements(driver, this);
		log.info("page factory initiated elemenets from the page class.");
	}

	public String verifyContactPageTitle() {
		log.info("get the contact page title");
		return driver.getTitle();
	}

	//page webelements action methods.
	
	

}
