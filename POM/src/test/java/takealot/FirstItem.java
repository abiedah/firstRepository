package takealot;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import pageObjectsTakealot.TakealotLandingPage;

public class FirstItem {

	TakealotLandingPage lp = new TakealotLandingPage();

	// Click the first item, add it to the cart and assert that the "Added to Cart" appears at the top of the window
	
	@Test
	public void GIVEN_ClickFirstItem_WHEN_AddItemToCart_THEN_AssertThatAddToCartDisplaysOnTopOfPopUpWindow_WHEN_ClickGoToCart_AND_SelectQuantity_THEN_AssertThatTheCartValueIsDisplayedCorrectly() {

//		GIVEN_SelectTheFirstItem
		lp.clickCookieButton();  //Clear the cookie button GOT IT
		lp.enterProduct("drain cover"); //Search by product
		lp.clickSearchIcon(); //Click search icon
		lp.clickFirstItem(); //Select the first item

		String price = lp.checkPrice(); //Check the price of the item e.g. R 90

//		WHEN_AddItemToCart
		lp.clickAddToCart();  //Click add to cart

//		THEN_AssertAddToCartIsDisplayedOnTopOfPopUpWindow
		String actual = lp.checkAddedToCart();
		String expected = "Added to cart";
		Assert.assertEquals(actual, expected);

//		WHEN_ClickGoToCart
		lp.clickGoToCart();
		
//		AND_SelectQuantity
		lp.selectQuantity();  //Quantity is 2

//		THEN_AssertThatCartValueIsDisplayedCorrectly
		String actualValue = lp.checkCartValue();
		String expectedValue = "R 180";
		Assert.assertEquals(actualValue, expectedValue);

		System.out.println("Asserting that the cart value is displayed correctly " + actualValue);

		String cut = price.substring(2);  //Substring R 90
		int systemprice = Integer.valueOf(cut);  //Convert from string to integer

		if (systemprice * 2 == 180) {    //Systemprice of 90 
			System.out.println("The total cart value is " + actualValue);

		} else
			System.out.println("The total cart value is incorrect " + actualValue);
	}

	@AfterSuite
	public void cleanup() {
		lp.cleanup();
	}

}
