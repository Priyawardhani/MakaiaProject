package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class MyHomePage extends WebDriverServiceImpl {

	public MyHomePage()
	{
		/*this.driver=driver;
		this.test=test;*/
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Leads")
	WebElement eleLeads;
	
	public MyLeadPage clickLeads() {
		click(eleLeads);
		return new MyLeadPage();
	}
	
}
