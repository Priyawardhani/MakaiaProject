package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class DuplicateLead extends WebDriverServiceImpl {

	@Test
	public void duplicateLead() throws InterruptedException {
	
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");

		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");

		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);

		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);

		WebElement eleleads = locateElement("link","Leads");
		click(eleleads);
		
		WebElement eleFindLeads = locateElement("link", "Find Leads");
		click(eleFindLeads);
		
		WebElement firstname = locateElement("xpath", "(//input[@name='firstName'])[3]");
		type(firstname,"Pr");
		
		WebElement findleads = locateElement("xpath", "//button[text()='Find Leads']");
		click(findleads);
		
		Thread.sleep(3000);
		
		WebElement findleadsid = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		click(findleadsid);
		
		WebElement fname = locateElement("id", "viewLead_firstName_sp");
		String Name = fname.getText();
		System.out.println(Name);	
		
		WebElement duplicate = locateElement("xpath","//a[text()='Duplicate Lead']");
		click(duplicate);
	    
		Thread.sleep(2000);
		
		WebElement createduplicate = locateElement("name","submitButton");
		click(createduplicate);
		
		WebElement forename = locateElement("id", "viewLead_firstName_sp");
		
		String fname1 = forename.getText();
		System.out.println(fname1);
		if(fname1.equals(Name))
		{
			System.out.println("Lead is duplicated");
		}
		else
		{
			System.out.println("Lead is not duplicated");
		}
	}
}
