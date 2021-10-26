package loans;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeLoan1 {
	
	@Parameters ({"URL"})
	@Test 
	public void bondRate(String URL) {System.out.println("bondRate"); 
	System.out.println("URL parameter " + URL);}
	
	@Test
	public void approval() {System.out.println("approval"); }
	
	@Test (groups = {"Smoke"})
	public void fraud() {System.out.println(" smoke fraud"); }
	
//	@Parameters
//	@Test
//	public void bond(String URL) {
//		System.out.println("Fifth test");
//		System.out.println("URL");
	}
	

	

