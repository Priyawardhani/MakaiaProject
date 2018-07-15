package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.EditableLeadPage;
import pages.FindLeadsPage;
import pages.MyHomePage;
import pages.MyLeadPage;
import pages.ViewLeadPage;

public class EditLead1 extends PreAndPost {
	
	@BeforeTest
	public void setValue()
	{
		testCaseName="EditLead";
		testCaseDes="Edit Lead";
		module="Lead";
		author="Priya";
		category="Sanity";
		//excelName="CreateLead (1) (1)";
		
	}
	@Test(dataProvider="Test1")	
	public void editlead(String compname,String fname,String id){		

		new MyHomePage()
		.clickLeads();
		new MyLeadPage()
		.clickFindLeads();
		new FindLeadsPage()
		.typeID(id)
		.typeFName(fname)
		.clickFirstResult();
		new ViewLeadPage() 
		.clickEdit();		
		new EditableLeadPage()
		.editCompName(compname)
		.clickUpdateButton();
	}

	@DataProvider(name ="Test1")

	public String [][] getData()
	{
		String [][] data=new String[1][3];
		data[0][0]="TCS";
		data[0][1]="Priya";
		data[0][2]="100";
		return data;

	}

}

