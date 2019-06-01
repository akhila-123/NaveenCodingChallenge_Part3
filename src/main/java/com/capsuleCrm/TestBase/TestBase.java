package com.capsuleCrm.TestBase;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.capsuleCrm.TestUtil.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Implements initial set up as well as hides Selenium implementation details.
 * 
 * @author Akhila.Bandiki
 *
 */

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;

	/* Constructor to initialize properties file */
	public TestBase() {
		FileInputStream FIS;
		try {
			FIS = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/capsuleCrm/Config/Config.properties");
			prop = new Properties();
			prop.load(FIS);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sets up the environment to start the test by starting the browser,
	 * configuring it, navigating to the appropriate page and setting up the initial
	 * page object.
	 * 
	 * @param browser, chrome or firefox
	 * @param url, initial url to test
	 */
	public void InitialSetUp() {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		String Browser = prop.getProperty("Browser");
		if (Browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} else if (Browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Long_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("Url"));
	}

}
