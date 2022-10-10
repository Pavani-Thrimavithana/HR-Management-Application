package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.base.TestBase;

public class LoginPageTest extends TestBase {
	
//	initialize
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void seup() {
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest(){
		String  title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"actiTIME - Login");
		
	}
	
	@Test(priority = 2)
	public void hrmLogoTest(){
		boolean img = loginPage.validateHRMImage();
		Assert.assertTrue(img);
		
	}
	
	@Test(priority = 3)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown() {
//		close the browser
		driver.quit();
	}
	
}
