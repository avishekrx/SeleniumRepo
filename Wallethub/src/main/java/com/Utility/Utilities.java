package com.Utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Testbase.Testbase;

public class Utilities extends Testbase{
	
	static Actions action;
	public static WebDriverWait ewait;
	

	public static void writeTextUsingActions(WebElement element, String text)
	{
		action = new Actions(driver);
		action.moveToElement(element).sendKeys(text).build().perform();
		
	}
	
   public static void clickUsingActions(WebElement element)
   {
	   action = new Actions(driver);
	   action.moveToElement(element).click().build().perform();
			   
   }
   
   public static void waitForElementToBeClickable(WebElement element)
   {
	   ewait = new WebDriverWait(driver,20);
	   ewait.until(ExpectedConditions.elementToBeClickable(element));
	   
   }
   
   public static void waitForElementToBeLocated(WebElement element)
   {
	   ewait = new WebDriverWait(driver,20);
	   ewait.until(ExpectedConditions.presenceOfElementLocated((By) element));
	   
   }
   
   public static String generateRandomPassword(int len) {
		
	        String special = "@$@4&#%^$*";

			String alphanumeric = RandomStringUtils.randomAlphanumeric(len-1);
			
			RandomStringUtils.random(1, special);
			
			String password = alphanumeric+special; 
	    return password;
	  
   }
   
   public static void takeScreenshot()
   {
	 
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("/Users/asahoo/Documents/Wallethub/Wallethub/Screenshots/error1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
   }
}
