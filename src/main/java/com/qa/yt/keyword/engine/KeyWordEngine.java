package com.qa.yt.keyword.engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

import com.qa.yt.keyword.base.Base;

public class KeyWordEngine {
	
	public WebDriver driver;
	public Properties prop;
	public Base base;
	
	
	public static Workbook book;
	public static Sheet sheet;
	
	public final String SCENARIO_SHEET_PATH="/Youtube/src/main/java"
			+ "/com/qa/yt/keyword/scenarios/YT_Scenarios.xlsx";
	
	
	
	public void startExecution(String sheetName)
	{
		String locatorName=null;
		String locatorValue=null;
		
		FileInputStream file=null;
		
		try {
			file=new FileInputStream(SCENARIO_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
			try {
				book = WorkbookFactory.create(file);
			}catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
			sheet=book.getSheet(sheetName);
			
			int k=0;
			for(int i=0;i<sheet.getLastRowNum();i++)
			{
				String locatorColValue=sheet.getRow(i+1).getCell(k+1).toString().trim(); //get the locator column values
				if(!locatorColValue.equalsIgnoreCase("NA"))
				{
					locatorName=locatorColValue.split("=")[0].trim();
					
					locatorValue=locatorColValue.split("=")[1].trim();
				}
				
				String action=sheet.getRow(i+1).getCell(k+2).toString().trim();	
				String value=sheet.getRow(i+1).getCell(k+3).toString().trim();	
				
				switch(action) {
				case "open browser":
					base = new Base();
					base.init_properties();
					
					break;
				
				}
			}
		
	}
	

}
