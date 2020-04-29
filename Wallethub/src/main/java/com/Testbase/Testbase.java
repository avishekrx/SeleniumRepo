package com.Testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testbase {

	public static WebDriver driver;
	public static Properties prop;
	public FileInputStream fis;
	public static  String browser;
	
	
	
	public Testbase()
	{
		prop = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/config/config.properties");
			
		} catch (FileNotFoundException e) {
			System.out.println("Config file not found on location");
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			System.out.println("Unable to load Config file");
			e.printStackTrace();
		}
	}
	
	
	public static void Initialization()
	{
	 browser = prop.getProperty("browser");
	 System.out.println(browser);
	    Map<String, Object> prefs = new HashMap<String, Object>();
		
	
		 if(browser.equalsIgnoreCase("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\avish\\Documents\\Wallethub\\chromedriver.exe");
		//	 System.setProperty("webdriver.chrome.driver", "/Users/asahoo/Documents/Wallethub/Wallethub/chromedriver");
		//	 prefs.put("profile.default_content_setting_values.notifications", 2);
		//	 ChromeOptions options = new ChromeOptions();
		//	 options.setExperimentalOption("prefs", prefs);
			
			 driver = new ChromeDriver();
			// driver = new ChromeDriver(options);
		 }
		 if(browser.equalsIgnoreCase("firefox"))
		 {

				
			 System.setProperty("webdriver.gecko.driver", "/Users/asahoo/Documents/Wallethub/Wallethub/geckodriver");
			 
			 driver = new FirefoxDriver();
		 }
		 
	 driver.manage().window().maximize();	 
	 driver.manage().deleteAllCookies();
	// driver.get(prop.getProperty("facebookurl"));
	
	}
	
}
