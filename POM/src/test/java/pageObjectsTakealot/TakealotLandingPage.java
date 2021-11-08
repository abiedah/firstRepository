package pageObjectsTakealot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import frameWorkClasses.BasePage;

public class TakealotLandingPage extends BasePage {

	// Click on the Cookie Notification "Got it"
	public void clickCookieButton() {
		clickElement(By.cssSelector(".button.cookies-banner-module_dismiss-button_24Z98"));

	}

	// Click on the Daily Deals button
	public void clickDailyDeals() {
		clickElement(By.cssSelector("[alt='Daily Deals Flyout x2.png']"));
	}

	// Select a brand or Search by brand (e.g. Ace - no longer available)
	public void clickBrand() {
		clickElement(By.cssSelector("[for='filter_Bestway_Bestway']")); //2 items
//		clickElement(By.cssSelector("[for='filter_4M_4M']"));  //1 item
//		clickElement(By.cssSelector("[for='filter_Aerolatte_Aerolatte']")); //2 items
	}
	
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
	
	// Click on the search button
	public void clickSearchIcon() {
		clickElement(By.cssSelector(".button.search-btn.search-icon"));
	}
	
	// Assert that there are more than 1 items displayed
//	public String checkItems() {
//		String items = driver.findElement(By.xpath("//div[contains(text(),'2 deals')]")).getText();
//			return items;
	
	public String checkResults() {
		return getElementText(By.cssSelector(".search-count.search-count-module_search-count_1oyVQ.toolbar-module_search-count_P0ViI"));
		
	}
		
	

	// Select a brand for less than 1 item
//	public void clickBrand1() {
//		clickElement(By.cssSelector("[for='filter_Aerolatte_Aerolatte']"));
//
//	}
	
	//Less than 1 item displayed
	public String checkItems1() {
		String items = driver.findElement(By.xpath("//div[contains(text(), '1 deal')]")).getText();
		return items;
		
	}
	
	//Click the first item 
	public void clickFirstItem() {
		clickElement(By.xpath("//div[@id='72303514']"));
		
	}
	
	//Click add item to cart
	public void clickAddToCart() {   //code not working!!
		clickElement(By.cssSelector(".buybox-actions"));
		
	}
	
	//Assert "Added to Cart" appears at the top of the popup window
	public String checkAddedToCart() {
		return getElementText(By.xpath("span[@class='shiitake-children']"));
	}
	
	//Click the "Go to Cart" button
	public void clickGoToCart() {
		clickElement(By.xpath("button[@class='button checkout-now dark']"));
	}
	
	//Check the price
	public String checkPrice() {
		return getElementText(By.xpath("//span[.='R 2,999']"));
	}
	
	//Select quantity 2
	public void selectQuantity() {
//		selectQuantity(By.xpath("//select[@id='cart-item_undefined']/option[@value='2']"), selectQuantity.SelectByValue("2"));
		Select sDrpDown = new Select (getElement(By.xpath("//select[@id='cart-item_undefined']/option[@value='2']")));
		sDrpDown.selectByVisibleText("2");
	}
	
	//Assert that the cart value is displayed correctly
	public String checkCartValue() {
		String cartValue = driver.findElement(By.xpath("//span[.='R 5,998']")).getText();
		return cartValue;
	}
	
	
	
}
