package com.webdriverlib.auto;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author Ashish_Vishnoi
 *
 */
public class WebDriverCommonUtil {
	WebDriver driver;
	Actions actions;
	Select select;
	JavascriptExecutor executor;

	public WebDriverCommonUtil(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * perform mousehover to the given webelment
	 * 
	 * @param we
	 * @param driver
	 */
	public void moveMouseHover(WebElement we, WebDriver driver) {
		actions = new Actions(driver);
		actions.moveToElement(we).perform();
	}

	/**
	 * accepts an alert pop up
	 */
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	/**
	 * rejects an alert pop up
	 */
	public void rejectAlert() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * get the text from alert pop up
	 */
	public void fetchTextFromAlert() {
		driver.switchTo().alert().getText();
	}

	/**
	 * send the text to an alert pop up
	 */
	public void sendTextToAlert(String alrtvalue) {
		driver.switchTo().alert().sendKeys(alrtvalue);
	}

	/**
	 * select an option from dropdown using text
	 * 
	 * @param we
	 * @param textval
	 */
	public void selectUsingVisibleText(WebElement we, String text) {
		select = new Select(we);
		select.selectByVisibleText(text);
	}

	/**
	 * select an option from dropdown using value
	 * 
	 * @param we
	 * @param value
	 */
	public void selectUsingValue(WebElement we, String value) {
		select = new Select(we);
		select.selectByValue(value);
	}

	/**
	 * select an option from dropdown using index
	 * 
	 * @param we
	 * @param index
	 */
	public void selectUsingIndex(WebElement we, int index) {
		select = new Select(we);
		select.selectByIndex(index);
	}
	
	/**
	 * clicking on element using javascript
	 * @param element
	 * @param driver
	 */
	public void jsClick(WebElement element, WebDriver driver) {
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}

}
