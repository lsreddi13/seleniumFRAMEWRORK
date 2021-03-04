package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	static Logger log = LogManager.getLogger(TestBase.class);
	
	public static WebDriver driver;
	public static Properties prop;
	public static String proj_path = System.getProperty("user.dir");

	public TestBase() {
		// loading properties file
		try {
			prop = new Properties();

			FileInputStream fis = new FileInputStream(
					proj_path + "//src//main//java//com//crm//qa//config//config.properties");
			prop.load(fis);
			log.info("Config properties file loade from //src//main//java//com//crm//qa//config//");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	// create initialization method.
	public static void initialization() {

		String browserName = prop.getProperty("browser");

//		if(browserName.equals("chrome")) {
//			
//		}
		switch (browserName) {
		case "chrome":
			 WebDriverManager.chromedriver().setup();
			 
//			System.setProperty("webdriver.chrome.driver", proj_path + ".//BrowserDrivers//chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-notifications");
//			driver = new ChromeDriver(options);
			driver = new ChromeDriver();
			log.info("Chrome Browser initiated.");
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
//			System.setProperty("webdriver.gecko.driver", proj_path + "//BrowserDrivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "Safari":
			System.setProperty("webdriver.gecko.driver", proj_path + "//BrowserDrivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "IE":
			System.setProperty("webdriver.gecko.driver", proj_path + "//BrowserDrivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "Edge":
			System.setProperty("webdriver.gecko.driver", proj_path + "//BrowserDrivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:

			break;
		}
		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
