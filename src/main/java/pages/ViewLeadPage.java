package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class ViewLeadPage extends WebDriverServiceImpl {

	public ViewLeadPage()
	{
		/*this.driver=driver;
		this.test=test;*/
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Edit")
	WebElement eleEdit;

	@FindBy(linkText="Find Leads")
	WebElement eleFindLeads;
	
	public EditableLeadPage clickEdit() {
		click(eleEdit);
		return new EditableLeadPage();
	}
	public FindLeadsPage clickFindLeads() {
		click(eleFindLeads);
		return new FindLeadsPage();
	}
	

}

