package com.facebook.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.Testbase.Testbase;
import com.wallethub.pages.FacebookLoginPage;

public class FacebookLoginTest extends Testbase{

	FacebookLoginPage facebookLoginPage;
	
	public FacebookLoginTest()
	{
		super();
	}
	
	@BeforeTest
	public void Intilialize()
	{
		Initialization();	
		facebookLoginPage = new FacebookLoginPage();
	}
	
	@AfterMethod()
	public void killDriver()
	{
		driver.quit();
	}
	
	@Test()
	public void loginToFacebook()
	{

		facebookLoginPage.loginToFacebook();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	    Assert.assertEquals(driver.getTitle(), "Facebook");
		
	}
	
/*	@Test()
	@Parameters({"user","password"})
	public void loginToFacebook()
	{

		facebookLoginPage.loginToFacebookWithParams(String user, pass)
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	    Assert.assertEquals(driver.getTitle(), "Facebook");
		
	}*/

}
