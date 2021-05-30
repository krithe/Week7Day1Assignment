package pages;

import hooks.TestNgHooks;
import io.cucumber.java.en.And;

public class LoginPage extends TestNgHooks {
	

	@And("Enter the username {string}") 
	public LoginPage typeUSerName(String userdata) {
		type(locateElement("id", "username"), "DemoSalesManager");
		return this;
	}
	@And("Enter the password {string}")
	public LoginPage typePassword(String passdata) {
		type(locateElement("id", "password"), "crmsfa");
		return this;
	}
	
	@And("Click Login button")	
	public HomePage clickLogin() {
		click(locateElement("class", "decorativeSubmit"));
		return new HomePage();
	}
	

	
}
