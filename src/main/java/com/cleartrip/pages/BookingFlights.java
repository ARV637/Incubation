package com.cleartrip.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webdriverlib.auto.WebDriverCommonUtil;
import net.serenitybdd.core.pages.PageObject;

public class BookingFlights extends PageObject {
	WebDriver driver;
	WebDriverCommonUtil common;

	public BookingFlights(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		common = new WebDriverCommonUtil(driver);
	}

	@FindBy(id = "OneWay")
	private WebElement chkOneWay;

	@FindBy(id = "RoundTrip")
	private WebElement chkRoundTrip;

	@FindBy(id = "MultiCity")
	private WebElement chkMultiCity;

	@FindBy(id = "FromTag")
	private WebElement txtFrom;

	private String ddlAutoSearch = "//li[@class='list']/a[contains(text(), 'CITY')]";

	@FindBy(id = "ToTag")
	private WebElement txtTo;

	@FindBy(id = "DepartDate")
	private WebElement dpkrDepartOn;
	
	@FindBy(css = "#ui-datepicker-div")
	private WebElement dpkrTable;

	private String dateToDepart = "//div[@class='monthBlock first']//table//td/a[text()='DATE']";
	
	@FindBy(id = "Adults")
	private WebElement ddlAdults;

	@FindBy(id = "Childrens")
	private WebElement ddlChildrens;

	@FindBy(id = "Infants")
	private WebElement ddlInfants;

	@FindBy(id = "SearchBtn")
	private WebElement btnSearchFlight;

	/**
	 * select a trip like One way/Round trip/Multi-city
	 * 
	 * @param tripType
	 */
	public void selectTrip(String tripType) {
		switch (tripType) {
		case "One way":
			common.jsClick(chkOneWay, driver);
			break;

		case "Round trip":
			chkOneWay.click();
			break;

		case "Multi-city":
			chkOneWay.click();
			break;

		default:
			System.err.println("Plese choose a proper trip type like One way/Round trip/Multi-city and try again");
			break;
		}
	}

	/**
	 * Enter pessanger details using hashmap required below details from, to,
	 * departOn, adults, children, infants
	 * 
	 * @param pessangerDetails
	 */
	public void enterPessangerDetails(HashMap<String, String> pessangerDetails) {
		if (!pessangerDetails.containsKey("from") || !pessangerDetails.containsKey("to")
				|| !pessangerDetails.containsKey("departOn") || !pessangerDetails.containsKey("adults")) {
			System.out.println("Enter requred pessanger data");
			return;
		} else {
			String from = pessangerDetails.get("from").substring(0, 1).toUpperCase()+pessangerDetails.get("from").substring(1);
			String to = pessangerDetails.get("to").substring(0, 1).toUpperCase()+pessangerDetails.get("to").substring(1);
			txtFrom.sendKeys(pessangerDetails.get("from"));
			driver.findElement(By.xpath(ddlAutoSearch.replace("CITY", from))).click();
			txtTo.sendKeys(pessangerDetails.get("to"));
			driver.findElement(By.xpath(ddlAutoSearch.replace("CITY", to))).click();
			driver.findElement(By.xpath(dateToDepart.replace("DATE", pessangerDetails.get("departOn")))).click();;
			common.selectUsingVisibleText(ddlAdults, pessangerDetails.get("adults"));
			common.selectUsingVisibleText(ddlChildrens, pessangerDetails.get("children"));
			common.selectUsingVisibleText(ddlInfants, pessangerDetails.get("infants"));
		}
	}
	
	public void clickSearchFlight() {
		btnSearchFlight.click();
	}

}