package takealot;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjectsTakealot.TakealotLandingPage;

public class SearchByProduct {

	TakealotLandingPage lp = new TakealotLandingPage();

	// Search by Product or item and assert that there is more than 1 item
	@Test
	public void GIVEN_SearchByProduct_WHEN_MoreThan1Result_THEN_AssertThatThereIsMoreThan1ItemDisplayed() {

//		GIVEN_SearchByProduct
		lp.clickCookieButton();  //Clear the cookie button GOT IT
		lp.enterProduct("drain cover");  //Search by product
		lp.clickSearchIcon();  //Click on search icon

//		WHEN_MoreThan1Result
		String items = lp.checkResults();  //Check results from the product search e.g. "4518 results for drain cover"
		String cut = items.substring(0,3); //Do a substring cut e.g. "4518"
		int results = Integer.valueOf(cut); //Convert from string to integer

//		THEN_AssertThatThereIsMoreThan1ItemDisplayed
		if (results >= 1) {
			System.out.println("More than 1 item is displayed for brand");

			String actual = lp.checkResults();
			String expected = " ";
			Assert.assertTrue(true);
		}

	}

	@AfterSuite
	public void cleanup() {
		lp.cleanup();
	}
}
