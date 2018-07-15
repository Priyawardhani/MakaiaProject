package lib.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import lib.listeners.WebDriverListener;

public class WebDriverServiceImpl extends WebDriverListener implements WebDriverService{

	public WebElement locateElement(String locator, String locValue) {

		try {
			switch (locator) {
			case "id": return driver.findElement(By.id(locValue));

			case "class": return driver.findElement(By.className(locValue));

			case "link" : return driver.findElement(By.linkText(locValue));

			case "tag" : return driver.findElement(By.tagName(locValue));

			case "xpath" : return driver.findElement(By.xpath(locValue));

			case "name" : return driver.findElement(By.name(locValue));

			default:
				break;
			}
		} 
		catch (NoSuchElementException e) {
			System.err.println("The locator "+locator+" is not found");
			throw new RuntimeException("Element not found");
		}
		/*catch (NotFoundException e) {
			System.err.println("The locator "+locator+" is not found");
			throw new RuntimeException("Element not found");
		}
		catch (Exception e) {
			System.err.println("The locator "+locator+" is not found");
			throw new RuntimeException("Element not found");
		}*/
		return null;
	}

	public List<WebElement> locateElements(String locator, String locValue) {

		try {
			switch (locator) {
			case "id": return driver.findElements(By.id(locValue));

			case "class": return driver.findElements(By.className(locValue));

			case "link" : return driver.findElements(By.linkText(locValue));

			case "tag" : return driver.findElements(By.tagName(locValue));

			case "xpath" : return driver.findElements(By.xpath(locValue));

			case "name" : return driver.findElements(By.name(locValue));

			default:
				break;
			}
		}  
		catch (NoSuchElementException e) {
			System.err.println("The locator "+locator+" is not found");
			throw new RuntimeException("Element not found");
		}
		catch (RuntimeException e) {
			System.err.println("The locator "+locator+" is not found");
			throw new RuntimeException("Element not found");
		}
		return null;
	}

	public void type(WebElement ele, String data) {
		//code without integrating extent report
		/*try {
			ele.sendKeys(data);
		} 
		catch (InvalidElementStateException e) {
			System.err.println("The ele "+ele+" is not enabled for typing");
			throw new RuntimeException("The textbox is not enabled");

		}	
		catch (RuntimeException e) {
			System.err.println("The ele "+ele+" is not enabled for typing");
			throw new RuntimeException("The textbox is not enabled");

		}*/	
		
		//code with integrating extent report
		try {
			ele.sendKeys(data);
			reportSteps("The Data "+data+" is Entered Successfully", "pass");
		} catch (Exception e) {
			reportSteps("The Data "+data+" is not Entered Successfully", "fail");
		}		
	}

	public void click(WebElement ele) {
		try {
			ele.click();
		} 
		catch (RuntimeException e) {
			System.err.println("The ele "+ele+" is not available for clicking");
			throw new RuntimeException("The link/button is not available");

		}		
	}

	public String getText(WebElement ele) {

		String text = null;
		try {
			text = ele.getText();
		} 
		catch (RuntimeException e) {
			System.err.println("Text is not available for the element "+ele);

		}		
		return text;
	}

