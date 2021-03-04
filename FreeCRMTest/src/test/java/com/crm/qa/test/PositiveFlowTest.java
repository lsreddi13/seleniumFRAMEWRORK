package com.crm.qa.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class PositiveFlowTest extends TestBase{
	//declare the page classes.
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	Logger log = LogManager.getLogger(PositiveFlowTest.class);
	PositiveFlowTest(){
		super();
	}
	
	@BeforeClass
	public void setUp() {
		// call initialization method.
		initialization();
//		loginPage = new LoginPage();
		
	}
	@Test
	public void testFlow() {
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactPage = new ContactPage();
		
//		loginPage.testLogin("qabuddies06@gmail.com", "Pvnsoft123!");
		
//		loginPage.testLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		String userEmail = prop.getProperty("username");
		String userPwd = prop.getProperty("password");	
		log.info("user login");
		loginPage.testLogin(userEmail, userPwd);
		log.info("user loggedin successfully");
		//verify home page title
//		String actual = homePage.verifyHomeTitle();
		log.info("home page title verify");
//		String expected = ""
//		Assert.assertEquals(actual, "fdsafasd");
		
		Assert.assertEquals(homePage.verifyHomeTitle(), "Cogmento CRM");
		
		//click contacts
		homePage.clickContactLink();

		//verify contacts page title
//		contactPage.verifyContactPageTitle();
		Assert.assertEquals(contactPage.verifyContactPageTitle(), "Cogmento CRM");
		log.info("contact page title verified");
		
		//click new to create new cotnact
		
		//enter values in new contact form
		
		
		//click save button
		
		// verify contact is added or not
		
		//click home
		
		//verify home page title
		
		
		//logout
		
		//verify login page..
		
	}
	

}
