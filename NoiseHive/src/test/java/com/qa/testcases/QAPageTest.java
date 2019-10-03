package com.qa.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.test.Base;
import com.qa.pages.test.AboutPage;
import com.qa.pages.test.ContactPage;
import com.qa.pages.test.DashboardPage;
import com.qa.pages.test.NewsFeedPage;
import com.qa.pages.test.QAPage;

import utils.TestUtils;

public class QAPageTest extends Base {
	
	@FindBy(xpath="/html/body/section[2]/div/h2")
	WebElement QAHeaderText;
	

	public QAPageTest()
	{
		super();
	}
	
	TestUtils testutils;
	ContactPage contactpage;
	QAPage qapage;
	AboutPage aboutpage;
	NewsFeedPage newsfeedpage;
	DashboardPage dashboard;
	
	
	
	
	@BeforeMethod
	public void setUp() throws Throwable
	{
		initialization();
		testutils = new TestUtils();		
		//aboutpage = new AboutPage();
		//newsfeedpage = new NewsFeedPage();
		//contactpage = new ContactPage();
		dashboard = new DashboardPage();
		qapage = new QAPage();
		//aboutpage.clickOnNewsFeedLink();		
		//newsfeedpage.clickOnContactLink();		
		//contactpage.clickQALink();	
		dashboard.clickOnQALink();
		Thread.sleep(2000);
		
	}
	
	@Test(priority=1)
	public void checkQAHeaderText()
	{
		qapage.getQAText();
	}
	
//	@Test(priority=2)
//	public  void testjavascriptExecuterfunc() throws InterruptedException
//	{
//		//1. to draw a border 
//		Thread.sleep(2000);
//		qapage.drawBorder(QAHeaderText, driver);
//	}
	
	
	
	
	

	  @AfterMethod() 
	  public void teardown() 
	  { 
	  quitDriver(); 
	  }
	
	
	
	
}
