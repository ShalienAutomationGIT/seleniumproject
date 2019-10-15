package com.base.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utils.Constants;
import utils.TestUtils;
import utils.WebEventListener;

public class Base {

	// Create Global Objects

	public static Properties CONFIG;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public Base() {
		try {
			CONFIG = new Properties();
			FileInputStream input = new FileInputStream(Constants.Properties_File_Path);

			// load a properties file
			CONFIG.load(input);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

//	// Initialize Configuration
//		public void initConfig() {
//
//		
//
//			CONFIG = new Properties();
//			
//
//			try {
//				FileInputStream input = new FileInputStream(Constants.Properties_File_Path);
//					
//					
//				// load a properties file
//				CONFIG.load(input);
//				
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//				
//			}
//		}

	// To initialize the Driver

	public static void initialization() {
		String browserName = CONFIG.getProperty("browser");

		if (browserName.equals("chrome")) {			
			
					
			System.setProperty("webdriver.chrome.driver", "C:/Users/abc/Desktop/JAR files/Browsers/chromedriver.exe");
			//Syntax to run in chrome incognito mode
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/Users/abc/Desktop/JAR files/Browsers/geckodriver");
			driver = new FirefoxDriver();
		
		}else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:/Users/abc/Desktop/JAR files/Browsers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}

		
		  e_driver = new EventFiringWebDriver(driver); // Now create object of
		  //EventListerHandler to register it with EventFiringWebDriver 
		  eventListener =  new WebEventListener();
		 e_driver.register(eventListener); 
		  driver = e_driver;
		 

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(CONFIG.getProperty("url"));

	}

//		public void invokeApplication() {
//			driver.get(CONFIG.getProperty("URL"));
//		}

	public void closeBrowser() {
		driver.close();

	}

	public void quitDriver() {
		driver.quit();

	}

	public WebElement wait(WebDriver driver, String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 60l);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

	}

	public void switchingToNewWindow(WebDriver driver) throws Exception {

		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);

		}
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(winHandleBefore);

	}

	public void takeScreenShot(String fileName) {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + File.separator + "screenshots"
					+ File.separator + fileName + ".jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollDown() {
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
	}

//		@BeforeSuite
//		public void init() {
//			//initConfig();
//			initbrowser();
//			invokeApplication();
//		}

//		@AfterSuite
//		public void tearDown() throws InterruptedException {
//			closeBrowser();
//			quitDriver();
//		}
	
	
	
	
	

}
