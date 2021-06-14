package com.seleniumassessment.SeleniumAssessment;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
		
		XSSFWorkbook wb;
		XSSFSheet sheet;
   		ArrayList<String> testinput;

		
		public ExcelDataConfig(String excelpath){
						
			try {
				File file = new File(excelpath);
				FileInputStream fis=new FileInputStream(file);
				wb = new XSSFWorkbook(fis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		
       public String getdata(int sheetnum,int rownum,int columnnum) {
		   sheet = wb.getSheetAt(sheetnum);
    	   String data = sheet.getRow(rownum).getCell(columnnum).getStringCellValue();   
    	   return data;
       }		
       
       public double getdataint(int sheetnum,int rownum,int columnnum) {
		   sheet = wb.getSheetAt(sheetnum);
    	   double int_data = sheet.getRow(rownum).getCell(columnnum).getNumericCellValue();   
    	   return int_data;
       }		
       
       public int sheetcount() {
    	   int sheetcount = wb.getNumberOfSheets();
		return sheetcount;
       }
       
       public int rowcount(int sheetnum) {
    	   sheet = wb.getSheetAt(sheetnum);
    	   XSSFRow row = sheet.getRow(0);
    	   int rowcount = row.getLastCellNum();
		   return rowcount;
       }
       
       public int columncount(int sheetnum,int rownum) {
    	   sheet = wb.getSheetAt(sheetnum);
    	   int columncount = sheet.getRow(rownum).getLastCellNum();
		   return columncount;
       }
       
       public ArrayList<String> getalldata(int sheetnum) {
      		testinput = new ArrayList<>();
 		    sheet = wb.getSheetAt(sheetnum);
 		    for(int i=0;i<=10;i++) {
            testinput.add(sheet.getRow(0).getCell(i).getStringCellValue());
 		    }
 		    return testinput;
       }
  }
