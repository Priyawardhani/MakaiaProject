package steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateLead {
	ChromeDriver driver;


	@Given("open the browser")
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@And("launch the Url")
	public void url()
	{
		driver.get("http://leaftaps.com/opentaps");
	}
	
	@And("set the timeouts")
	public void settimeouts()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@And("Maximize the Browser")
	public void maximize()
	{
		driver.manage().window().maximize();
	}
		
	@And("Enter the Username as (.*) , Password as (.*) and Login")
	public void username(String uname,String password)
	{
		
		driver.findElementById("username").sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();		
	}
	
	
	@And("Click CRFMSA")
	public void submitButton()
	{
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
	}
	
	//@And("Click Create Lead")
	public void createLead()
	{
		
		driver.findElement(By.linkText("Create Lead")).click();
		
	}
	
	//@And("Enter the companyname as (.*) and Forename as (.*) and surname as (.*)")
	public void inputs(String CompanyName,String Forename,String Surname)
	{
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(CompanyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(Forename);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(Surname);
	}
	
	
	//@When("Click CreateLeadButton")
	public void clickCreateLeadButton()
	{
		
		driver.findElement(By.className("smallSubmit")).click();
		
	}
	
	@Then("Lead is success")
	public void leadSuccess()
	{
		
		System.out.println("Lead is created");
		
	}
	
	@But("Lead is Failed")
	public void leadFailed()
	{
		
		System.out.println("Lead is not created");
		
	}

}
