package com.qa.testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.test.Base;
import com.qa.pages.test.DashboardPage;

import utils.TestUtils;


public class DashboardPageTest extends Base {
	
	DashboardPage dashboard;
	TestUtils testutils;
	
	
	
	public DashboardPageTest() {
		super();
		
	}
		
	
	  @BeforeMethod 
	  public void setUp() 
	  { 
	  initialization(); 
	  testutils = new TestUtils(); 
	  dashboard = new DashboardPage(); 
	  }
	
	
	  @Test(priority=1) 
	  public void testDashboardTitle()
	  {
	  dashboard.testDashboardTitle(); 
	  } 
	
	
	  @Test(priority=2) 
	  public void testNoiseHiveLogo() 
	  { boolean flag =  dashboard.verifyNoisehiveLogo(); 
	  Assert.assertTrue(flag);
	  System.out.println("2. NoiseHive Logo present : " +flag);

	  }
	  
	  @Test(priority=3) 
	  public void verifyDashboardText()
	  {
	  dashboard.testDashboardText();
	  }
	  
	  @Test(priority=4) 
	  public void testalldashboardheaders() throws InterruptedException 
	  { 
		  dashboard.testDashboardHeaders(); 
	  }
	  	   	
	  @Test(priority=5)
	  public void getAllDashboardPageLinks()
	  {
		dashboard.getAllLinks();
	  }
	  
	  @Test(priority=6)
	  public void testGITMessage()
	  {
		  dashboard.printGITmessage();
	  }
		
//	  @Test(priority=6) 
//	  public void clickAboutLink() 
//	  {
//		dashboard.clickOnAboutLink(); 
//	  }		
	  
	
	  @AfterMethod() 
	  public void teardown() 
	  { 
	  quitDriver(); 
	  }
	 
	

}
