package pages;

import hooks.TestNgHooks;
import io.cucumber.java.en.And;

public class MyHomePage extends TestNgHooks{

	@And("Click Leads")
	public MyLeadsPage clickLeadsTab() {
		
		click(locateElement("link", "Leads"));
		 return new MyLeadsPage();

	}

}
