package loans;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PersonalLoans1 {
	
	
	@Test
	public void provisional() throws InterruptedException {System.out.println("provisional"); 
	Thread.sleep(1000);} 
	
	@Test
	public void approvalPL() throws InterruptedException {System.out.println("approvalPL");
	Thread.sleep(1000);
	
//	String expected = "Test failed";
//	String actual = "not working";
//	Reporter.log("expected ...." + expected);
//	Reporter.log("actual.... " + actual);
//	Assert.assertTrue(false);
	}
	
//	@BeforeTest
//	public void cleanDB() {System.out.println("Then the database before we start");}
	
	@BeforeTest
	@AfterTest
	public void cleanDB() {System.out.println("Clean the database before we start and end"); }
}
