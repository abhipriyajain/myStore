package com.sore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcelFile {

	public static FileInputStream inputstream ;
	public static XSSFWorkbook workBook;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public static XSSFRow row;
	
	public static String getCellValue(String FileName, String sheetName, int rowno, int cellno) throws IOException
	{
		inputstream = new FileInputStream(FileName);
		workBook = new XSSFWorkbook(inputstream);
		sheet=workBook.getSheet(sheetName);
		cell=workBook.getSheet(sheetName).getRow(rowno).getCell(cellno);
		return cell.getStringCellValue();
	}
	
	
	public static int getRowCount (String FileName, String sheetName) throws IOException
	{
		inputstream = new FileInputStream(FileName);
	workBook = new XSSFWorkbook(inputstream);
	sheet=workBook.getSheet(sheetName);
		int ttlrow=sheet.getLastRowNum()+1;
		return ttlrow;
	}
	
	public static int getColCount (String FileName, String sheetName) throws IOException
	{
		inputstream = new FileInputStream(FileName);
	workBook = new XSSFWorkbook(inputstream);
	sheet=workBook.getSheet(sheetName);
		int ttlcol=sheet.getRow(0).getLastCellNum();
		return ttlcol;
	}
	
	
}
