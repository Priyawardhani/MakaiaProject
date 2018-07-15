package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FixMyBugs {

	@Test
	public void fixbug() throws InterruptedException {

		// launch the browser
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");

		// Mouse Over on Men
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElementByLinkText("Men")).perform();

		// Click on Jackets
		driver.findElementByXPath("//a[@href='/men-jackets']").click();


		// Find the count of Jackets
		String leftCount = 
				driver.findElementByXPath("//input[@value='Jackets']/following-sibling::span")
				.getText()
				.replaceAll("//D", "").replace("(", "").replace(")", "");
		System.out.println(leftCount);


		// Click on Jackets and confirm the count is same
		driver.findElementByXPath("//label[text()='Jackets']").click();

		// Wait for some time
		Thread.sleep(5000);

		// Check the count
		String rightCount = 
				driver.findElementByXPath("//input[@value='Jackets']/following-sibling::span")
				.getText()
				.replaceAll("//D", "").replace("-", "").replace(" ", "").replaceAll("[a-zA-Z]", "");
		System.out.println(rightCount);

		// If both count matches, say success
		if(leftCount.equals(rightCount)) {
			System.out.println("The count matches on either case");
		}else {
			System.out.println("The count does not match");
		}

		// Click on Offers
		driver.findElementByXPath("//h4[text()='Offers']").click();

		// Find the costliest Jacket
		List<WebElement> productsPrice = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
		List<String> onlyPrice = new ArrayList<String>();

		for (WebElement productPrice : productsPrice) {
			onlyPrice.add(productPrice.getText().replaceAll("//D", "").replaceAll("()", ""));
		}

		// Sort them 
		String max = Collections.max(onlyPrice);

		// Find the top one
		System.out.println(max);
		
		//driver.close();

		// Print Only Allen Solly Brand Minimum Price
		driver.findElementByXPath("//input[@value='Allen Solly']/following-sibling::div").click();
		Thread.sleep(3000);
		// Find the costliest Jacket
		List<WebElement> allenSollyPrices = driver.findElementsByXPath("//span[@class='product-discountedPrice']");

		List<String> onlyPrice1 = new ArrayList<String>();
		
		for (WebElement productPrice1 : allenSollyPrices) {
			
			onlyPrice1.add(productPrice1.getText().replaceAll("//D", "").replace("(", "").replace(")", ""));
		}

		// Get the minimum Price 
		String min = Collections.min(onlyPrice);

		// Find the lowest priced Allen Solly
		System.out.println(min);


	}

}