package com.qa.pages.test;



import java.awt.Window;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.test.Base;


public class DashboardPage extends Base {	
	
	
	//@FindBy annotation we use
	@FindBy(xpath="/html/body/section[1]/nav/div[2]/ul/li[1]/a")
	WebElement AboutLink;
	
	@FindBy(xpath="/html/body/section[1]/nav/div[1]/span/a/amp-img/img")
	WebElement NoisehiveLogo;
	
	@FindBy(xpath="//p[contains(text(), 'Get #YourMusicOnline')]")
	WebElement dashboardText;
	
	@FindBy(xpath="/html/body/section[1]/nav/div[2]/ul/li[4]/a")
	WebElement QALink;
	
	By byABOUT = new By.ByXPath("//a[@class='nav-link link text-white display-7  active  '][contains(.,'About')]");
	By byNEWSFEED = new By.ByXPath("//a[@class='nav-link link text-white display-7  '][contains(.,'Newsfeed')]");
	By byARTISTS = new By.ByXPath("//a[@class='nav-link link text-white display-7  '][contains(.,'Artists')]");
	By byQA = new By.ByXPath("//a[@class='nav-link link text-white display-7  '][contains(.,'Q&A')]");
	By byCONTACT = new By.ByXPath("//a[@class='nav-link link text-white display-7  '][contains(.,'Contact')]");
	By byLOGIN = new By.ByXPath("//a[@class='nav-link link text-white display-7  '][contains(.,'Login')]");
	By bySIGNUP = new By.ByXPath("//a[@class='nav-link link text-white display-7  '][contains(.,'Signup')]");
	
	
	
	//Initializing the Page Objects:
	public DashboardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void testDashboardHeaders() throws InterruptedException
	{
		Thread.sleep(1000);
		
		WebElement AboutText = driver.findElement(byABOUT);
		String actText = AboutText.getText();
		System.out.println("About Link Name : " +actText );
		Assert.assertEquals(actText, "ABOUT");
		
		Thread.sleep(1000);
		
		WebElement NewsfeedText = driver.findElement(byNEWSFEED);
		String actText1 = NewsfeedText.getText();
		System.out.println("NewsFeed Link Name : " +actText1 );
		Assert.assertEquals(actText1, "NEWSFEED");
		
		Thread.sleep(1000);
		
		WebElement ArtistsText = driver.findElement(byARTISTS);
		String actText2 = ArtistsText.getText();
		System.out.println("Artists Link Name : " +actText2 );
		Assert.assertEquals(actText2, "ARTISTS");
		
		Thread.sleep(1000);
		
		WebElement QAText = driver.findElement(byQA);
		String actText3 = QAText.getText();
		System.out.println("Q&A Link Name : " +actText3 );
		Assert.assertEquals(actText3, "Q&A");
		
		Thread.sleep(1000);
		
		WebElement ContactText = driver.findElement(byCONTACT);
		String actText4 = ContactText.getText();
		System.out.println("Contact Link Name : " +actText4 );
		Assert.assertEquals(actText4, "CONTACT");
		
		Thread.sleep(1000);
		
		WebElement LoginText = driver.findElement(byLOGIN);
		String actText5 = LoginText.getText();
		System.out.println("About Link Name : " +actText5 );
		Assert.assertEquals(actText5, "LOGIN");
		
		Thread.sleep(1000);
		
		WebElement SignupText = driver.findElement(bySIGNUP);
		String actText6 = SignupText.getText();
		System.out.println("Signup Link Name : " +actText6 );
		Assert.assertEquals(actText6, "SIGNUP");
		
		Thread.sleep(1000);
		
	}
	
	public void testDashboardTitle()
	{	
		
			String title = driver.getTitle();
			System.out.println("1. Title on Dashboard Page : " +title);
			Assert.assertTrue(title.contains("Noisehive"));		
		
	}
	
	
	public boolean verifyNoisehiveLogo()
	{
		return NoisehiveLogo.isDisplayed();
		
	}
	
	
	public AboutPage clickOnAboutLink()
	{
		AboutLink.click();
		 return new AboutPage();
	}	
	
	public void testDashboardText()
	{
		WebElement TextDashboard = driver.findElement(By.xpath("//p[contains(text(), 'Get #YourMusicOnline')]"));
		String actText = TextDashboard.getText();		
		Assert.assertEquals(actText, "Get #YourMusicOnline");
		System.out.println("Dashboard Text : " +actText );
	}
	
	
	public void getAllLinks()
	{
		//get list of web Elements containing tag name a
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		//traverse through the text and printing with the link address
		for(WebElement links:allLinks)
		{
			System.out.println("List of All links: " +links.getText() + " - " + links.getAttribute("href"));
		}				
		
	}
	
	 public void checkverticalScrollDown()
	 {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	 }
	 

	 
	 public QAPage clickOnQALink()
	 {
		 QALink.click();
		 return new QAPage();
	 }	 
	 
	 public void printGITmessage()
	 {
		 System.out.println("This is new modification done for git");
	 }
	
	
	
	
	
	
	
	
	
	
}
