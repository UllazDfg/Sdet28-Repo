package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CheckFirstCellValueAndGetSecondCellValueTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/VtigerTestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		
		String cellData = "Create Organization";
		
		int rowNum = sheet.getLastRowNum();
		for(int i =1; i<rowNum; i++) {
			Row row = sheet.getRow(i);
			String firstcelldata= row.getCell(0).getStringCellValue();
			if(firstcelldata.equals(cellData)) {
				String secondCellValue=row.getCell(1).getStringCellValue();
				System.out.println(secondCellValue);
			}
			workbook.close();
		}
		
	
	}

}
