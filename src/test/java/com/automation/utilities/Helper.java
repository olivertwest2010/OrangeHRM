package com.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class Helper {
	
	//screenshot,alerts,frames,windows,sync issue,java script executor
	public static String captureScreenshot(Webdriver driver) {
		
		
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String screenshotPath=getProperty("user.dir")+"/Screenshots/HRM_" +getCurrentDateTime()+".png";
			
		try {	
			FileHandler.copy(src, new File(screenshotPath));
			
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot "+e.getMessage());
		}
		
		return screenshotPath;
	}
    
	public static String getCurrentDateTime() {
		DateFormat format=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate=new Date();
		
		return customFormat.format(currentDate);
	}
}
