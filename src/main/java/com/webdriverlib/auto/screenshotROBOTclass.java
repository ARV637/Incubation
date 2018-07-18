package com.webdriverlib.auto;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;

public class screenshotROBOTclass {

	public static void screenshotbyRobot(WebDriver driver, String screenshortname) throws Exception {

		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "screenshotPNG",
				new File("D:\\Workspace\\Incubation\\src\\main\\resources\\RobotScreenshot.png"));
	}
}
