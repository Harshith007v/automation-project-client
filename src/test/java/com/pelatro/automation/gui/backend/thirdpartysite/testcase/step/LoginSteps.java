package com.pelatro.automation.gui.backend.thirdpartysite.testcase.step;

import com.pelatro.automation.gui.backend.thirdpartysite.login.LoginPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	
	private LoginPage loginPage;
	
	@Given("I opened the app using following (.*)")
	public void openApp(String url) {
		loginPage.openAt(url);	
	}
	
	@And("I enter (.*) and (.*) and press submit")
	public void enterUsernameAndPassword(String userName, String password) {
		loginPage.enterUserNamePasswordAndPressSubmit(userName, password);
	}
	
	@Then("validate login with (.*) and (.*) and logout button")
	public void userReachesHomePage(String destUrl, String text) {
		
		loginPage.validateLogin(destUrl,text);
	}
	
	@Then("user error message (.*) is shown")
	public void checkErrMsg(String errText) {
		loginPage.validateErrMsg(errText);
	}
	
	@Then("password error message (.*) is shown")
	public void checkPasswdErrMsg(String passwdErrText) {
		loginPage.validatePasswdErrMsg(passwdErrText);
	}
}
