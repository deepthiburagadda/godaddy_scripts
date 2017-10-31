package com.pages.login;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.locators.login.LoginLocators;

public class Login {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/deepthimaddula/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://sso.godaddy.com/?realm=idp&path=%2F&app=mya");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void exit() {
		driver.quit();
	}

	@Test(priority = 0)
	public void verifyFields() {
		LoginLocators l = new LoginLocators(driver);
		System.out.println(l.getusernamelabel().getText());
		System.out.println(l.getpasswordlabel().getText());
		System.out.println(l.getcheckboxdescription().getText());
		Assert.assertEquals("Username or Customer #", l.getusernamelabel().getText());
		Assert.assertEquals("Password", l.getpasswordlabel().getText());
		Assert.assertEquals("Keep me signed in", l.getcheckboxdescription().getText());
		Assert.assertTrue(l.getusername().isDisplayed());
		Assert.assertTrue(l.getpassword().isDisplayed());
		Assert.assertTrue(l.getcheckbox().isDisplayed());
		Assert.assertTrue(l.getsignin().isDisplayed());

	}

	@Test(priority = 1, dataProvider = "fetchData")
	public void successfulLogin(String Username,String Password) throws InterruptedException {
		LoginLocators l = new LoginLocators(driver);
		l.getusername().sendKeys(Username);
		l.getpassword().sendKeys(Password);
		l.getcheckbox().click();		
		l.getsignin().click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleIs("Products"));
		System.out.println(driver.getTitle());
		Assert.assertEquals("Products", driver.getTitle());

	}
	
	@Test(priority = 3)
	public void invalidLogin() {
		LoginLocators l = new LoginLocators(driver);
		l.getusername().sendKeys("765hnfg");
		l.getpassword().sendKeys("rewggwrwe");
		l.getcheckbox().click();		
		l.getsignin().click();
		System.out.println(l.getfailuremessage().getText());
		Assert.assertEquals("Authentication failed. You entered an incorrect username or password.", l.getfailuremessage().getText());		
		
	}
	
	@Test(priority = 4)
	public void passwordValidations() {
		LoginLocators l = new LoginLocators(driver);
		l.getusername().sendKeys("vevhrh5rdv");
		l.getsignin().click();
		System.out.println(l.getpassworderror().getText());
		Assert.assertEquals("Password is required",l.getpassworderror().getText());
		
		
	}
	
	@Test(priority = 5)
	public void usernameValidations() {
		LoginLocators l = new LoginLocators(driver);
		l.getpassword().sendKeys("rhyvrhr5");
		l.getsignin().click();
		System.out.println(l.getusernameerror().getText());
		Assert.assertEquals("Username is required",l.getusernameerror().getText());
		
		
	}
	
	@DataProvider()
    public Object[][] fetchData()
	
	{
		Object[][] data =new Object [1][2];
		data[0][0]= "deepthi236";
        data[0][1]= "SXXXXXXX7";
        return data;
		
	}
	
	
	

}
