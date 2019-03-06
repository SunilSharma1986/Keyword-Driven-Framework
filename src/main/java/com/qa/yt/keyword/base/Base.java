package com.qa.yt.keyword.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	
	public WebDriver dr;
	public Properties prop;
	
	
	public WebDriver init_driver(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Chrome\\chromedriver.exe");
			if(prop.getProperty("headless").equalsIgnoreCase("Yes"))
			{
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--healess");
				dr=new ChromeDriver(options);
			}else {
			dr=new ChromeDriver();
			}
		}
		
		return dr;
	}
	
	
	
	public Properties init_properties()
	{
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("E:\\Workspace\\Youtube\\src\\main\\java"
					+ "\\com\\qa\\yt\\keyword\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
}
