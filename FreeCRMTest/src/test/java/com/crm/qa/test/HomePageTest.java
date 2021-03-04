package com.crm.qa.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;

//LoginPageTest extends the parent class as TestBase.
public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	Logger log = LogManager.getLogger(HomePageTest.class);

	// create constructor for LoginPageTest
	public HomePageTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		// call initialization method.
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}

	@AfterClass
	public void tearDown() {
		log.info("close this browser");
		driver.quit();
	}

	// write test cases for home page.
	// verify home page title.
	@Test(priority = 1)
	public void verifyHomePageTitle() {
		log.info("going to login.");
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("user loggedin successfully");
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title does not matched.");
		
	}

	@Test(priority = 2)
	public void verifyUserNameLabelTest() {
		Assert.assertTrue(homePage.verifyLoggedinUserName());
		Assert.assertEquals(homePage.verifyLoggedinUserName(), true, "this is not matched.");
	}

}
