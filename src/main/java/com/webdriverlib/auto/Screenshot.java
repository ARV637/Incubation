package com.webdriverlib.auto;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
/**
 * 
 * @author Ashish_Vishnoi
 *
 */
public class Screenshot {

	public static void capturescreenshot(WebDriver driver, String screenshortname) {

		try {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,
					new File("C:\\ECLIPSE WORKSPACE\\WaytoAutomat\\src\\test\\resources\\ScreenshortsFailed "
							+ screenshortname + ".png"));
			System.out.println("screenshort taken");

		}

		catch (Exception e) {
			System.out.println("exception while taking screenshort  " + e.getMessage());
		}

	}

}
