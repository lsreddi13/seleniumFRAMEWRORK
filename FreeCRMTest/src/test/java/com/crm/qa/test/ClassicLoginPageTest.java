
package com.crm.qa.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ClassicLoginPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

//LoginPageTest extends the parent class as TestBase.
public class ClassicLoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ClassicLoginPage cloginpage;

	// create constructor for LoginPageTest
	public ClassicLoginPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		// call initialization method.
		initialization();
		loginPage = new LoginPage();
		cloginpage = new ClassicLoginPage();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		loginPage.clickClassicLogin();
		cloginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	
}
