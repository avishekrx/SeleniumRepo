package com.facebook.tests;

import org.testng.annotations.*;
import org.testng.Assert;


import com.Testbase.Testbase;
import com.wallethub.pages.FacebookHomePage;
import com.wallethub.pages.FacebookLoginPage;

public class FacebookPostACommentTest extends Testbase{

	FacebookLoginPage facebookLoginPage;
	FacebookHomePage facebookHomePage;
	static String username = "Avishek Sahoo";
	
	public FacebookPostACommentTest()
	{
		super();	
	}
	
	@BeforeMethod
	public void intialize()
	{
		Initialization();
		facebookLoginPage = new FacebookLoginPage();
		facebookHomePage = new FacebookHomePage();
		facebookLoginPage.loginToFacebook();
	}
	
	@AfterMethod()
	public void killDriver()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyLoggedUser()
	{
		String user= null;
		try {
			 user = facebookHomePage.getLoggeInUserName();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(user, username);
		
	}
	
	@Test(priority=2)
	public void postComment() throws InterruptedException 
	{
		facebookHomePage.postCommentInFacebook("Wisdom spells !");
		Thread.sleep(5000);
	}
	
}
