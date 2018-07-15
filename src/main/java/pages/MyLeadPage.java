package pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import lib.selenium.WebDriverServiceImpl;

public class MyLeadPage extends WebDriverServiceImpl {

	public MyLeadPage()
	{
		/*this.driver=driver;
		this.test=test;*/
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Create Lead")
	WebElement eleCreateLead;
	
	@FindBy(linkText="Find Leads")
	WebElement eleFindLeads;
	
	@And("Click Create Lead")
	
	public CreateLeadPage clickCreateLeads() {
		click(eleCreateLead);
		return new CreateLeadPage();
	}
	public FindLeadsPage clickFindLeads() {
		click(eleFindLeads);
		return new FindLeadsPage();
	}
	
}

