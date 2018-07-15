package tests;

import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class PasswordVerification extends WebDriverServiceImpl {

	@Test
		public void password() throws InterruptedException {
				
		String Password = passwordVerification("Priya1234664jhad");
		System.out.println(Password);
		
		
		
	}
}
