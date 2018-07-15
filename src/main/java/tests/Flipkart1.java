package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class Flipkart1 extends WebDriverServiceImpl{

	@Test
	public void flipkarttv() throws InterruptedException {
 
		typeKeysEsc();
		WebElement tv = locateElement("xpath", "//span[text()='TVs & Appliances']");
		movetoElement(tv);  
		WebElement samsung = locateElement("xpath", "(//span[text()='Samsung'])[2]");
		movetoElementclick(samsung);
		WebElement min = locateElement("xpath", "(//select[@class='fPjUPw'])[1]");
		selectDropDownUsingValue(min, "25000");
		WebElement max = locateElement("xpath", "(//select[@class='fPjUPw'])[2]");
		selectDropDownUsingValue(max, "60000");
		WebElement screensize = locateElement("xpath", "//div[text()='Screen Size']");
		click(screensize);
		WebElement option = locateElement("xpath", "//div[text()='48 - 55']/preceding-sibling::div");
		click(option);
		WebElement result = locateElement("xpath", "//div[@class='col col-7-12']/div");
		click(result);
		WebElement pricea = locateElement("xpath", "//div[@class='_1uv9Cb']/div");
		String price1 = getText(pricea);
		System.out.println(price1);
		switchToWindow(1);
		WebElement priceb = locateElement("xpath", "(//div[@class='_1uv9Cb']/div)[1]");
		String price2 = getText(priceb);
		System.out.println(price2);
		if(price1.equals(price2))
		{
			closeActiveBrowser();
		}
		else
		{
			System.out.println("Price is not same");
		}
		switchToWindow(0);
		
		WebElement addtocompare1 = locateElement("xpath", "(//span[text()='Add to Compare'])[1]");
		click(addtocompare1);
		WebElement addtocompare2 = locateElement("xpath", "(//span[text()='Add to Compare'])[2]");
		click(addtocompare2);
		WebElement compare = locateElement("xpath", "//span[text()='COMPARE']");
		click(compare);
		WebElement title = locateElement("xpath", "//span[text()='Compare']");
		verifyPartialText(title, "Compare");
		WebElement amount1 = locateElement("xpath", "(//div[@class='col col-4-12 _1ouGhW']/div)[1]");
		amount1.getText();
		WebElement amount1 = locateElement("xpath", "(//div[@class='col col-4-12 _1ouGhW']/div)[1]");
		
		
		

	}

		

}
	