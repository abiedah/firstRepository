package pageObjectsTelco;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;

import frameWorkClasses.BasePage;

public class AddTariffPlanToCustomer extends BasePage {

	//EXERCISE 2 - TEST SETUP:
	public String checkHeadingGuru99Telecom() {
		return getElementText(By.xpath("//a[contains(text(),'Guru99 telecom')]"));
	}
	
	public String checkHeadingAddTariffToCustomer() {
		return getElementText(By.xpath("//h1[.='Add Tariff Plan to Customer']"));
	}
	
	
	//EXERCISE 2 - TEST CASE 1:
//	public void enterCustomerIdNo(String CustomerIdNo) {
//		EnterText(By.xpath("//input[@id='customer_id']"), CustomerIdNo);
//	}
	
	public void enterCustomerId(String CustId) {
		EnterText(By.cssSelector("input#customer_id"), CustId);
	
	}

	public void clickSubmitButton() {
		clickElement(By.cssSelector("input[name='submit']"));
	}
	
	public String checkActive() {
		return getElementText(By.xpath("//font[contains(text(),'ACTIVE')]"));
	}
	
	//EXERCISE 2 - TEST CASE 2:
	public String checkInactive() {
		return getElementText(By.xpath("//font[contains(text(),'INACTIVE')]"));
	}
	
	//EXERCISE 2 - TEST CASE 3:          
	public String checkApprovedTariffPlan() {
		return getElementText(By.xpath("//h2[contains(text(),'Approved Tariff Plans')]"));
	}
	
	//EXERCISE 2 - TEST CASE 4:
	public void clickTariffPlan() {
//		clickElement(By.xpath("//form[@action='inserttariffplantocustomer.php']"));
		clickElement(By.xpath("//tbody/tr[1]/td[1]"));
		
	}
	
	public void clickSubmitAddTariffPlan() {
		clickElement(By.cssSelector("input[name='submit']"));
	}
	
	public String checkSuccessMessage() {
		return getElementText(By.xpath("//h2[contains(text(),'Congratulation Tariff Plan assigned')]"));
		
	}
	
}

