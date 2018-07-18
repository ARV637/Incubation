package com.webdriverlib.auto;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Ashish_Vishnoi
 *
 */
public class ExcelUtil {
	final static String path = ("/home/desk-user/Desktop/ShyleeWorkspace/flipkart/src/test/resources/testdata/testdata.xlsx");

	public String getData(String sname, int rnum, int cnum) {
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook w1 = WorkbookFactory.create(fis);
			String data = w1.getSheet(sname).getRow(rnum).getCell(cnum).getStringCellValue();
			return data;
		} catch (Exception rv) {
			return "";
		}
	}

	public void setData(String sname, int rnum, int cnum, String data) {
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook w1 = WorkbookFactory.create(fis);
			w1.getSheet(sname).getRow(rnum).createCell(cnum).setCellValue(data);
			FileOutputStream fos = new FileOutputStream(path);
			w1.write(fos);
		} catch (Exception rv) {

		}
	}
}
