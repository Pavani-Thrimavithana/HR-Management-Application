package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.util.TestUtil;
import com.hrm.qa.base.TestBase;

public class LoginPageTest extends TestBase {
	
//	initialize
	LoginPage loginPage;
	HomePage homePage;
	String validTestDataSheetName = "ValidUsers";
	String invalidTestDataSheetName = "InvalidUsers";
	TestUtil testUtil;
	
//	constructor
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest(){
		String  title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"actiTIME - Login","Login Page Titile not matched");
		
	}
	
	@Test(priority = 2)
	public void hrmLogoTest(){
		boolean img = loginPage.validateHRMImage();
		Assert.assertTrue(img);
		
	}
	
	@DataProvider
	public Object[][] getValidLoginTestData() {
		Object data[][]=TestUtil.getTestData(validTestDataSheetName);
		return data;	
	}
	
	@DataProvider
	public Object[][] getInvalidLoginTestData() {
		Object data[][]=TestUtil.getTestData(invalidTestDataSheetName);
		return data;
	}
	
	@Test(priority = 3, dataProvider="getValidLoginTestData")
	public void validUserLoginTest(String userName, String password) {
		homePage = loginPage.login(userName, password);
	}
	
	@Test(priority = 4, dataProvider="getInvalidLoginTestData")
	public void invalidUserLoginTest(String userName, String password) throws InterruptedException {
		loginPage.invalidLogging(userName, password);
		Assert.assertEquals(loginPage.validateLoginErrorMessage(),"Username or Password is invalid. Please try again.","Invalid login error msg is not displayed");
	}
	
	
	@AfterMethod
	public void tearDown() {
//		close the browser
		driver.quit();
	}
	
}
