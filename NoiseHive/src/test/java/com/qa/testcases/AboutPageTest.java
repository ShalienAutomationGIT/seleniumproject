package com.qa.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.test.Base;
import com.qa.pages.test.AboutPage;
import com.qa.pages.test.DashboardPage;

import utils.TestUtils;

public class AboutPageTest extends Base {

	DashboardPage dashboard;
	TestUtils testutils;
	AboutPage aboutpage;
	
	
	
	public AboutPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		dashboard = new DashboardPage();
		testutils = new TestUtils();
		aboutpage = new AboutPage();
		dashboard.clickOnAboutLink();
		
	}
	
	
	@Test(priority=1)
	public void verifyAboutText() 
	{
		aboutpage.verifyAboutText();
		
	}
	
	
	
	
	  @Test(priority=2) 
	  public void clickNewsFeedLink() 
	  {
	  aboutpage.clickOnNewsFeedLink(); 
	  }
	 
	
	
	@AfterMethod()
	public void teardown()
	{
		
		quitDriver();
	}
	
	
	
}
