package com.supplay;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class SupplyData {

	
	@DataProvider
	public Object[][] supplyTestData() throws Exception {

		
			File file=new File("C:\\javapratice\\JavaPractice\\LiveProjectSelenium\\src\\test\\resources/tutorialsNinjaTestData.xlsx");

			FileInputStream fis=new FileInputStream(file);

			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet	sheet=workbook.getSheet("Data");
			int noOfRows=sheet.getPhysicalNumberOfRows();
			int onOfColums=sheet.getRow(0).getLastCellNum();

			String[][] data=new String[noOfRows-1][onOfColums];
			for (int i = 0; i<noOfRows-1; i++) {
				for (int j = 0; j <onOfColums ; j++) {
					DataFormatter df=new DataFormatter();
			   data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			        
				}
			}

			workbook.close();
			fis.close();
			return data;

			}
}
