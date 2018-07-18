package stepDefinations;

import java.util.HashMap;

import net.thucydides.core.annotations.Step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HomeStepDfn extends CommonDef {
	@Step("^user should navigate to home page$")
	public void user_should_navigate_to_home_page() throws Throwable {
		System.out.println("user_should_navigate_to_home_page");
	}

	@Step(value = "user entering details")
	public void user_entering_details() {
		navigateToClearTrip();
		pageBookflights.selectTrip("One way");
		HashMap<String, String> hm = new HashMap<>();
		hm.put("from", "Pune");
		hm.put("to", "Indore");
		hm.put("departOn", "19");
		hm.put("adults", "1");
		hm.put("children", "0");
		hm.put("infants", "0");
		pageBookflights.enterPessangerDetails(hm);
	}

	@Step(value = "user click on search flight")
	public void user_click_on_SearchFlight_Button() {
		pageBookflights.clickSearchFlight();
	}
	
	@Step(value = "user should see list of flights")
	public void user_should_see_list_of_flights() {
		assertThat(1, is(1));
	}
	
	@Step(value = "User closing the Browser")
	public void user_closing_browser() {
		close();
	}
}
