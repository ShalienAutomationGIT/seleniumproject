package com.qa.pages.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.test.Base;

public class ContactPage extends Base {

	
	public ContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/div[1]/div/div/section/div[1]/a/label")
	WebElement ContactUsBtn;
	
	@FindBy(id="name")
	WebElement Name;
	
	@FindBy(id="email")
	WebElement Email;
	
	@FindBy(id="subject")
	WebElement Subject;
	
	@FindBy(id="body")
	WebElement Message;
	
	@FindBy(xpath="//a[contains(.,'Close')]")
	WebElement closepopup;
	
	@FindBy(xpath="/html/body/section[1]/nav/div[2]/ul/li[4]/a")
	WebElement QALink;
		
	
	
	public void clickContactUsBtn()
	{
		ContactUsBtn.click();
	}
	
	public void filledContact(String namefield, String emailfield, String subjectfield, String messagefield ) throws Throwable
	{
		
		Name.sendKeys(namefield);
		Thread.sleep(1000);
		Email.sendKeys(emailfield);
		Thread.sleep(1000);
		Subject.sendKeys(subjectfield);
		Thread.sleep(1000);
		Message.sendKeys(messagefield);
		Thread.sleep(1000);
		closepopup.click();
		Thread.sleep(1000);
		
		
	}
	
	public QAPage clickQALink()
	{
		
		QALink.click();
		return new QAPage();
		
	}
	
	
	
}
