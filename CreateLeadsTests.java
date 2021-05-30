package leadstests;

import org.testng.annotations.Test;


import hooks.TestNgHooks;
import pages.LoginPage;



public class CreateLeadsTests extends TestNgHooks {
	
	@Test(dataProvider = "FetchExcelData")
	
	public void CreateLeadsTests(String Username, String Password,String companyName, String firstName,String lastName) {
	
		new LoginPage()
		.typeUSerName("DemoSalesManager")
		.typePassword("crmsfa")
		.clickLogin()
		.clickCrmSfa()
		.clickLeadsTab()
		.clickCreateLeadMenu()
		.clickCreateLeadSubmit()
		.verifyLeadIsCreated();
		
		
		

}
}