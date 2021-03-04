
package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//LoginPageTest extends the parent class as TestBase.
public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	static ExtentTest test;
	static ExtentReports report;

	// create constructor for LoginPageTest
	public LoginPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		// call initialization method.
		initialization();
		loginPage = new LoginPage();
		// it will generate report file with the given name here in the extent report
		// object.
		report = new ExtentReports(System.getProperty("user.dir") + "\\Reports\\" + this.getClass().getName()
				+ "_ExtentReportResults.html");
//		report = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\"+this.getClass().getSimpleName()+"_ExtentReportResults.html");Report

		test = report.startTest(this.getClass().getSimpleName());
		report.addSystemInfo("Host Name", "FreeCRM").addSystemInfo("Environment", "Automation Testing")
				.addSystemInfo("User Name", "sasi");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
		test.log(LogStatus.PASS, "Page title matched.");
	}

	@Test(priority = 2, enabled = true)
	public void validateLinks() throws InterruptedException {
		boolean flag = loginPage.validateClassicCRMLink();
		Assert.assertTrue(flag);

		boolean flag2 = loginPage.validateForgotPwdLink();
		Assert.assertTrue(flag2);

		boolean flag3 = loginPage.validateSignUpLink();
		Assert.assertTrue(flag3);
		test.log(LogStatus.PASS, "pass the test case");
		Thread.sleep(3000);
	}

	@Test(priority = 3, enabled = true)
	public void loginTestFailed() throws InterruptedException {
		String Error_Text = loginPage.loginInvalid(prop.getProperty("username2"), prop.getProperty("password2"),
				"invalid");
//		Assert.assertEquals(Error_Text, "Cogmento CRMs", "Error Text does not matched.");
		try {
			Assert.assertEquals(Error_Text, "Something went wrong...\n" + "Invalid login", "Error Text does not matched.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread.sleep(3000);
		test.log(LogStatus.PASS, "invalid creadentials test thrown error..");
	}

	@Test(priority = 4)
	public void loginTest() throws InterruptedException {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "user loggedin successfully with valid credentials");
	}
}
