package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;
import com.automation.utilities.BrowserFactory;


public class LoginTestHRM extends BaseClass{
	
	
	
	@Test
	public void loginApp() {
		
		logger=report.createTest("login to HRM");
		
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		loginPage.loginToHRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login",0,1));
		
		logger.pass("Logging Successful");
	
	}
	
	

}

