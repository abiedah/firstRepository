package telcoProject;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import pageObjectsTelco.AddCustomer;
import pageObjectsTelco.CustomerId;
import pageObjectsTelco.LandingPageTelco;

public class TelcoEx1 {
	LandingPageTelco lp = new LandingPageTelco();
	AddCustomer ac = new AddCustomer();
	CustomerId id = new CustomerId();
	
	//TEST SETUP FOR EXERCISE 1
	@Test
	public void GIVEN_TestSetup() {
		
		lp.hello();  //Test the url
		
		//TEST SETUP:
		//GIVEN
		//click Add Customer
		lp.clickAddCustomer();
		
		//WHEN
		//click done for background check
		ac.clickDoneButton();
		
		String actual = ac.checkHeadingGuru99Telecom();
		String expected = "Guru99 telecom";
		
		String actual2 = ac.checkHeadingAddCustomer();
		String expected2 = "Add Customer";
		
		//THEN
		Assert.assertEquals(actual, expected);
		Assert.assertEquals(actual2, expected2);
	}
	
	//TEST CASE 1:
	@Test
	public void GIVEN_InvalidDataEntered_THEN_WarningMessageDisplayed() {	
		
		//GIVEN
		lp.goHome();
		lp.clickAddCustomer();
		ac.clickDoneButton();
		ac.enterName("Abiedah");
		ac.enterLastname("Badat");
		ac.enterEmail("abc@abc.com");
		ac.enterAddress("23 Huntersway^!");
		ac.enterMobile("2255114412");
		
		//THEN
		String actualChar = ac.checkWarningMessage();
		String expectedChar = "Special characters are not allowed";
		Assert.assertEquals(actualChar, expectedChar);
		
	}
	
	//TEST CASE 2:
	@Test 
	public void GIVEN_InvalidDataEntered_THEN_Alert_WHEN_SubmitButtonIsPressed() {   
		
		lp.goHome();
		lp.clickAddCustomer();
		ac.clickDoneButton();
		ac.enterName("Abiedah");
		ac.enterLastname("Badat");
		ac.enterEmail("abc@abc.com");
		ac.enterAddress("23 Huntersway^!");
		ac.enterMobile("2255114412");
		ac.clickSubmitButton();
		
		String actualAlert = ac.checkAlertMessage();
		String expectedAlert = "please fill all fields";
		Assert.assertEquals(actualAlert, expectedAlert);
	
	}
	
	//TEST CASE 3:
	@Test 
	public void GIVEN_ValidDataEntered_THEN_IdDisplayed_WHEN_SubmitButtonIsPressed() {   
		
		lp.goHome();
		lp.clickAddCustomer();
		ac.clickDoneButton();
		ac.enterName("Abiedah");
		ac.enterLastname("Badat");
		ac.enterEmail("abc@abc.com");
		ac.enterAddress1("23 Huntersway");
		ac.enterMobile("2255114412");
		ac.clickSubmitButton();
		
//		id.getCustID();
		String CustID = id.getCustID();
		
		String actualId = id.checkCustomerIdText();
		String expectedId = "Customer ID";		
		Assert.assertEquals(actualId, expectedId);
		System.out.println("Customer ID no is: " + CustID);
	}
	
	@AfterSuite
	public void cleanup() {
		lp.cleanup();
	
	}
	
}
