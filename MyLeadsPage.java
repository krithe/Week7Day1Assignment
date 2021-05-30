package pages;

import hooks.TestNgHooks;
import io.cucumber.java.en.And;

public class MyLeadsPage extends TestNgHooks{
	
	@And("Click Create Leads")
	
	public CreateLeadsPage clickCreateLeadMenu() {
		
		click(locateElement("link", "Create Lead"));
		
		return new CreateLeadsPage();
	}
}
