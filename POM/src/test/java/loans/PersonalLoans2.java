package loans;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameWorkClasses.ReadExcel;

public class PersonalLoans2 {
	
	@Test
	public void flexible_repayments() {System.out.println("flexible repayments"); }

	@Test
	public void interest_rate() {System.out.println("interest rate"); }
	
	@BeforeSuite
	public void GlobalVariables() {System.out.println("Set global vars before we start"); }

	@AfterSuite
	public void GlobalVariablesReset() {System.out.println("Reset global vars"); }


		}
	
	