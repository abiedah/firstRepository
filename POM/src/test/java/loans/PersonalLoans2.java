package loans;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameWorkClasses.ReadExcel;

public class PersonalLoans2 {
	
	@Test
	public void flexible_repayments() throws InterruptedException {System.out.println("flexible repayments"); 
	Thread.sleep(1000);}

	@Test
	public void interest_rate() throws InterruptedException {System.out.println("interest rate"); 
	Thread.sleep(1000);}
	
	@BeforeSuite
	public void GlobalVariables() {System.out.println("Set global vars before we start"); }

	@AfterSuite
	public void GlobalVariablesReset() {System.out.println("Reset global vars"); }


		}
	
	