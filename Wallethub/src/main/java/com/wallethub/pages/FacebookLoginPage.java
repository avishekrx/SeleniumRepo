package com.wallethub.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Testbase.Testbase;

public class FacebookLoginPage extends Testbase
{

	static String user,name,login = null;
	
	public FacebookLoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Create New Account')]")
	WebElement newAccount;

	
	@FindBy(xpath="//input[@name='email']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='pass']")
	WebElement password;
	
	@FindBy(xpath = "//input[@name='pass']/parent::td/following-sibling::td//input")
	WebElement loginButton;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginButton2;
	
	
	
	public FacebookHomePage loginToFacebook()
	{
		driver.get(prop.getProperty("facebookUrl"));
		username.sendKeys(prop.getProperty("user"));
		password.sendKeys(prop.getProperty("pass"));
		loginButton.click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		return  new FacebookHomePage();
		
		
	}
/*	
	public FacebookHomePage loginToFacebookWithParams(String user, String pass)
	{
		driver.get(prop.getProperty("facebookUrl"));
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		return  new FacebookHomePage();
		
		
	}*/
	
}
