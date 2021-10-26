package testDstv;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import pageObjectsDSTV.LandingPage;
import pageObjectsDSTV.SignIn;

public class MovieMagic {
	//Instantiate the page objects
	LandingPage lp = new LandingPage(); 
	SignIn sn = new SignIn();
	
	@Test
	public void GIVEN_NavigationToSigninPage_WHEN_OnlyPasswordEntered_AND_SigninButtonClicked_THEN_Error() {  //BDD
		//lp.hiworld(); calling the 'hi' from hiworld from LandingPage
		
		//GIVEN
			//Go Home
			//Click Sign In
		lp.clickSignIn();
			//Enter Password ("kkjks")
		sn.enterPassword("garbage");
		
		//WHEN
			//Click Sign In Button
		sn.clickSignInButton();
		
		String actual = sn.checkUserNameError();
		String expected = "Email or Mobile number is required";
		
		//THEN
		Assert.assertEquals(actual, expected);
		
	}
	
	@AfterSuite		//will be called once all test cases have been run
	public void cleanup() {
		lp.cleanup();
		
	}
}
