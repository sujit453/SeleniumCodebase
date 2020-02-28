package SeleniumPkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static Object[][] readDataFromExcel(String sheetname) {
		Object[][] obj = null;
		File src = new File("src/test/resources/testdata/test.xlsx");
		try {
			FileInputStream fls = new FileInputStream(src);
			System.out.println(fls);
			XSSFWorkbook wb = new XSSFWorkbook(fls);
			XSSFSheet sheet = wb.getSheet(sheetname);
			//int rowCount = sheet.getLastRowNum();
			//number of rows
			obj=new Object[sheet.getLastRowNum()][];
			//System.out.println("row count" + rowCount);
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				//number of columns in excel
				obj[i-1]=new Object[sheet.getRow(i).getPhysicalNumberOfCells()];
				for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
					System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
					obj[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				}

			}
			wb.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
		return obj;
	}

}
