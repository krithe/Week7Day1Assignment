package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import wrappers.BaseDriver;

public class CreateLeadsPage extends BaseDriver {
	
	@And("Enter Company Name as (.*)$")
	public CreateLeadsPage TypeCompanyName(String companyName) {
    	
    	//driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
    	
    	type(locateElement("id", "createLeadForm_companyName"), "companyName");
    	return this;
    }
    
	 @And("Enter First Name as (.*)$")
    public CreateLeadsPage TypeFirstName(String firstName) {
    	    	  	
    //driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
    	
    	type(locateElement("id", "createLeadFor m_firstName"), "firstName");
    	
    	return this;
    }
     
	 @And("Enter Last Name as (.*)$")
       public CreateLeadsPage TypeLastName(String lastname) {
    	   
    	//driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
    	   
    	type(locateElement("id", "createLeadForm_lastName"), "lastname");
    	
    	return this;
    	
    }
	 @And("Click Submit")
	 public ViewLeadsPage clickCreateLeadSubmit() {
        	
    	//driver.findElement(By.className("smallSubmit")).click();
        	
    	click(locateElement("class", "smallSubmit"));
    	
    	return new ViewLeadsPage();
    	
    }
     
}
 	