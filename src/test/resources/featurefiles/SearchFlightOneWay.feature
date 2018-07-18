Feature: Customer flight search

@regression 
Scenario: One way flight search
	Given user entering details 
	When user click on search flight
	Then user should see list of flights

