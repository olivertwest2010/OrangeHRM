package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelDataProvider<XSSFWorkbook> {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		
		File src=new File ("./TestData/TestData1.json");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			
			System.out.println("Unable To Read The read the Excel file "+e.getMessage());
		}
		
		
	}
	public String getStringData(String SheetName,int row,int column) {
		return wb.getSheet("SheetName").getRow(row).getCell(column).getStringCellValue();
	}
    
	public void getNumericData(String SheetName,int row,int column) {
		return wb.getSheet("SheetName").getRow(row).getCell(column).geNumericCellValue();
	}
}
