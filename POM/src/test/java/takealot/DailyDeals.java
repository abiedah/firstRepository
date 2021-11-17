package takealot;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameWorkClasses.ReadExcel;
import pageObjectsTakealot.TakealotLandingPage;

public class DailyDeals {

	TakealotLandingPage lp = new TakealotLandingPage();
	
	@Test
	public void GIVEN_SelectBrandFromDailyDeals_WHEN_NoItemsFound_THEN_SkipTheTestCase() {

//		GIVEN_SelectBrandFromDailyDeals
		lp.clickCookieButton(); //Clear the cookie button GOT IT
		lp.clickDailyDeals(); //Click the Daily Deals button
		lp.enterBrand("Aerolatte"); //Select at least 1 brand (following brand not available)
		lp.clickClear();
		lp.enterBrand("Marvel");
		lp.clickClear();
		lp.enterBrand("Acer");
		
//		WHEN_NoItemsFound
		String actualmessage = lp.checkmessage();  //Assert that there are no items displayed for brand 
		String expectedmessage = "No results found for ";
			
//		THEN_SkipTheTestCase
		if (!(actualmessage == expectedmessage)) {	//No itmes displayed for brands skipped test case
			System.out.println("Skip this test case, brands Aerolatte, Marvel and Acer not available via Daily Deals");
			throw new SkipException("Skip this test case");
		}
	}
	

	@AfterSuite
	public void cleanup() {
		lp.cleanup();
	
}
}
