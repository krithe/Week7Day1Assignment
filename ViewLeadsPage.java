package pages;

import hooks.TestNgHooks;
import io.cucumber.java.en.Then;

public class ViewLeadsPage extends TestNgHooks {
	
	@Then("Verify if New lead is created") 

	public ViewLeadsPage verifyLeadIsCreated() {
		
		verifyPartialTitle("View Lead");
		
		return this;

	}

}
