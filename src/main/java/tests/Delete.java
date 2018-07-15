package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;

	public class Delete extends PreAndPost {

		//@Test(dependsOnMethods= {"tests.CreateLead.createLead"}, alwaysRun=true)
		@Test(dataProvider="Test")
		public void deleteLead(String fname) throws InterruptedException {
		
			WebElement eleleads = locateElement("link","Leads");
			click(eleleads);
			
			WebElement eleFindLeads = locateElement("link", "Find Leads");
			click(eleFindLeads);
			
			WebElement firstname = locateElement("xpath", "(//input[@name='firstName'])[3]");
			type(firstname,fname);
			
			WebElement findleads = locateElement("xpath", "//button[text()='Find Leads']");
			click(findleads);
			
			Thread.sleep(3000);
			
			WebElement leadid1 = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");				
			String deletedleadid = leadid1.getText();
			System.out.println(deletedleadid);
			
			WebElement findleadsid = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
			click(findleadsid);
			
			WebElement deletelead = locateElement("xpath", "//a[@class='subMenuButtonDangerous']");
			click(deletelead);
			
			WebElement findleads1 = locateElement("xpath","//a[text()='Find Leads']");
			click(findleads1);
			
			WebElement id = locateElement("xpath","//input[@name='id']");
			type(id, deletedleadid);
			
			WebElement findleads2 = locateElement("xpath","//button[text()='Find Leads']");
			click(findleads2);
			
			Thread.sleep(2000);
			
			WebElement error = locateElement("xpath","//div[@class='x-toolbar x-small-editor']/div");
			String errormessage = error.getText();
			System.out.println(errormessage);
			if(errormessage.equals("No records to display"))
			{
				System.out.println("Expected error message is displayed");
			}
			else
			{
				System.out.println("Expected error message is incorrect");
			}
		}
		@DataProvider(name ="Test")
		public String [][] getData()
		{
			String [][] data=new String[1][1];
			data[0][0]="a";
			
			data[1][0]="b";
			
			return data;
		}

}
