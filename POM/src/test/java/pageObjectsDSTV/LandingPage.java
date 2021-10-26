package pageObjectsDSTV;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class LandingPage extends BasePage { //extends - in order to access the basepage methods
	
	public void hiworld() {
		System.out.println("Hi");
	}
	
	public void clickSignIn() {
		clickElement(By.cssSelector("img[alt='Sign in']"));
	}

}
