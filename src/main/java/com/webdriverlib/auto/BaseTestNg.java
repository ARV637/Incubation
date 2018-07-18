package com.webdriverlib.auto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestNg 
{
	public static WebDriver driver;
	
	@BeforeMethod
	public void preConfig()
	{
		ExcelUtil eu = new ExcelUtil();
		String browserType = eu.getData("Config", 1 , 0 );
		String buildUrl = eu.getData("Config", 1, 1);
		if (browserType.equals("FF"))
		{
			driver = new FirefoxDriver();
		}
			
		driver.get(buildUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void postConfig()
	{
		driver.close();
	}
}
