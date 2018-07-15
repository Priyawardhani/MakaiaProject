package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import lib.selenium.WebDriverServiceImpl;

public class CreateLeadPage extends WebDriverServiceImpl {

	public CreateLeadPage()
	{
		/*this.driver=driver;
		this.test=test;*/
		PageFactory.initElements(driver,this);
	}


	@FindBy(id="createLeadForm_companyName")
	WebElement eleCompName;

	@FindBy(id="createLeadForm_firstName")
	WebElement eleFirstName;

	@FindBy(id="createLeadForm_lastName")
	WebElement eleLastName;

	@FindBy(className="smallSubmit")
	WebElement eleCreateLeadsButton;

	@And("Enter the companyname as (.*)")	
	public CreateLeadPage typeCompName(String compName) {
		type(eleCompName,compName);
		return this;
	}

	@And("Forename as (.*)")
	public CreateLeadPage typeFirstName(String firstName) {
		type(eleFirstName,firstName);	
		return this;
	}

	@And("surname as (.*)")
	public CreateLeadPage typelastName(String lastName) {
		type(eleLastName,lastName);	
		return this;
	}

	@When("Click CreateLeadButton")
	public ViewLeadsPage clickCreate()
	{
		click(eleCreateLeadsButton);
		return new ViewLeadsPage();
	}

}

