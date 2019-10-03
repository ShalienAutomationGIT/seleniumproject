package com.qa.pages.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.test.Base;

public class AboutPage extends Base {

	
	public AboutPage()
	{
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//h2[@class='nh-fonts-style nh-section-title nh-bold display-3'][contains(.,'About Noisehive')]")
	WebElement AboutNoiseHiveText;
	
	@FindBy(xpath="//a[@class='nav-link link text-white display-7  '][contains(.,'Newsfeed')]")
	WebElement clickNewsFeedlink;
	
	@FindBy(xpath="/html/body/section[3]/div/div/div[1]/div/a[1]")
	WebElement JoinTheHiveBtn;
	
	public void verifyAboutText()
	{
		WebElement text1 = AboutNoiseHiveText;
		String actText = text1.getText();
		Assert.assertEquals(actText, "About Noisehive");
		System.out.println("Text on About Page screen : " +actText);
		
	}
	
	
	public NewsFeedPage clickOnNewsFeedLink()
	{
		clickNewsFeedlink.click();
		return new NewsFeedPage();
	}
	
	public static void changeColor(String Color, WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor = '" +Color+"'", element);
	}
	
	public static void flashJoinTheHiveBtn(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0; i<50; i++)
		{
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgcolor, element, driver);
		}
		
		
	}
	
	
	
	
	
}
