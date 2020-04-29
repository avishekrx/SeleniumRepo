package com.wallethub.tests;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Testbase.Testbase;
import com.Utility.Utilities;

public class WallethubPostCommentTest extends Testbase{
	
	public WallethubPostCommentTest()
	{
		super();
	}
	
	@BeforeTest
	public void initialization()
	{
		Initialization();
	}
	
	
	
	@Test(enabled = true , priority = 1)
	public void createUser() throws InterruptedException
	{
		
		driver.get(prop.getProperty("wallethubUrl"));
		
		System.out.println("title " + driver.getTitle());
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		WebElement button = driver.findElement(By.xpath("//span[text()='Get my free credit score & report']/parent::label/i"));
		
		Utilities.waitForElementToBeClickable(button);

		Utilities.clickUsingActions(button);
		
		WebElement un = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
		
		WebElement pwd = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		
		WebElement confPwd = driver.findElement(By.xpath("//input[@placeholder='Confirm Password']"));
		
		WebElement joinButton = driver.findElement(By.xpath("//div[@class='btns']/button"));
		
		un.sendKeys("soumya03@gmail.com");
		
		String pass = Utilities.generateRandomPassword(8);
		pwd.sendKeys(pass);
		confPwd.sendKeys(pass);
		
		joinButton.click();
		
	//	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		
		System.out.println("win " + driver.getWindowHandle());
		
		System.out.println("title " + driver.getTitle());
		
		WebElement register = driver.findElement(By.xpath("//div/h2[contains(text(),'Thank you for registering with WalletHub!')]"));
		
	//   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println(register.isDisplayed());
		
		System.out.println("Registered successfully");
		
		
		//******************************
		
		
	}
	
	@Test(enabled= true,priority = 2)
	public void postComment()
	{

		driver.get(prop.getProperty("wallethubtest"));
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		 Actions action = new Actions(driver);
	
		
		List<WebElement> star = driver.findElements(By.xpath("//span[contains(text(),'What')]/parent::h3/following-sibling::review-star/div//*[name()='svg']"));
		
		System.out.println(star.size());
		
		/*
				for(WebElement ele : star)
				{
				
					ele.getText();
				action.moveToElement(ele).build().perform();
				action.pause(5).build().perform();
				
				}*/
				
				for(int i =0;i<star.size();i++)
				{
					action.moveToElement(star.get(i)).build().perform();
					action.pause(5).build().perform();
					if(i==star.size()-2)
					{
						action.moveToElement(star.get(i)).click().build().perform();
						break;
					}
				}
				
				WebElement dropdown = driver.findElement(By.xpath("//div[@class='dropdown second']"));
				
				dropdown.click();
				
				List<WebElement> options = driver.findElements(By.xpath("//span[contains(text(),'Select')]/parent::div//ul/li"));
				System.out.println(options.size());
				
				for(int i=0;i<options.size();i++)
				{
					if(options.get(i).getText().equalsIgnoreCase("Health Insurance"))
					{
						options.get(i).click();
						break;
					}
				}
				
				WebElement textarea = driver.findElement(By.xpath("//textarea[@class='textarea wrev-user-input validate']"));
				
				textarea.sendKeys(RandomStringUtils.randomAlphabetic(200));
				
				WebElement submit = driver.findElement(By.xpath("//div[text()='Submit']"));
				
				submit.click();

		
	}
	
	
    

}
