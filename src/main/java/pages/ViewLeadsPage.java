package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class ViewLeadsPage extends WebDriverServiceImpl {

	public ViewLeadsPage()
	{
		/*this.driver=driver;
		this.test=test;*/
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="viewLead_firstName_sp")
	WebElement eleFname;
	
	public ViewLeadsPage verifyFirstName(String firstName) {
		verifyExactText(eleFname,firstName);
		return this;
	}
	
}

