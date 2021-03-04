package com.crm.qa.pages;

//import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {

	Logger log = LogManager.getLogger(HomePage.class);

	// create construcotr
	public DealsPage() {
		// call initElements method from PageFactory class to load all webelements.
		PageFactory.initElements(driver, this);
	}

	// Add all webelements

	@FindBy(xpath = "//button[contains(text(), 'New')]")
	WebElement newBtn;

	// verify page title method
	public String verifyDealsPageTitle() {
		return driver.getTitle();
	}
	
	// verify page title method
		public String verifyDealsPageUrl() {
			return driver.getCurrentUrl();
		}

	// Verify new button is displayed
	public boolean verifyNewBtn() {
		return newBtn.isDisplayed();
	}
	
	//click New button
		public void clickNewBtn() {
			newBtn.click();
		}
}
