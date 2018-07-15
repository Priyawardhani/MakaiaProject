package tests;



import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;


public class MergeLead extends PreAndPost {

	//@Test(enabled=false)
	@Test(groups = {"Sanity"})
		public void mergeLead() throws InterruptedException {
		
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
		
		WebElement elemerge = locateElement("link","Merge Leads");
		click(elemerge);
		
		WebElement fromlead = locateElement("xpath", "(//img[@alt='Lookup'])[1]");
		click(fromlead);
		
		Thread.sleep(2000);
				
		switchToWindow(1);
		
		WebElement fromleadid = locateElement("xpath", "(//a[@class='linktext'])[1]");
		click(fromleadid);
		
		Thread.sleep(2000);
		
		switchToWindow(0);   
		
		WebElement tolead = locateElement("xpath","(//img[@alt='Lookup'])[2]");
		click(tolead);
		
		Thread.sleep(2000);
		
		switchToWindow(1);
		
		WebElement toleadid = locateElement("xpath","(//a[@class='linktext'])[1]");
		click(toleadid);
		
		Thread.sleep(2000);
		
		switchToWindow(0);
		
		WebElement merge = locateElement("xpath","//a[text()='Merge']");
		click(merge);
		
		acceptAlert();
		
		
}
	
	
}