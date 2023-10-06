package com.automation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.testcases.XSSFWorkbook;
import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ConfigDataProvider;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;

public class BaseClass {
	
 public WebDriver driver;
 public ExcelDataProvider excel;
 public ConfigDataProvider config;
 public ExtentReports report;
 public ExtentTest logger;
	
    @BeforeSuite
    public void setUpSuite() {
    	
    	Reporter.log("Setting Up Reports, Test Ready", true);
    	
    	 excel=new ExcelDataProvider();
    	 config=new ConfigDataProvider();
    	 
    	 ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/HRM_"+Helper.getCurrentDateTime()+".html"));
    	 report=new ExtentRentReports();
    	 report.attachReporter(extent);
    	 
    	 Reporter.log("Setting Done- Test Can Be Started", true);
    }
    
    @Parameters({"broser","urlToBeTested"})
 
	@BeforeClass
	public void setApp(String browser, String url) {
		
		Reporter.log("Browser Starting", true);
		//driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		driver=BrowserFactory.startApplication(driver, browser, url);

		
		Reporter.log("Browser and Application Running", true);
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws Exception {
		
		if (result.getStatus()==ITestResult.FAILURE) {
	    logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		
		}
		
		report.flush();
		
		Reporter.log("Test Compelted", true);
	}
	
	

}
