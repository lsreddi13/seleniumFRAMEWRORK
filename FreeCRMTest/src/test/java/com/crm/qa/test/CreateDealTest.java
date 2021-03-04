package com.crm.qa.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class CreateDealTest extends TestBase {
	// declare the page classes.
	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;
	Logger log = LogManager.getLogger(CreateDealTest.class);

	CreateDealTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		// call initialization method.
		initialization();
//		loginPage = new LoginPage();

	}

	@Test
	public void createNewDeal() {
		loginPage = new LoginPage();
		homePage = new HomePage();
		dealsPage = new DealsPage();

//		loginPage.testLogin("qabuddies06@gmail.com", "Pvnsoft123!");

//		loginPage.testLogin(prop.getProperty("username"), prop.getProperty("password"));

		String userEmail = prop.getProperty("username");
		String userPwd = prop.getProperty("password");
		log.info("user login");
		loginPage.testLogin(userEmail, userPwd);
		log.info("user loggedin successfully");
		// verify home page title
//		String actual = homePage.verifyHomeTitle();
		log.info("Verify home page title");

		Assert.assertEquals(homePage.verifyHomeTitle(), "Cogmento CRM");

		// click Deals
		homePage.clickDealsLink();
		log.info("Clicked Deals.");
		// verify deals page title
		Assert.assertEquals(dealsPage.verifyDealsPageTitle(), "Cogmento CRM", "Deals page home title does not match.");
		log.info("deals page title matched.");
		// verify contacts page title
		Assert.assertEquals(dealsPage.verifyDealsPageUrl(), "https://ui.freecrm.com/deals",
				"Deals page url does not match.");
		log.info("Deal page url is matched.");

		// Verify new button is displayed in deals page.
		Assert.assertTrue(dealsPage.verifyNewBtn(), "new button not displauyed.");
		log.info("New button displayed in deals page.");

		// click new to create new deal
			dealsPage.clickNewBtn();
			log.info("New button clicked.");
			
		
		// enter values in new deal form

		// click save button

		// verify contact is added or not

		// click home

		// verify home page title

		// logout

		// verify login page..

	}

}
