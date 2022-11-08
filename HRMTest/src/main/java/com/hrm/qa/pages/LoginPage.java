 package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;
import org.apache.log4j.Logger;

public class LoginPage extends TestBase {
	
//	Page Factory Object Repository
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@name='pwd']")
	WebElement password;
	
	@FindBy(xpath = "//a[@id='loginButton']")
	WebElement loginButton;
	
	@FindBy(xpath = "//input[@id='keepLoggedInCheckBox']")
	WebElement keepLoggedIn;
	
	@FindBy(xpath = " //a[@id='toPasswordRecoveryPageLink']")
	WebElement forgotPassword;
	
	@FindBy(xpath = "//div[@class='atLogoImg']")
	WebElement logo;
	
	@FindBy(xpath = "//span[@class='errormsg']")
	WebElement loginErrorMsg;
	
	public static Logger logger = Logger.getLogger(LoginPage.class);
	
//	initializing the Page Objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
//	methods
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateHRMImage(){
		return logo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		logger.info("Typing username-----");
		username.sendKeys(un);
		logger.info("Typing password-----");
		password.sendKeys(pwd);
		logger.info("Clicking login button-----");
		loginButton.click();
		return new HomePage();
	}
	
	public String validateLoginErrorMessage() {
		if(loginErrorMsg.isDisplayed()) {
			logger.info("Login error message is displayed-----");
			return loginErrorMsg.getText();
		}
		else{	
			logger.info("Login error message is not displayed-----");
			return "";
		}
	}
	
	public void invalidLogging(String un, String pwd) throws InterruptedException {
		logger.info("Typing username-----");
		username.sendKeys(un);
		logger.info("Typing password-----");
		password.sendKeys(pwd);
		logger.info("Clicking login button-----");
		loginButton.click();
		Thread.sleep(300);

	}
}
