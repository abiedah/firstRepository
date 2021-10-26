package loans;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameWorkClasses.ReadExcel;

public class DataProviders {
	
	
ReadExcel rExcel = new ReadExcel();
	
	@Test(dataProvider = "Sales Data")
	public void SalesData (String sales, String target) {
	System.out.println("Sales Data");
	System.out.println(sales + " " + target);
}

	@DataProvider(name = "Sales Data")
	public Object[][] getDatafromExcel() throws IOException{
		//return rExcel.excelDP("excelDataDir", "ExcelData.xlsx", "Sheet1")
		String excelDirectory = rExcel.getDataConfigProperties("excelDataDir");
		Object[][] arrObj = rExcel.getExcelData(excelDirectory + "Sales Data.xlsx", "Sheet1");
		
		return arrObj;
		
	}


}
