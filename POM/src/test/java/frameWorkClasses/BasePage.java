package frameWorkClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	//Declare the WebDriver (NO.1)
	public static WebDriver driver;
	
	//Constructor (same as the class) of the base class (NO.3)
	public BasePage() {
		if (driver == null) {
			//Get Parameter values
			String browser = getDataConfigProperties("browser");
			String systemUnderTest = getDataConfigProperties("systemUnderTest");
			String pdriverDir = getDataConfigProperties("driverDir");
			//String pdriverDirFireFox = getDataConfigProperties("driverdirFirefox");
			//String pdriverDirEdge = getDataConfigProperties("driverdirEdge");
			
			//Check if parameter passed as "Chrome"
			if (browser.equalsIgnoreCase("chrome")) {
				//Set path to chromedriver.exe
				System.setProperty("webdriver.chrome.driver", pdriverDir + "chromedriver.exe");
				//Create an instance of chrome
				driver = new ChromeDriver ();
				driver.get(systemUnderTest);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			//Check if parameter passed as "firefox"
			else if (browser.equalsIgnoreCase("firefox")) {
				//Set path to geckodriver.exe
				System.setProperty("webdriver.gecko.driver", pdriverDir + "geckodriver.exe");
				//Create an instance of firefox
				driver = new FirefoxDriver ();
				driver.get(systemUnderTest);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
			//Check if parameter passed as "Edge"
			else if (browser.equalsIgnoreCase("Edge")) {
				//Set path to MicrosoftWebdriver.exe
				System.setProperty("webdriver.edge.driver", pdriverDir + "MicrosoftWebDriver.exe");
				//Create an instance of edge
				driver = new EdgeDriver ();
				driver.get(systemUnderTest);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		}
	}
	
	
	//Create a method to read the config (NO.2)
	public String getDataConfigProperties(String propertyName) {
		//Properties set
		Properties p = new Properties ();
		InputStream is = null;
		try {
			is = new FileInputStream("config.properties");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			p.load(is);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(propertyName);
	}
	
	//Create a method to wait for Element
	public void waitForElement(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pLocator));
	}
	
	//Create a method to wait for the Url
	public void waitForUrl(int elementWait, String pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.urlContains(pLocator));
	}
	
	//Create a method to wait for the Click
	public void waitForClick(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.elementToBeClickable(pLocator));
	}
	
	//Create a method to get Element Text
	public String getElementText(By pLocator) {
		waitForElement(10, pLocator);
		String h1 = getElement(pLocator).getText();
		return h1;
	}
	
	//Create a method to click Element (2)
			public void clickElement(By pLocator) {
				waitForClick(10,pLocator);
				getElement(pLocator).click();
			}
	
	//Create a method to get Element (1)
	public WebElement getElement(By pLocator) {
		waitForClick(10,pLocator);
		return driver.findElement(pLocator);
	}
	
	
	//Clean up (close the browser)
	public void cleanup() {
//		driver.close();
		driver.quit();
	}
	
	//Create a method to enter Text
	public void EnterText(By pLocator, String pText) {
		waitForClick(10, pLocator);
		driver.findElement(pLocator).sendKeys(pText);
	}
	
	//Create a method to select the drop down
	public void selectDropDown(By pLocator, String pValue) {
		//Create an instance of the drop down object
		Select sDrpDown = new Select (getElement(pLocator));
		//Populates the Drop down
		sDrpDown.selectByVisibleText(pValue);
	}
	
	public void clearBrowserCache() {
		driver.manage().getCookies();
		driver.manage().deleteAllCookies();
		
	}
	
	
	


	
	
}
