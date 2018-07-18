package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.cleartrip.pages.BookingFlights;
import com.webdriverlib.auto.BrowserFactory;
import com.webdriverlib.auto.Constants;

public class CommonDef {

	WebDriver driver = BrowserFactory.getbrowser();
	
	BookingFlights pageBookflights = new BookingFlights(driver);

	public void navigateToClearTrip() {
		driver.get(Constants.URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void close() {
		driver.close();
		driver.quit();
	}

}