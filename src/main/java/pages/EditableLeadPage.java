package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class EditableLeadPage extends WebDriverServiceImpl {

	public EditableLeadPage()
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="updateLeadForm_companyName")
	WebElement eleCompName;


	@FindBy(className="smallSubmit")
	WebElement eleUpdateButton;

		public EditableLeadPage editCompName(String newCompName)
	{
		type(eleCompName, newCompName);
		return this;
	}

	public ViewLeadPage clickUpdateButton()
	{
		click(eleUpdateButton);
		return new ViewLeadPage();
	}



}
