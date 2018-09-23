package com.crm.qa.TestUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openxml4j.exceptions.InvalidFormatException;

public class TestUtil {
	
	 static Sheet sheet;
	 static Workbook book;
	 public static String Sheetpath="C:\\Users\\VINODKUMAR\\eclipse-workspace\\pomproject\\src\\main\\java\\com\\crm\\qa\\testdata\\contacts.xlsx";
	
	public static long PAGE_lOAD_TIME_OUT=30;
	public static long IMPLICITLY_WAIT=60;
	
	
	public static Object[][] getTestData(String SheetName)
	{
		FileInputStream File=null;
		try
		{
			File=new FileInputStream(Sheetpath);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try
		{
			book=WorkbookFactory.create(File);
		}
		/*
		catch(InvalidFormatException e) {
			e.printStackTrace();
		}*/
		catch(IOException e)
		{
			e.printStackTrace();
			
		}
		sheet=book.getSheetName(SheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			
		
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
	

}
