package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class TestCase1 extends WebDriverServiceImpl{

	@Test
	public void createAcc() throws InterruptedException {

		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");

		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");

		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		

		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
		
		WebElement eleacc = locateElement("link", "Accounts");
		click(eleacc);
		
		WebElement elecreateacc = locateElement("link", "Create Account");
		click(elecreateacc);
		
		WebElement accountName = locateElement("id", "accountName");
		type(accountName, "SaiPriyan");
		
		WebElement industry = locateElement("name", "industryEnumId");
		selectDropDownUsingVisibleText(industry, "Aerospace");
		

		WebElement currency = locateElement("id", "currencyUomId");
		selectDropDownUsingVisibleText(currency, "INR - Indian Rupee");
		
		
		WebElement source = locateElement("id", "dataSourceId");
		selectDropDownUsingVisibleText(source, "Direct Mail");
		
		WebElement marketing = locateElement("id", "marketingCampaignId");
		selectDropDownUsingVisibleText(marketing, "Demo Marketing Campaign");
		
		WebElement phoneno = locateElement("id", "primaryPhoneNumber");
		type(phoneno, "9789865895");
		

		WebElement city = locateElement("id", "generalCity");
		type(city, "Chennai");
		
		WebElement email = locateElement("id", "primaryEmail");
		type(email, "wardhaniraj@gmail.com");

		WebElement country = locateElement("id", "generalCountryGeoId");
		selectDropDownUsingVisibleText(country, "India");
		
		WebElement state = locateElement("id", "generalStateProvinceGeoId");
		selectDropDownUsingVisibleText(state, "TAMILNADU");
		
		WebElement button = locateElement("class", "smallSubmit");
		click(button);
		
		Thread.sleep(2000);
		
		WebElement accid = locateElement("xpath", "//span[text()='Account Name']/following::span");
		String value = getText(accid);
		System.out.println(value);
		//int length = value.length();
				
		//value.substring(beginIndex, endIndex)
		String id = value.replaceAll("[a-zA-Z() ]", "");
		String name = value.replaceAll("[0-9() ]", "");
		
		WebElement find = locateElement("link", "Find Accounts");
		click(find);
		
		WebElement accname = locateElement("xpath", "(//input[@name='accountName'])[2]");
		type(accname,name);
		
		
		WebElement accid1 = locateElement("name", "id");
		type(accid1,id);
		
		
		WebElement findaccounts = locateElement("xpath", "//button[text()='Find Accounts']");
		click(findaccounts);
		
		
		WebElement idcapture = locateElement("xpath", "//table[@class='x-grid3-row-table']//a");
		
		String value1=idcapture.getText();
		System.out.println(value1);
				
		verifyPartialText(idcapture, id);
			
		closeActiveBrowser();
					
		
	}

}
