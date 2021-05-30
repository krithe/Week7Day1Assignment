package pages;

import hooks.TestNgHooks;
import io.cucumber.java.en.And;

public class HomePage extends TestNgHooks{
    
	@And("Click CRMSFA")
	public MyHomePage clickCrmSfa() {
    	
    	click(locateElement("link", "CRM/SFA"));
    	
    	return new MyHomePage();
    }
}
     


