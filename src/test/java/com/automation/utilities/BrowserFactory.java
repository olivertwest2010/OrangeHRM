package com.automation.utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	//public WebDriver driver;
	
	
	public static WebDriver startApplication(WebDriver driver,String browserName,String appURL) {
		
		if(browserName.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
			
		}
		else if(browserName.equals("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		else if(browserName.equals("IE")) {
			
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
			driver=new EdgeDriver();
			
		}
		else {
			System.out.println("Browser Not Supported");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		return driver;
	}
	 public static void quitBrowser(WebDriver driver) {
		 
		 driver.quit();
		 
	 }

}
