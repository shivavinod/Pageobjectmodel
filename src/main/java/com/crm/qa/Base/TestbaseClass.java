package com.crm.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.TestUtility.TestUtil;

public class TestbaseClass {
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestbaseClass()
	{
		try
		{
		 prop=new Properties();
		 FileInputStream ip = new FileInputStream("C:\\Users\\VINODKUMAR\\eclipse-workspace\\pomproject\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			
		 prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}




public static void Intialization()
{
	String browsername=prop.getProperty("browser");
	if(browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VINODKUMAR\\eclipse-workspace\\s\\Driver\\chromedriver.exe");
	    driver=new ChromeDriver();
		
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_lOAD_TIME_OUT,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	
}
}
