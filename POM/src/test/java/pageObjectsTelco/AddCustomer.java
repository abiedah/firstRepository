package pageObjectsTelco;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class AddCustomer extends BasePage {
	
	//EXERCISE 1 - TEST SETUP:
	public String checkHeadingGuru99Telecom() {
		return getElementText(By.xpath("//a[contains(text(),'Guru99 telecom')]"));
	}
	
	public String checkHeadingAddCustomer() {
		return getElementText(By.xpath("//h1[contains(text(),'Add Customer')]"));
		
	}
	
	public void clickDoneButton() {
		clickElement(By.xpath("//label[contains(text(),'Done')]"));
	}
	
	
	//EXERCISE 1 - TEST CASE 1:
	public void enterName(String firstName) {
		EnterText(By.xpath("//input[@id='fname']"), firstName);
	}
	
	public void enterLastname(String lastName) {
		EnterText(By.xpath("//input[@id='lname']"), lastName);
	}
	
	public void enterEmail(String email) {
		EnterText(By.xpath("//input[@id='email']"), email);
	}
	
	public void enterAddress(String address) {
		EnterText(By.xpath("//textarea[@placeholder='Enter your address']"), address);
	}
	
	public void enterMobile(String mobileNumber) {
		EnterText(By.xpath("//input[@id='telephoneno']"), mobileNumber);
		
	}
	
	public String checkWarningMessage() {
		return getElementText(By.xpath("//label[.='Special characters are not allowed']"));
		
	}

	//EXERCISE 1 - TEST CASE 2:
	public void clickSubmitButton() {
		clickElement(By.xpath("//input[@name='submit']"));
				
	}
	
	
	public String checkAlertMessage() {
		return driver.switchTo().alert().getText();

	}
	
	public void alertMessageAccept() {
		driver.switchTo().alert().accept();
	}
	
	//EXERCISE 1 - TEST CASE 3:
	public void enterAddress1(String address) {
		EnterText(By.xpath("//textarea[@placeholder='Enter your address']"), address);
		
	}
	
	
	//EXERCISE 2 - TEST CASE 2
	public void clickPendingButton() {
		clickElement(By.xpath("//label[contains(text(),'Pending')]"));
	}
	
	public void clickHomeButton() {
		clickElement(By.xpath("//a[contains(text(), 'Home')]"));
	}
	
	
}
