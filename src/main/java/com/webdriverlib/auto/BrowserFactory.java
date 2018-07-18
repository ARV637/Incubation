package com.webdriverlib.auto;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * 
 * @author Ashish_Vishnoi
 *
 */
public class BrowserFactory {
	public static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static WebDriver getbrowser() {
		if (Constants.BROWSER.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVERPATH);
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", Constants.TESTDOWNLOADFOLDER);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("--test-type");
			options.addArguments("start-maximized", "disable-popup-blocking");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-notifications");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(cap);
		}

		else if (Constants.BROWSER.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", Constants.IEDRIVERPATH);
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}

		else if (Constants.BROWSER.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}

		else if (Constants.BROWSER.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", Constants.OPERADRIVERPATH);
			driver.manage().window().maximize();
		} else {

			driver = new FirefoxDriver();
		}
		return driver;

	}
}
