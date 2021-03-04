package com.crm.qa.pages;

//import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	Logger log = LogManager.getLogger(HomePage.class);
	@FindBy(xpath = "//div[@id='top-header-menu']//div[@class='ui buttons']/div/i")
	WebElement settingsIcon;

	@FindBy(xpath = "//div[@class='menu transition visible']/a[5]")
	WebElement Logout;

	@FindBy(xpath = "//div[@id='main-nav']//a[1]")
	WebElement Home;

	@FindBy(xpath = "//div[@id='main-nav']//a[2]")
	WebElement Calendar;

	@FindBy(xpath = "//div[@id='main-nav']//a[6]")
	WebElement Tasks;

	@FindBy(xpath = "//div[@id='main-nav']//a[3]")
	WebElement Contacts;

	@FindBy(xpath = "//div[@id='main-nav']//a[5]")
	WebElement Deals;

	@FindBy(xpath = "//div[@class='right menu']/span[1]")
	WebElement userNameLabel;

	// create construcotr
	public HomePage() {
		// call initElements method from PageFactory class to load all webelements.
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public String verifyHomeTitle() {
		log.info("get the pagetitle");
		String homeTitle = driver.getTitle();
		return homeTitle;
	}

	public ContactPage clickContactLink() {
		log.info("click Contacts");
		Contacts.click();
		return new ContactPage();
	}
	
	public ContactsPage clickContactsLink() throws InterruptedException {
		Contacts.click();
		Thread.sleep(3000);
		return new ContactsPage();
	}

	public DealsPage clickDealsLink() {
		Deals.click();
		return new DealsPage();
	}

	public TasksPage clickTasksLink() {
		Tasks.click();
		return new TasksPage();
	}

	public boolean verifyLoggedinUserName() {
		return userNameLabel.isDisplayed();
	}

}
