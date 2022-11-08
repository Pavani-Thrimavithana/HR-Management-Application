 package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

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
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}
	
	public String validateLoginErrorMessage() {
		if(loginErrorMsg.isDisplayed()) {
			return loginErrorMsg.getText();
		}
		else{			
			return "";
		}
	}
	
	public void invalidLogging(String un, String pwd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		Thread.sleep(300);

	}
}
