package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.test.Base;
import com.qa.pages.test.AboutPage;
import com.qa.pages.test.NewsFeedPage;

import utils.TestUtils;

public class NewsFeedPageTest extends Base {

	TestUtils testutils;
	AboutPage aboutpage;
	NewsFeedPage newsfeedpage;
	
	public NewsFeedPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		aboutpage = new AboutPage();
		testutils = new TestUtils();
		newsfeedpage = new NewsFeedPage();
		aboutpage.clickOnNewsFeedLink();
		
		
	}
	
	
	@Test(priority=1)
	public void verifyNewsFeedText()
	{
		newsfeedpage.verifyNewsFeedText();
	}
	
	
	@Test(priority=2) 
	public void clickContactPage()
	{
	  newsfeedpage.clickOnContactLink();
	}
	 
	
	@AfterMethod()
	public void tearDown()
	{
		quitDriver();
		
	}
	
	
	
}
