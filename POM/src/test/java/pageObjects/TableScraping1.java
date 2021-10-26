package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import frameWorkClasses.BasePage;

public class TableScraping1 extends BasePage {

	
	public void goToTables() {
		driver.get("http://demo.guru99.com/test/web-table-element.php");
	}

	// navigate to http://demo.guru99.com/test/web-table-element.php
	// print the number of rows and columns
	// print the value of row 4 column 4 --- 1 value

	@Test 
	public void table() {
		goToTables();

		
				//To locate table
				WebElement mytable = getElement(By.xpath("//tbody"));
				
				//To locate rows of table
				List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
				
				//To calculate no. of rows in a table
				int rows_count = rows_table.size();  
				int row = 4;
				
				//To locate columns(cells) of that specific row
				List <WebElement> columns_row = rows_table.get(4).findElements(By.tagName("td"));
				
				//To calculate no of columns (cells). In that specific row.
				int columns_count = columns_row.size();
				int column = 4;
				
				System.out.println("Number of rows is " + rows_count + " Number of columns is " + columns_count  );
				
				String celltext = columns_row.get(column).getText();
				System.out.println("Cell Value of row number " + row + " and column number " + column + " is " + celltext );
		
		
		
		
		
		
//		WebElement table = getElement(By.xpath("/html/body"));
//
//		List<WebElement> rows_table = table.findElements(By.tagName("tr"));
//
//		int rows_count = rows_table.size();
//
//		for (int row = 0; row < rows_count; row++) {
//
//			List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName("td"));
//
//			int columns_count = columns_row.size();
//
//			System.out.println("Number of cells In Row " + row + " is " + columns_count);
//			
//			for (int column = 0; column < columns_count; column++) {
//				String celltext = columns_row.get(column).getText();
//				System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celltext );
//			}
			
//		}
	}
}


