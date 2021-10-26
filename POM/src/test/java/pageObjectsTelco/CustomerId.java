package pageObjectsTelco;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import frameWorkClasses.BasePage;

public class CustomerId extends BasePage {

	//EXERCISE 1 - TEST CASE 3:
	public String checkCustomerIdText() {
		return getElementText(By.xpath("//b[contains(text(),'Customer ID')]"));
		
	}

//	public String getCustomerId() {
//		return getElementText(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/h3[1]"));
//	}

	public String getCustID() {
		String CustId = getElementText(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/h3[1]"));
		return CustId;
	}
}
	
	
	
	
		
		
	
	

	
	
	

	

