package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class FindLeadsPage extends WebDriverServiceImpl {

	public FindLeadsPage()
	{
		/*this.driver=driver;
		this.test=test;*/
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='id']")
	WebElement eleID;
	
	
	@FindBy(xpath="(//input[@name='firstName'])[3]")
	WebElement elefName;
	
	
	@FindBy(xpath="//button[text()='Find Leads']")
	WebElement eleFindLeadsButton;
	

	@FindBy(xpath="(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")
	WebElement eleResult;
	
	@FindBy(xpath="(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")
	WebElement eleResultID;
	
	public FindLeadsPage clickFindLeads() {
		click(eleFindLeadsButton);
		return this;
	}
	
	public FindLeadsPage typeID(String id) {
		type(eleID, id);
		return this;
	}
	
	public FindLeadsPage typeFName(String fName) {
		type(elefName, fName);
		return this;
	}
	
	public ViewLeadPage clickFirstResult() {
		click(eleResult);
		return new ViewLeadPage();
	}
	
	public String getResultID() {
		String resultId = eleResultID.getText();
		return resultId;
	}
	
	
	
	
	
}
