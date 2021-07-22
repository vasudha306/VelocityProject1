package UtilityPOM;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UtilityForExcel {
	public static  void ExcelsheetCode(String path,String sheetName) throws EncryptedDocumentException, IOException
	{
		String path1="C:\\Users\\admin\\Desktop\\userdata1.xlsx";
		FileInputStream file=new FileInputStream(path1);
		  
		Workbook w= WorkbookFactory.create(file);
		Sheet sheet=w.getSheet("Sheet2");
		int lastrowno=sheet.getLastRowNum();
		Row r=	sheet.getRow(0);
		
		int lastcellno=r.getLastCellNum();
		Cell c=	r.getCell(0);
		WorkbookFactory.create(file).getSheet(sheetName).getRow(0).getCell(0).getStringCellValue();
}

}