	public void selectDropDownUsingVisibleText(WebElement ele, String value) {

		try {
			Select dropValue = new Select(ele);
			dropValue.selectByVisibleText(value);
		} 
		catch (RuntimeException e) {
			System.err.println("The value "+value+ "is not available");
			throw new RuntimeException("The value is not available");

		}

	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			Select dropValue = new Select(ele);
			dropValue.selectByValue(value);
		} 
		catch (RuntimeException e) {
			System.err.println("The value "+value+ "is not available");
			throw new RuntimeException("The value is not available");

		}

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select dropValue = new Select(ele);
			dropValue.selectByIndex(index);
		} 
		catch (RuntimeException e) {
			System.err.println("The index "+index+ "is not available");
			throw new RuntimeException("The index is not available");

		}


	}

	public boolean verifyExactTitle(String expectedTitle) {
		String title = null;
		try {
			title = driver.getTitle();
		} catch (RuntimeException e) {

			System.err.println("The title is not available to get");	
		}
		if (title.equalsIgnoreCase(expectedTitle))
		{
			return true;
		}
		return false;
	}

	public boolean verifyPartialTitle(String expectedTitle) {
		String title = null;
		try {
			title = driver.getTitle();
		} catch (RuntimeException e) {

			System.err.println("The title is not available to get");	
		}
		if (title.contains(expectedTitle))
		{
			return true;
		}
		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			String text = ele.getText();
			System.out.println(text);
			if(expectedText.equals(text))
			{
				System.out.println("The text is verified and valid");
			}
			else
			{
			System.out.println("The text is verified and invalid");
			}
		} 
		catch (RuntimeException e) {
			System.err.println("The text is not available");
		}

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			String text = ele.getText();
			if(expectedText.contains(text))
			{
				System.out.println("The text is valid");
			}
			else
			{
			System.out.println("The text is invalid");
			}
		} 
		catch (RuntimeException e) {
			System.err.println("The text is not available");
		}

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			String attribute1 = ele.getAttribute(value);
			if(attribute1.equals(attribute))
			{
				System.out.println("The attribute is valid");
			}
			System.out.println("The attribute is invalid");
		} 
		catch (RuntimeException e) {
			System.err.println("The attribute is not available");
		}

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			String attribute1 = ele.getAttribute(value);
			if(attribute1.contains(attribute))
			{
				System.out.println("The attribute is valid");
			}
			System.out.println("The attribute is invalid");
		} 
		catch (RuntimeException e) {
			System.err.println("The attribute is not available");
		}

	}

	public void verifySelected(WebElement ele) {
		try {
			ele.isSelected();
		} 
		catch (RuntimeException e) {
			System.err.println("The element "+ele+" is not a checkbox/select/radio button");
		}

	}

	public void verifyDisplayed(WebElement ele) {
		try {
			ele.isDisplayed();
		} 
		catch (RuntimeException e) {
			System.err.println("The element "+ele+" is not ready for display");
		}

	}

	public void switchToWindow(int index) {


		try {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> windowList = new ArrayList<String>();
			windowList.addAll(windowHandles);
			driver.switchTo().window(windowList.get(index));
			driver.manage().window().maximize();
		}
		catch (NoSuchWindowException e) {
			System.err.println("The window with index "+index+" is not available");
		}
		catch (RuntimeException e) {
			System.err.println("The window with index "+index+" is not available");
		}

	}

	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
		} 
		catch (NoSuchFrameException e) {

			System.err.println("The frame is not available");
		}
		catch (RuntimeException e) {

			System.err.println("The frame is not available");
		}

	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} 
		catch (NoAlertPresentException e) {
			System.err.println("The Alert is not available");
		}
		catch (RuntimeException e) {
			System.err.println("The Alert is not available");
		}

	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} 
		catch (NoAlertPresentException e) {
			System.err.println("The Alert is not present");
		}
		catch (RuntimeException e) {
			System.err.println("The Alert is not present");
		}

	}

	public String getAlertText() {
		String text = null;
		try {
			text = driver.switchTo().alert().getText();
		} 
		catch (NoAlertPresentException e) {
			System.err.println("The Alert is not present");
		}
		catch (RuntimeException e) {
			System.err.println("The Alert is not present");
		}
		return text;
	}

	public void closeActiveBrowser() {
		try {
			driver.close();
		} catch (RuntimeException e) {
			System.err.println("The browser is not available for closing");
		}

	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
		} catch (RuntimeException e) {
			System.err.println("The browsers are not available for closing");
		}

	}

	@Override
	public void mouseOverClick(WebElement elemove, WebElement eleclick) {
		Actions builder = new Actions(driver);
		builder.moveToElement(elemove).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		builder.click(eleclick).perform();
		
	}
	
	public void escape()
	{
		driver.getKeyboard().sendKeys(Keys.ESCAPE);
	}

}
