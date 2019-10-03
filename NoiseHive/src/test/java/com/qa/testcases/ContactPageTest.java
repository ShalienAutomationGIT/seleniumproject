package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.test.Base;
import com.qa.pages.test.AboutPage;
import com.qa.pages.test.ContactPage;
import com.qa.pages.test.DashboardPage;
import com.qa.pages.test.NewsFeedPage;

import utils.TestUtils;

public class ContactPageTest extends Base {

	public ContactPageTest()
	{
		super();
	}
	
	
	TestUtils testutils;
	ContactPage contactpage;;
	AboutPage aboutpage;
	NewsFeedPage newsfeedpage;
	String sheetName ="Contacts";
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testutils = new TestUtils();
		aboutpage = new AboutPage();
		newsfeedpage = new NewsFeedPage();
		contactpage = new ContactPage();
		aboutpage.clickOnNewsFeedLink();
		newsfeedpage.clickOnContactLink();
		
		
	}
	
	@DataProvider
	public Object[][] getContactTestData()
	{
		Object data [][]= TestUtils.getTestData(sheetName);
		return data;
		
	}
	
	
	/*
	 * @Test(priority=1, dataProvider = "getContactTestData") public void
	 * testcontactUSform(String Name, String Email, String Subject, String Message)
	 * throws Throwable { contactpage.clickContactUsBtn(); Thread.sleep(2000);
	 * 
	 * //contactpage.filledContact("test", "test1@test.com", "Data1test",
	 * "Welcome to data world"); // Hardcoded value - Not good approach
	 * 
	 * contactpage.filledContact(Name, Email, Subject, Message);
	 * 
	 * newsfeedpage.clickOnContactLink();
	 * 
	 * 
	 * }
	 * 
	 */	
	@Test(priority=1)
	public void testcontactUSform() throws Throwable 
	{
		contactpage.clickContactUsBtn();
		Thread.sleep(2000);
		
		contactpage.filledContact("test", "test1@test.com", "Data1test", "Welcome to data world");  // Hardcoded value - Not good approach
						
		driver.navigate().refresh();	
		
		
	}
	
	
	
	
	@Test(priority=2)
	public void clickQALink()
	{
		contactpage.clickQALink();
	}
	
	
	
	@AfterMethod()
	public void tearDown()
	{
		quitDriver();
		
	}
	
	
}
