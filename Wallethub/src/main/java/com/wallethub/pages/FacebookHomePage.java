package com.wallethub.pages;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Testbase.Testbase;
import com.Utility.Utilities;

public class FacebookHomePage extends Testbase{
	
	public FacebookHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Avishek Sahoo']")
	WebElement accountName;
	
	@FindBy(xpath="//div/textarea")
	WebElement clickonCommentArea;
	
	@FindBy(xpath="//div[contains(text(),'Write something here.')]")
	WebElement writeComment;
	
	@FindBy(xpath="//button[@data-testid='react-composer-post-button']")
	WebElement postCommentButton;
	
	
	
	public String getLoggeInUserName()
	{
		String user = accountName.getText();
		System.out.println("user is : " + user);
		return user;
	}
	
	public void postCommentInFacebook(String comment) 
	{

		clickonCommentArea.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Utilities.writeTextUsingActions(writeComment, comment);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Utilities.clickUsingActions(postCommentButton);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	}
	
	

}
