package pageObjectsTakealot;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameWorkClasses.BasePage;

public class TakealotLandingPage extends BasePage {

	// Click on the Cookie Notification "Got it"
	public void clickCookieButton() {
		clickElement(By.cssSelector(".button.cookies-banner-module_dismiss-button_24Z98"));
		
	}
	
	// Click on the Daily Deals button
	public void clickDailyDeals() {
		clickElement(By.xpath("//a[contains(@href, 'https://www.takealot.com/deals?sort=Relevance')]"));
//		clickElement(By.cssSelector("[alt='Daily Deals Flyout x2\\.png']"));
	}

	// Select a brand or Search by brand from Daily Deals (e.g. Bestway - no longer available)
//	public void clickBrand() {
//		clickElement(By.cssSelector("[for='filter_Bestway_Bestway']")); //2 items
//		clickElement(By.cssSelector("[for='filter_4M_4M']"));  //1 item
//		clickElement(By.cssSelector("[for='filter_Aerolatte_Aerolatte']")); //2 items
//	}
	
		
	public void enterBrand(String SearchbyBrand) {
		EnterText(By.cssSelector("input#_undefined"), SearchbyBrand);
	}
	

	// String message if no results found
	public String checkmessage() {
		return getElementText(By.cssSelector(".filter-search-module_no-results_3zVd7"));
	}

	// Clear the filter icon
	public void clickClear() {
		clickElement(By.cssSelector(".filter-clear-icon.filter-search-module_clear-icon_3Plm_"));
	}
	
	// Search for product or brand in the general search - not Daily Deals
	public void enterProduct(String SearchforProduct) {
		EnterText(By.cssSelector("input[name='search']"), SearchforProduct);
	}
	
	// Click on the search button icon
	public void clickSearchIcon() {
		clickElement(By.cssSelector(".button.search-btn.search-icon"));
	}
	
	// Assert that there are more than 1 items/results displayed
	public String checkResults() {
		return getElementText(By.cssSelector(".search-count.search-count-module_search-count_1oyVQ.toolbar-module_search-count_P0ViI"));
		
	}	
	
//	public String checkItems() {
//		String items = driver.findElement(By.xpath("//div[contains(text(),'2 deals')]")).getText();
//			return items;
	
	

	// Select a brand for less than 1 item
//	public void clickBrand1() {
//		clickElement(By.cssSelector("[for='filter_Aerolatte_Aerolatte']"));
//
//	}
	
	//Less than 1 item displayed
//	public String checkItems1() {
//		String items = driver.findElement(By.xpath("//div[contains(text(), '1 deal')]")).getText();
//		return items;
		
//	}
	
	
	//Click the first item 
	public void clickFirstItem() {
		clickElement(By.xpath("//div[@id='72303514']"));
		
	}
	
	//Click add item to cart
	public void clickAddToCart() {   
		Set<String> allHandles = driver.getWindowHandles();   // Get All the window handles
		 System.out.println("Count of windows:"+allHandles.size()); // Count the number of handles
		 
		 String currentWindowHandle = allHandles.iterator().next(); // Get the current handle or default handle
		 System.out.println("currentWindow Handle"+currentWindowHandle); 
		 
		 allHandles.remove(allHandles.iterator().next()); // Remove the first/default handle
		 String lastHandle = allHandles.iterator().next(); // Get the last window handle
		 System.out.println("last window handle"+lastHandle); // 
		 driver.switchTo().window(lastHandle); // Switch to second or last window, two windows (1 parent window) other window (2 child window)
		
		clickElement(By.cssSelector(".button:nth-child(2)"));
			 
	}
	
	//Assert "Added to Cart" appears at the top of the pop-up window
	public String checkAddedToCart() {
		return getElementText(By.cssSelector("span > span > .shiitake-children"));  
	}
	
	
	//Click the "Go to Cart" button
	public void clickGoToCart() {
		Set<String> allHandles = driver.getWindowHandles();
		 System.out.println("Count of windows:"+allHandles.size());
		 
		 String currentWindowHandle = allHandles.iterator().next();
		 System.out.println("currentWindow Handle"+currentWindowHandle);
		 
		 allHandles.remove(allHandles.iterator().next());
		 String lastHandle = allHandles.iterator().next();
		 System.out.println("last window handle"+lastHandle);
		 
		 driver.switchTo().window(lastHandle);
		
		clickElement(By.cssSelector(".cell > .button")); 
		}
		
	
	
	//Check the price
	public String checkPrice() {
		return getElementText(By.xpath("//span[contains(text(),'R 90')]"));  
	}
	
	//Select quantity 2
	public void selectQuantity() {
		selectDropDown(By.cssSelector("div.input select:nth-child(1)"), ("2"));
		Select sDrpDown = new Select (getElement(By.cssSelector("div.input select:nth-child(1)")));
		sDrpDown.selectByVisibleText("2");  
	}
	
	
	//Assert that the cart value is displayed correctly  
	public String checkCartValue() {
		return getElementText(By.xpath("//span[.='R 180']"));
		
//		String cartValue = driver.findElement(By.xpath("//span[.='R 200']")).getText(); 
//		return cartValue;
	}
	
	
	
}
