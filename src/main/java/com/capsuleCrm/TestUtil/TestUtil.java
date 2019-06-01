package com.capsuleCrm.TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.capsuleCrm.TestBase.TestBase;

/**
 * Aids by providing methods like waitForElement(Explicit wait) and
 * ConvertStringToInt which is used in SerachResultsPage. And stores integer
 * variables for wait and property number used in SerachResultsPage.
 * 
 * @author Akhila Bandiki
 *
 */

public class TestUtil extends TestBase {
	/* Wait Variables */
	public static int Short_Wait = 5;
	public static int Medium_Wait = 10;
	public static int Long_Wait = 20;
	/* Test Data Sheet variables */
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"/src/main/java/com/capsuleCrm/TestData/CapsuleCRMTestData.xlsx";
	static Workbook book;
	static Sheet sheet;

	public static String timeStamp;
	/* Explicit wait */
	public static void waitForElement(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}

	/*
	 * Fetches the data from the excel sheet and returns and object array with test
	 * data
	 * 
	 * @param sheet name, the excel sheet name which contains test data
	 * 
	 * @return data, which is an object array containing test data
	 */
	public static Object[][] getTestData(String SheetName) {
		FileInputStream fs = null;

		try {
			fs = new FileInputStream(TESTDATA_SHEET_PATH);
			book = WorkbookFactory.create(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(SheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				}
			}
		return data;
	}
	/* Returns the String with current time*/
	public static String gettimestamp() {
		timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
		return timeStamp;
	}

}