
package com.crm.qa.test;

import org.testng.Assert;
import org.testng.SkipException;
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
public class LoginPageTest2 extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	static ExtentTest test;
	static ExtentReports report;
	// create constructor for LoginPageTest
	public LoginPageTest2() {
		super();
	}

	@BeforeClass
	public void setUp() {
		// call initialization method.
		initialization();
		loginPage = new LoginPage();
		report = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\"+this.getClass().getName()+"_Results.html");
//		report = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\"+this.getClass().getSimpleName()+"_ExtentReportResults.html");
		test = report.startTest(this.getClass().getSimpleName());
		report
        .addSystemInfo("Host Name", "SoftwareTesting")
        .addSystemInfo("Environment", "Automation")
        .addSystemInfo("User Name", "sasi");
		
		
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		report.endTest(test);
		report.flush();
//		report.close();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		
		String title = loginPage.validateLoginPageTitle();
//		test = report.startTest("passTest");
//		Assert.assertEquals(title, "Cogmento CRM");
		if(title.equals("Cogmento CRM")) {
			test.log(LogStatus.PASS, "Test Case Passed is passTest");
		}else {
			test.log(LogStatus.FAIL, "Page title not matched.");
		}
		
		
		
	}

	@Test(priority = 2, enabled = true)
	public void validateLinks() {
//		test = report.startTest("PassTest");
		boolean flag = loginPage.validateClassicCRMLink();
		Assert.assertTrue(flag);
		if(loginPage.validateClassicCRMLink()) {
			test.log(LogStatus.PASS, "Test Case Passed is passTest");
		}else {
			test.log(LogStatus.FAIL, "Page title not matched.");
		}

		boolean flag2 = loginPage.validateForgotPwdLink();
		Assert.assertTrue(flag2);

		boolean flag3 = loginPage.validateSignUpLink();
		Assert.assertTrue(flag3);
		test.log(LogStatus.INFO, "ddddd");
	}

	@Test(priority = 3)
	public void loginTestFailed() {
//		test = report.startTest("failTest");
		String Error_Text = loginPage.loginInvalid(prop.getProperty("username2"), prop.getProperty("password2"),
				"invalid");
//		Assert.assertEquals(Error_Text, "Cogmento CRMs", "Error Text does not matched.");
		Assert.assertEquals(Error_Text, "Something went wrong...\n" + "Invalid login",
				"Error Text does not matched.");
		test.log(LogStatus.FAIL, "Status is passed");
		driver.navigate().refresh();
		
	}

	@Test(priority = 4)
	public void loginTest() {
//		test = report.startTest("PassTest");
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		test.log(LogStatus.PASS, "Status is passed");
	}
	@Test(priority = 5, enabled = false)
	public void skipTest(){
		test = report.startTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}
}
