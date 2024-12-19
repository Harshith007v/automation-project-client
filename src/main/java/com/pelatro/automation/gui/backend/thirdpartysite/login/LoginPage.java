package com.pelatro.automation.gui.backend.thirdpartysite.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pelatro.automation.gui.backend.thirdpartysite.generic.Page;

public class LoginPage extends Page {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterUserNamePasswordAndPressSubmit(String userName, String password) {
		
		String userNameXpath = "//input[@id='username']";
		String passwordXpath="//input[@id='password']";
		String submitXpath= "//button[@id='submit']";
		
		type(userNameXpath,userName);
		type(passwordXpath,password);
		click(submitXpath);	
	}
	
	public void validateLogin(String destUrl,String text) {
		String currentURL = getCurrentURL();
		
		if(destUrl.equals(currentURL)) {
			System.out.println("Reached home page");
		}else {
			System.out.println("Failed to reach home page");
		}
		
		if(getDriver().getPageSource().contains(text)) {
			System.out.println("Text visible on Home page");
		}else {
			System.out.println("Text not visible on Home page");
		}
		
		if(element(By.xpath("//a[normalize-space()='Log out']")).waitUntilVisible().isVisible()) {
			System.out.println("Logout button visible");
		}else {
			System.out.println("Logout button not visible");
		}
        
	}
	
	public void validateErrMsg(String errText) {
		
		if(getDriver().getPageSource().contains(errText)) {
			System.out.println("Username Error message is visible");
		}else {
			System.out.println("Username Error message is not visible");
		}
		
	}
	
	
	public void validatePasswdErrMsg(String passwdErrText) {
		if(getDriver().getPageSource().contains(passwdErrText)) {
			System.out.println("Password Error message is visible");
		}else {
			System.out.println("Password Error message is not visible");
		}
		
	}
	
}
