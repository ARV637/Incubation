package serenityStepLib;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import stepDefinations.HomeStepDfn;

@RunWith(SerenityRunner.class)
public class SearchFlight {

	@Steps
	HomeStepDfn homeSteps;

	@Test
	public void membersShouldStartWithBronzeStatus() {
		// GIVEN
		homeSteps.user_entering_details();

		// WHEN
		homeSteps.user_click_on_SearchFlight_Button();

		// THEN
		homeSteps.user_should_see_list_of_flights();
		
		//homeSteps.user_closing_browser();
	}
}
