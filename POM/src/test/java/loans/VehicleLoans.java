package loans;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VehicleLoans {
	
	@Test(enabled = true)
	public void preowned() {System.out.println("preowned"); }
	
	@Test(enabled = false)  //exclude it from the group tag - enabled attribute true/false
	public void installments() {System.out.println("installments"); }
	
	
	@Test(dataProvider = "getData")
	public void VehicleLoan (String column1, String column2, String column3, String column4, String column5) {
		System.out.println("VehicleLoan");
		System.out.println(column1 + " " + column2 + " " + column3 + " " + column4 + " " + column5);
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object [][] data = new Object [10][5];  //10 rows 5 columns
		
		data [0][0] = "first";
		data [0][1] = "first";
		data [0][2] = "first";
		data [0][3]	= "first";
		data [0][4]	= "first";
				
		data [1][0] = "second";
		data [1][1] = "second";
		data [1][2] = "second";
		data [1][3] = "second";
		data [1][4] = "second";
		
		data [2][0] = "third";
		data [2][1] = "third";
		data [2][2] = "third";
		data [2][3] = "third";
		data [2][4] = "third";
		
		data [3][0] = "forth";
		data [3][1] = "forth";
		data [3][2] = "forth";
		data [3][3] = "forth";
		data [3][4] = "forth";
		
		data [4][0] = "fifth";
		data [4][1] = "fifth";
		data [4][2] = "fifth";
		data [4][3] = "fifth";
		data [4][4] = "fifth";
		
		data [5][0] = "sixth";
		data [5][1] = "sixth";
		data [5][2] = "sixth";
		data [5][3] = "sixth";
		data [5][4] = "sixth";
		
		data [6][0] = "seven";
		data [6][1] = "seven";
		data [6][2] = "seven";
		data [6][3] = "seven";
		data [6][4] = "seven";
		
		data [7][0] = "eight";
		data [7][1] = "eight";
		data [7][2] = "eight";
		data [7][3] = "eight";
		data [7][4] = "eight";
		
		data [8][0] = "nine";
		data [8][1] = "nine";
		data [8][2] = "nine";
		data [8][3] = "nine";
		data [8][4] = "nine";
		
		data [9][0] = "ten";
		data [9][1] = "ten";
		data [9][2] = "ten";
		data [9][3] = "ten";
		data [9][4] = "ten";
		
		return data;
		
		
		
		
	}
	
}
