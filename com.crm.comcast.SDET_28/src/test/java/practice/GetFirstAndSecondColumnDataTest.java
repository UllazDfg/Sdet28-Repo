package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetFirstAndSecondColumnDataTest {

	public static void main(String[] args) throws Throwable {
	
		
		
			 
		 
		
		 FileInputStream Fis = new  FileInputStream("./src/test/resources/VtigerTestData.xlsx");
		 Workbook book = WorkbookFactory.create(Fis);
		 Sheet sheet = book.getSheet("Sheet1");
		
		
		 int rowNum=sheet.getLastRowNum();
		 
		 for(int i=1; i<=rowNum; i++) {
		 Row row =sheet.getRow(i);
		 
			 String firstColumnData = row.getCell(0).getStringCellValue();
			 String secondColumnData=row.getCell(1).getStringCellValue();
			 System.out.println(firstColumnData+"\t"+secondColumnData);
			 
		 }
		 book.close();
	

	}
}
