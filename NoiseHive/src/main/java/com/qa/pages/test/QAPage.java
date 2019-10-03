package com.qa.pages.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.test.Base;

public class QAPage extends Base {

	WebDriver driver;
	WebElement element;
	
	public QAPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h2[@class='hive_title align-center nh-black nh-bold display-3 '][contains(.,'Quick Answers from the Queen Bee')]")
	WebElement QAHeaderText;
	
	
	
//	public void getHeaderText()
//	{
//		WebElement headerText = QAHeaderText;
//		String ActText = headerText.getText();
//		Assert.assertEquals(ActText, "Quick Answers from the Queen Bee");
//		System.out.println("QA Header Text : " +ActText);
//	}
	
	public void getQAText()
	{
		WebElement qaheaderText = driver.findElement(By.xpath("//h5[contains(.,'Joining')]"));
		String actualText = qaheaderText.getText();
		Assert.assertEquals(actualText, "Joining");
		System.out.println("QA Header text: " +actualText);
	}
	
	
	
	
		
		// Try to cover all java script executer functions and implementing on QA page
		
		//1. To draw border on any failed element 
		
		public  void drawBorder(WebElement element, WebDriver driver)
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].style.border='3px solid red'", element);
		}
		
		
		//2. 
		
		
		
		
		
	
	
	
	
	
}
