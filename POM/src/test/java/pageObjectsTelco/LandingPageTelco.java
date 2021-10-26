package pageObjectsTelco;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class LandingPageTelco extends BasePage {
	
	//TEST SETUP:
	public void hello() {
		System.out.println("Hello");
	}
	
	public void clickAddCustomer() {
		clickElement(By.xpath("//a[@href='addcustomer.php']"));
	}

	public void goHome() {
		driver.navigate().forward();
		
	}
	
	//ADD TARIFF PLAN TO CUSTOMER
	public void clickAddTariffPlanToCustomer() {
		clickElement(By.xpath("//a[@href='assigntariffplantocustomer.php']"));
	}
	
		
}
