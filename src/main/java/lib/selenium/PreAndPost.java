package lib.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import data.reader.ReadExcel;

public class PreAndPost extends WebDriverServiceImpl {

	public String testCaseName, testCaseDes, module, author, category,excelName;

	@Parameters({"url","uname","pwd"})
	@BeforeMethod()
	public void beforeMethod(String url, String usrname, String pwd) {

		//for reportss
		startTestModule(module);
		test.assignAuthor(author);
		test.assignCategory(category);

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		webdriver = new ChromeDriver();

		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);

		driver.manage().window().maximize();
		driver.get(url);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, usrname);

		WebElement elePassword = locateElement("id", "password");
		type(elePassword, pwd);

		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);

		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
	}

	@AfterMethod()
	public void afterMethod() {
		System.out.println("After Method executed successfully");
		closeActiveBrowser();
	}

	@BeforeClass()
	public void beforeClass() {

		startTestCase(testCaseName, testCaseDes);		
		System.out.println("Before Class executed successfully");
	}

	@AfterClass()
	public void afterClass() {
		System.out.println("After Class executed successfully");
	}

	@BeforeTest()
	public void beforeTest() {
		System.out.println("Before Test executed successfully");
	}

	@AfterTest()
	public void afterTest() {
		System.out.println("After Test executed successfully");
	}

	@BeforeSuite()
	public void beforeSuite() {
		startReport();
		System.out.println("Before Suite executed successfully");
	}

	@AfterSuite()
	public void afterSuite() {
		endResult();
		System.out.println("After Suite executed successfully");
	}


	@DataProvider(name="Test")
	public String[][] getData() throws IOException
	{

		ReadExcel read = new ReadExcel();
		String[][] data = read.readExcel(excelName);

		return data;
	}

}
