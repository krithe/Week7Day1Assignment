package hooks;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ReadExcelForDataProvider;
import wrappers.BaseDriver;

public class TestNgHooks extends BaseDriver {
	
	
	@BeforeMethod
	public void invoke() {
		// start the application
		startApp("chrome","http://leaftaps.com/opentaps");
	}
	
	@AfterMethod
	public void close() {
		// close browser
		closeActiveBrowser();
	}
	
	@DataProvider(name="FetchExcelData")
	public Object[][] readExcelData() throws InvalidFormatException, IOException {
		return ReadExcelForDataProvider.readExcelData("CreateLead");
	}
}

	