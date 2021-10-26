package pageObjectsDSTV;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class SignIn extends BasePage {
	
	public void enterPassword(String moviePassword) {
		EnterText(By.cssSelector("input#Password"), moviePassword);
	}
	
	public void clickSignInButton() {
		clickElement(By.cssSelector("button#btnSubmit"));
	}
	
	public String checkUserNameError() {
		return getElementText(By.xpath("//span[@id='EmailOrMobileNumber-error']"));
	}
}
