package loans;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomeLoan2 {
	
	@Test
	public void increaseLoan() {System.out.println("increaseLoan"); }
	
	@Test
	public void declined() {System.out.println("declined"); }
	
	@Test(groups = {"Smoke"})
	public void fraudloan() {System.out.println("smoke fraudloan"); }

	
	
	//Data Providers
	@Test(dataProvider = "getData")
	public void HomeLoan (String username, String lastname) {
		System.out.println("HomeLoan");
		System.out.println(username + " " + lastname);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] data = new Object[3][2]; // 3 rows 2 columns
		
		data[0][0] = "firstsetusername";
		data[0][1] = "firstsetusername";
		
		data[1][0] = "secondsetusername";
		data[1][1] = "secondsetusername";
		
		data[2][0] = "thirdsetusername";
		data[2][1] = "thirdsetusername";
		
		return data;

	
	
	}

}
