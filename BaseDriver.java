package wrappers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver implements Browser, Element, Select, TargetLocator {

	public static RemoteWebDriver driver;

	@Override
	public boolean startApp(String browser, String url) {

		try {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if(browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();

			} else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			} else {
				System.err.println("This browser "+browser+" is not supported");
				return false;
			}

			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("The browser "+browser+" launched successfully");
			return true;

		} catch (Exception e) {
			System.err.println("The browser "+browser+" could not be launched");
			return false;
		}

	}

	@Override
	public void switchToWindow(int index) {
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> allwindows = new ArrayList<>(windowHandles);
			String windowHandle = allwindows.get(index);
			driver.switchTo().window(windowHandle);
			System.out.println("The window of index "+index+" switched");
		} catch (Exception e) {
			System.err.println("The window of index "+index+" could not be switched");
		}
	}
	

	@Override
	public void switchToFrame(WebElement ele) {
	
		try {
		   driver.switchTo().frame(ele);
			System.out.println("The curent window is switched to Frame");
		} catch (Exception e) {
			System.err.println("The curent window is not switched to Frame");
		}
         
	}

	@Override
	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			System.out.println("The Alert is accepted");
		} catch (Exception e) {
			System.out.println("The Alert is not accepted");
	}

	}

	@Override
	public void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			  alert.dismiss();
			   System.out.println("The alert is dismissed");
		} catch (Exception e) {
			System.err.println("The alert is not dismissed");
		}
		

	}

	@Override
	public String getAlertText() {
		
			Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());
			return null;
		} 
			

	@Override
	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		
		try {
			selectDropDownUsingVisibleText(ele, value);
			System.out.println("The Dropdown is Selected with value");
		} catch (Exception e) {
			System.err.println("The Dropdown is not Selected with value");
		}

        
	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			selectDropDownUsingValue(ele, value);
			System.out.println("The Dropdown is Selected with value");
		} catch (Exception e) {
			System.err.println("The Dropdown is not Selected with value");
		}

	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			selectDropDownUsingIndex(ele, index);
			System.out.println("The Dropdown is Selected with index");
		} catch (Exception e) {
			System.err.println("The Dropdown is not Selected with index");
		}

	}

	@Override
	public void type(WebElement ele, String data) {
		
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The element "+ele+" is typed with the value "+ele);
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be typed with the value "+ele);
		}

	}

	@Override
	public void click(WebElement ele) {	
		try {
			ele.click();
			System.out.println("The element "+ele+" is clicked");
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be clicked");
		}

	}

	@Override
	public String getText(WebElement ele) {
		String text = ele.getText();
		System.out.println(text);
		
		
		return null;
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		if(ele.getText().equals(expectedText)) {
			System.out.println("The element is matched with text "+expectedText);
		} else {
			System.err.println("The element did not match with text "+expectedText);
		}

	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		if(ele.getText().contains(expectedText)) {
			System.out.println("The element contains with text "+expectedText);
		} else {
			System.err.println("The element did not contains the text "+expectedText);
		}
	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		

	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator.toLowerCase()) {
			case "id": return driver.findElement(By.id(locValue));
			case "name": return driver.findElement(By.name(locValue));
			case "link": return driver.findElement(By.linkText(locValue));
			case "class": return driver.findElement(By.className(locValue));
			case "tag": return driver.findElement(By.tagName(locValue));
			case "xpath": return driver.findElement(By.xpath(locValue));
			case "css": return driver.findElement(By.cssSelector(locValue));
			case "partial": return driver.findElement(By.partialLinkText(locValue));
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element could not be found for the locator "+locator+" with value "+locValue);
		}
		return null;

	}

	@Override
	public boolean verifyExactTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyPartialTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void closeActiveBrowser() {
		driver.close();

	}

	@Override
	public void closeAllBrowsers() {
		driver.quit();

	}





}
