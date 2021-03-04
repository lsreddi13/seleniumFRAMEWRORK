package com.crm.qa.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateNewContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

//LoginPageTest extends the parent class as TestBase.
public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage conPage;
	CreateNewContactPage newcontact;
	Logger log = LogManager.getLogger(ContactsPageTest.class);

	// create constructor for LoginPageTest
	public ContactsPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		// call initialization method.
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		conPage = new ContactsPage();
		newcontact = new CreateNewContactPage();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	// write test cases for home page.
	// verify home page title.

	@Test()
	public void verifyCreateNewContact() throws InterruptedException {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title does not matched.");
		// click contacts button
		homePage.clickContactsLink();
		Thread.sleep(3000);
		log.info("Contacts link clicked in the home page");	
		// click new contact button
		conPage.clickNew();
		Thread.sleep(3000);
		log.info("new button clicked in the contacts page");
		// Verify contact new page url
		String contactNewPageurl = newcontact.verifyNewContactPageurl();		
		Assert.assertEquals(contactNewPageurl, "https://ui.freecrm.com/contacts/new", "Contact new page url  does not matched.");
		log.info("New contact page url matched");
		//Verify first name input box is displayed ot not.. if 
		if(newcontact.verifyFirstName() == false) {
			log.warn("New Contact page does not displayed.. need to refresh the page");
			driver.navigate().refresh();
			Thread.sleep(3000);
		}
		log.info("New Contact Page displayed");
		
		// enter all details for new contact form.
//		newcontact.VerifyCreateNewContact(prop.getProperty("fName"), prop.getProperty("lName"));

	}

}
