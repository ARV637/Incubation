package com.webdriverlib.auto;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
/**
 * 
 * @author Ashish_Vishnoi
 *
 */
public class ITestlistner implements ITestListener {

	WebDriver driver;
	public void onFinish(ITestContext Result) {
	System.out.println("TestCase is finished and details are "+Result.getName());
		
	}

	public void onStart(ITestContext Result) {
		
		System.out.println("TestCase is starting and details are "+Result.getName());
		System.out.println("Browser is opening");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		
		
		System.out.println("TestCase is almost passes and details are "+Result.getName());

	}

	public void onTestFailure(ITestResult Result) {
		if(ITestResult.FAILURE==Result.getStatus())
		{
		Screenshot.capturescreenshot(driver, Result.getName());	
		System.out.println("TestCase failed and details are "+Result.getName());
		
		
		}
		
	}

	public void onTestSkipped(ITestResult Result) {
		if(ITestResult.SKIP==Result.getStatus())
		{
		Screenshot.capturescreenshot(driver, Result.getName());	
		System.out.println("TestCase failed and details are "+Result.getName());
		
		
		}
		System.out.println("TestCase is skiiped and details are "+Result.getName());

		
	}

	public void onTestStart(ITestResult Result) {
		System.out.println("TestCase is started and details are "+Result.getName());

		
	}

	public void onTestSuccess(ITestResult Result) {
		
		System.out.println("TestCase is success and details are "+Result.getName());

	}

}

