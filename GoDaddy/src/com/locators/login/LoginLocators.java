package com.locators.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLocators {

	WebDriver driver;

	public LoginLocators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy(id = "label-username")
	WebElement usernamelabel;

	@FindBy(css = "input#password")
	WebElement password;
	
	@FindBy(id = "label-password")
	WebElement passwordlabel;

	@FindBy(xpath = "//label[@id='label-remember-me']")
	WebElement checkbox;
	
	@FindBy(xpath = "//*[@id=\"label-remember-me\"]/span[2]")
	WebElement checkboxdescription;

	@FindBy(id = "submitBtn")
	WebElement signin;
	
	@FindBy(id="login-status-message")
	WebElement Failure;
	
	@FindBy(xpath="//*[@id='password-container']/div")
	WebElement passworderror;
	
	@FindBy(xpath="//*[@id=\"login-form\"]/div[1]/div")
	WebElement usernameerror;

	public WebElement getusername() {
		return username;
	}

	public WebElement getusernamelabel() {
		return usernamelabel;
	}

	public WebElement getpassword() {
		return password;
	}

	public WebElement getpasswordlabel() {
		return passwordlabel;
	}

	public WebElement getcheckbox() {
		return checkbox;
	}

	public WebElement getcheckboxdescription() {
		return checkboxdescription;
	}

	public WebElement getsignin() {
		return signin;
	}

	public WebElement getfailuremessage() {
		return Failure;
	}
	
	public WebElement getpassworderror() {
		return passworderror;
	}
	
	public WebElement getusernameerror() {
		return usernameerror;
	}
}
