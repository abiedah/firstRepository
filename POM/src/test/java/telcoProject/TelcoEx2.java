package telcoProject;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import pageObjectsTelco.AddCustomer;
import pageObjectsTelco.AddTariffPlanToCustomer;
import pageObjectsTelco.CustomerId;
import pageObjectsTelco.LandingPageTelco;

public class TelcoEx2 {
	LandingPageTelco lp = new LandingPageTelco();
	AddTariffPlanToCustomer atpc = new AddTariffPlanToCustomer();
	AddCustomer ac = new AddCustomer();
	CustomerId id = new CustomerId();
	
	
	
	//TEST SETUP FOR EXERCISE 2
	@Test
	public void GIVEN_TestSetUp() {
		
		lp.clickAddTariffPlanToCustomer();
		
		String actual = atpc.checkHeadingGuru99Telecom();
		String expected = "Guru99 telecom";
		String actual2 = atpc.checkHeadingAddTariffToCustomer();
		String expected2 = "Add Tariff Plan to Customer";
		
		Assert.assertEquals(actual, expected);
		Assert.assertEquals(actual2, expected2);
	}
	
	//TEST CASE 1:
	@Test 
	public void GIVEN_Active_Customer_WHEN_Submit_THEN_Active_Is_Displayed() {
		
		//GIVEN
		lp.goHome();
		lp.clickAddCustomer();
		ac.clickDoneButton();
		ac.enterName("Abiedah");
		ac.enterLastname("Badat");
		ac.enterEmail("abc@abc.com");
		ac.enterAddress1("23 Huntersway");
		ac.enterMobile("2255114412");
		ac.clickSubmitButton();
		
//		id.getCustomerId();
		String CustID = id.getCustID();
		ac.clickHomeButton();
		
		lp.clickAddTariffPlanToCustomer();
		
//		atpc.enterCustomerIdNo("388062"); 
		atpc.enterCustomerId(CustID);   //done(active) no.
		
		
		//WHEN
		atpc.clickSubmitButton();
		//THEN
		String actual = atpc.checkActive();
		String expected = "ACTIVE";
		
		Assert.assertEquals(actual, expected);
	}
	
	//TEST CASE 2:
	@Test 
	public void GIVEN_Inactive_Customer_WHEN_Submit_THEN_Inactive_Is_Displayed() {
		
		lp.goHome();
		lp.clickAddCustomer();
		//GIVEN
		ac.clickPendingButton();
		ac.enterName("Pat");
		ac.enterLastname("Smith");
		ac.enterEmail("pat@abc.com");
		ac.enterAddress1("52 Highway");
		ac.enterMobile("2255114412");
		ac.clickSubmitButton();
		
		String CustID = id.getCustID();    
		ac.clickHomeButton();
		
		lp.clickAddTariffPlanToCustomer();
		
//		atpc.enterCustomerIdNo("193980");  
		//WHEN
		atpc.enterCustomerId(CustID);  //pending (inactive) no.
		
		atpc.clickSubmitButton();
		//THEN
		String actual = atpc.checkInactive();
		String expected = "INACTIVE";
		
		Assert.assertEquals(actual, expected);
		
	}
	
	//TEST CASE 3:
	@Test 
	public void GIVEN_Active_Customer_WHEN_Submit_THEN_At_Least_One_Approved_Tariff_Plan_Is_Displayed() {
		
		//GIVEN
		lp.clickAddCustomer();
		ac.clickDoneButton();
		ac.enterName("Abiedah");
		ac.enterLastname("Badat");
		ac.enterEmail("abc@abc.com");
		ac.enterAddress1("23 Huntersway");
		ac.enterMobile("2255114412");
		ac.clickSubmitButton();
		
		String CustID = id.getCustID();
		ac.clickHomeButton();
		
		lp.clickAddTariffPlanToCustomer();
		
//		atpc.enterCustomerIdNo("388062");   //active 
		atpc.enterCustomerId(CustID);
		
		//WHEN
		atpc.clickSubmitButton();
		
		//THEN
		String actual = atpc.checkApprovedTariffPlan();
		String expected = "Approved Tariff Plans";
		
		Assert.assertEquals(actual, expected);
		
	}
	
	//TEST CASE 4:
	@Test 
	public void GIVEN_At_Least_One_Approved_Tariff_Plan_Is_Selected_WHEN_Add_Tariff_THEN_Success_Message_Displayed() throws InterruptedException {
		
		lp.goHome();
		lp.clickAddCustomer();
		ac.clickDoneButton();
		ac.enterName("Abiedah");
		ac.enterLastname("Badat");
		ac.enterEmail("abc@abc.com");
		ac.enterAddress1("23 Huntersway");
		ac.enterMobile("2255114412");
		ac.clickSubmitButton();
		
		String CustID = id.getCustID();
		ac.clickHomeButton();
		
		lp.clickAddTariffPlanToCustomer();
		
		//GIVEN
//		atpc.enterCustomerIdNo("388062");
		atpc.enterCustomerId(CustID);
		
		atpc.clickSubmitButton();
		//WHEN
		atpc.clickTariffPlan();
		
		atpc.clickSubmitAddTariffPlan();
		//THEN
		String actual = atpc.checkSuccessMessage();
		String expected = "Congratulation Tariff Plan assigned";
		
		Assert.assertEquals(actual, expected);
			
	}
		
	
	@AfterSuite
	public void cleanup() {
		lp.cleanup();
		
	}
}
