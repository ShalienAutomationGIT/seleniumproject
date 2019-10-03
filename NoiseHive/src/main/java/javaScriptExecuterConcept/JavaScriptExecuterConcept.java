package javaScriptExecuterConcept;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecuterConcept {

	WebDriver driver;
	
	
	public static void main(String[] args) throws IOException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/abc/Desktop/JAR files/Browsers/chromedriver.exe");   //set chrome path
		
		WebDriver driver = new ChromeDriver(); // launch chrome
		
		driver.manage().window().maximize(); //maximize window
		driver .manage().deleteAllCookies(); //delete all cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://noisehiveqa.intelegencia.com"); //launch URL
		
		driver.findElement(By.xpath("/html/body/section[1]/nav/div[2]/ul/li[1]/a")).click(); //About Link
		
		
		
		
		//1. To highlight the element
		
		WebElement JoinTheHiveBtn = driver.findElement(By.xpath("//a[@class='button1'][contains(.,'Join the hive')]"));
		flashJoinTheHiveBtn(JoinTheHiveBtn, driver);
		
		//2. To draw border on some element
		
		drawBorder(JoinTheHiveBtn, driver);
		
		//3. Take ScreenShot and store a file format
		
		    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    //copy the screenshot to desired location
		    
		    FileUtils.copyFile(src,  new File("C:\\Users\\abc\\eclipse-workspace_MobileAppTest\\NoiseHive\\screenshots\\element.png"));
		    
		//4. Generate Alert
		    //generateAlert(driver, "There is an issue with JOIN THE HIVE button");
		    
		
		    
	    //5. Click on any element using javascript
		    
		    WebElement moreInformation = driver.findElement(By.xpath("//a[@class='button2'][contains(.,'More Information')]"));
		    clickusingJS(moreInformation, driver);
		    
		    
	   //6. Refresh page using javascript
		    
		    refreshBrowserbyJS(driver);
		    
		    
	   //7. To get Page Title using javascript
		    
		    System.out.println(getTitleusingJS(driver));
		    
	   //8. To get all text of page using javascript. 
           //Since selenium doesn't have feature to get complete text og page. So we use innerText in javascript.
           //In selenium we have driver.getPageSource(); but that willl give page source code not complete text.
		    
		    System.out.println(getPageInnerTextusingJS(driver));
		    
		    
	  //9. Scroll Down vertically:
		    
		   // scrollDown(driver);
		    
		    
	//10. ScrollIntoView - want to scroll till some special element
		    
		    
		    WebElement digitaldistributionText = driver.findElement(By.xpath("//h2[contains(text(),'What is Digital Distribution?')]"));
		    scrollIntoView(digitaldistributionText, driver);
		
	}
	
	
	
	
	public static void flashJoinTheHiveBtn(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0; i<30; i++)
		{
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgcolor, element, driver);
		}
					
	}
	
	public static void changeColor(String Color, WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor = '" +Color+"'", element);
		
		try {
			Thread.sleep(20);
			
		}catch(InterruptedException e)
		{
			
		}
	}
	
	public static void drawBorder(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void generateAlert(WebDriver driver, String message)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
		
	}
	
	public static void clickusingJS(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click()", element);
		
		
	}
	
	public static void refreshBrowserbyJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	
	
	public static String getTitleusingJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String PageTitle = js.executeScript("return document.title;").toString();
		return PageTitle;
	}
	
	public static String getPageInnerTextusingJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String PageInnerText = js.executeScript("return document.documentElement.innerText;").toString();
		return PageInnerText;
	}
	
	public static void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public static void scrollIntoView(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	
	
}
