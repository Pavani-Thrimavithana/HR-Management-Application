package com.hrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.qa.util.TestUtil;


public class TestBase {
	
//	initialize the web driver
	public static WebDriver driver;
//	initialize the properties
	public static Properties prop;
	
//	TestBase class constructor is used to initialize the Properties object to fetch config variables from config.properties file
	public TestBase(){
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/hrm/qa/config/config.properties");
			prop.load(ip);
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void initialization(){
//		read the browser property 
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrme.driver",System.getProperty("user.dir")+ "src/main/resources/chromedriver");
			driver = new ChromeDriver();	
		}
		
//		maximize the window, delete the cookies, page load timeout an implicit wait time
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
  
}
