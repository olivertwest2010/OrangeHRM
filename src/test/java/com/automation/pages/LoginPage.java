package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver Idriver) {
		
		this.driver=Idriver;
	}

	@FindBy(name="username") WebElement uname;
	@FindBy(name="password") WebElement pword;
	@FindBy(xpath="//button[@type='submit']") WebElement loginBtn;
	
	
	public void loginToHRM(String Username, String Password) {
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}
		
		uname.sendKeys(Username);
		pword.sendKeys(Password);
		loginBtn.click();
		
		
	}
	
	
}
