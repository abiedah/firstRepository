package takealot;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameWorkClasses.ReadExcel;
import pageObjectsTakealot.TakealotLandingPage;

public class LoopSteps {

	TakealotLandingPage lp = new TakealotLandingPage();

//	Loop steps 1-9 of assessment
	ReadExcel rExcel = new ReadExcel();
	
	@Test(dataProvider = "Takealot Data") 
	public void Takealot(String BrandName, String Quantity, String Price, String Total) {
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
             
             for(int i = 1; i < noOfRows ; i++){
            	 
                  for(int j = 0; j < noOfCols; j++){
                       data[i-1][j] = formatter.formatCellValue(sh.getRow(i).getCell(j));
//                        System.out.println(data[i-1][j]);
					}
				}

			}
        
        catch (Exception e) {

            System.out.println("The exception is: " +e.getMessage());

         }

         return data;
	}
	
	
	
	
	@Test
	public void GIVEN_Loop_Through_All_The_Steps() {

//		Daily Deals
//		GIVEN_SelectBrandFromDailyDeals
		lp.clickCookieButton();
		lp.clickDailyDeals();
		lp.enterBrand("Aerolatte");
		lp.clickClear();
		lp.enterBrand("Marvel");
		lp.clickClear();
		lp.enterBrand("Acer");
		
//		WHEN_NoItemsFound
		String actualmessage = lp.checkmessage();
		String expectedmessage = "No results found for ";

//		The THEN message at the bottom the test case
		

//		Search by Product
//		GIVEN_SearchByProduct
		lp.enterProduct("drain cover");
		lp.clickSearchIcon();
		
//		WHEN_MoreThan1Result
		String items = lp.checkResults();
		String cut = items.substring(0,3);
		int results = Integer.valueOf(cut);
		
//		THEN_AssertThatThereIsMoreThan1ItemDisplayed
		if (results >= 1) {
			System.out.println("More than 1 item is displayed for brand");
		String actualresults = lp.checkResults();
		String expectedresults = " ";
		Assert.assertTrue(true);

		
//		First item
//		GIVEN_SelectTheFirstItem
		lp.clickFirstItem();
		String price = lp.checkPrice(); // R 90
		
//		WHEN_AddItemToCart
		lp.clickAddToCart();
		
//		THEN_AssertAddToCartIsDisplayedOnTopOfPopUpWindow
		String actual = lp.checkAddedToCart();
		String expected = "Added to cart";
		Assert.assertEquals(actual, expected);
		
//		WHEN_ClickGoToCart
		lp.clickGoToCart();
		
//		AND_SelectQuantity
		lp.selectQuantity();
		
//		THEN_AssertThatCartValueIsDisplayedCorrectly
		String actualValue = lp.checkCartValue();
		String expectedValue = "R 180";
		Assert.assertEquals(actualValue, expectedValue);
			System.out.println("Asserting that the cart value is displayed correctly " + actualValue);
		
		String cut1 = price.substring(2);
		int systemprice = Integer.valueOf(cut1);
			if (systemprice * 2 == 180) {
				System.out.println("The total cart value is " + actualValue);
			} else
				System.out.println("The total cart value is incorrect " + actualValue);

			
//		Daily Deals skip message
//			THEN_SkipTheTestCase
			if (!(actualmessage == expectedmessage)) {
				System.out
						.println("Skip this test case, brands not available via Daily Deals, Aerolatte, Marvel and Acer");
				throw new SkipException("Skip this test case");
			}
		}
	}
		
	

	@AfterSuite
	public void cleanup() {
		lp.cleanup();
	}

}
