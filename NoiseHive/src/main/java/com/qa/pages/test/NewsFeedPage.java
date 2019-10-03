package com.qa.pages.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.test.Base;

public class NewsFeedPage extends Base {

	public NewsFeedPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h2[@class='align-center nh-bold nh-danger nh-fonts-style display-3'][contains(.,'News from the Hive')]")
	WebElement NewsFeedText;
	
	@FindBy(xpath="//a[@class='nav-link link text-white display-7  '][contains(.,'Contact')]")
	WebElement ContactLink;
	
	
	public void verifyNewsFeedText()
	{
		WebElement newsfeedtext = NewsFeedText;
		String actText = newsfeedtext.getText();
		Assert.assertEquals(actText, "News from the Hive");
	}
	
	
	public ContactPage clickOnContactLink()
	{
		ContactLink.click();
		return new ContactPage();
		
	}


	
	
	
	
	
	
}
