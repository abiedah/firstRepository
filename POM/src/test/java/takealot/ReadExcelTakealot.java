
package takealot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameWorkClasses.ReadExcel;

public class ReadExcelTakealot {

	//Read Takealot data from excel
	ReadExcel rExcel = new ReadExcel();

	@Test(dataProvider = "Takealot Data") 
	public void TakealotData(String BrandName, String Quantity, String Price, String Total) {
		System.out.println("Takealot Data");
		System.out.println(BrandName + " " + Quantity + " " + Price + " " + Total);
	}

	@DataProvider(name = "Takealot Data")
	public Object[][] getDatafromExcel() throws IOException {
		String excelDirectory = rExcel.getDataConfigProperties("excelDataDir");
		Object[][] arrObj = rExcel.getExcelData("C:\\Temp\\Takealot Data.xlsx", "Sheet1");
		return arrObj;
	}

	
	public String[][] getExcelData(String TakealotData, String Sheet1) {
        String[][] data = null; 
        try
        {
        	 FileInputStream fis = new FileInputStream("C:\\Temp\\Takealot Data.xlsx");
        	 
        	 XSSFWorkbook wb = new XSSFWorkbook(fis);
             XSSFSheet sh = wb.getSheet("Sheet1");
             DataFormatter formatter = new DataFormatter();
             XSSFRow row = sh.getRow(0);
             int noOfRows = sh.getPhysicalNumberOfRows();
             int noOfCols = row.getLastCellNum();
         

             data = new String[noOfRows-1][noOfCols];
             for(int i = 1; i < noOfRows ;i++){
            	 
                  for(int j = 0; j < noOfCols; j++){
                        data[i-1][j] = formatter.formatCellValue(sh.getRow(i).getCell(j));
                        System.out.println(data[i-1][j]);
					}
				}

			}
        
        catch (Exception e) {

            System.out.println("The exception is: " +e.getMessage());

         }

         return data;
	}
}
		
		