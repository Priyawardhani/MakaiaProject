package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;

public class EditLead extends PreAndPost {

	//@Test(dependsOnMethods= {"tests.CreateLead.createLead"}, description="Edit Lead in Leaftaps")
	@Test(dataProvider="Test")
	public void editLead(String fname,String compname) throws InterruptedException {


		WebElement eleleads = locateElement("link","Leads");
		click(eleleads);

		WebElement eleFindLeads = locateElement("link", "Find Leads");
		click(eleFindLeads);

		WebElement firstname = locateElement("xpath", "(//input[@name='firstName'])[3]");
		type(firstname,fname);

		WebElement findleads = locateElement("xpath", "//button[text()='Find Leads']");
		click(findleads);

		Thread.sleep(3000);

		WebElement findleadsid = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		click(findleadsid);

		WebElement edit = locateElement("link", "Edit");
		click(edit);

		WebElement clear = locateElement("id", "updateLeadForm_companyName");
		clear(clear);

		Thread.sleep(2000);

		WebElement update = locateElement("id", "updateLeadForm_companyName");
		type(update,compname);

		WebElement update1 = locateElement("xpath", "(//input[@class='smallSubmit'])[1]");
		click(update1);


	}
	private void clear(WebElement clear) {
		// TODO Auto-generated method stub
		
	}
	@DataProvider(name ="Test")

	public String [][] getData()
	{
		String [][] data=new String[2][2];
		data[0][0]="a";
		data[0][1]="TCS";
		data[1][0]="b";
		data[1][1]="Infosys";
		return data;

	}

}

