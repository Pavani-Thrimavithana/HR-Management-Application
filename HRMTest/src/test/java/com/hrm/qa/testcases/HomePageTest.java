package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.UsersPage;


public class HomePageTest extends TestBase {
	
//	initialize
	LoginPage loginPage;
	HomePage homePage;
	UsersPage usersPage;
	
//	constructor
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		usersPage = new UsersPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest(){
		String  title = homePage.validateHomePageTitle();
		Assert.assertEquals(title,"actiTIME -  Approve Time-Track","Home Page Title not matched");
		
	}
	
	@Test(priority = 2)
	public void hrmLogoTest(){
		boolean img = homePage.validateHRMImage();
		Assert.assertTrue(img);
		
	}
	
	@Test(priority = 3)
	public void  logonUserNameTest(){
		boolean name = homePage.validateLogonUserName();
		Assert.assertTrue(name);
	}
	
	@Test(priority = 4)
	public void UserTab(){
		usersPage = homePage.clickOnUserTab();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
