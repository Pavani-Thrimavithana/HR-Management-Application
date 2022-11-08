package com.hrm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.UsersPage;

import dev.failsafe.internal.util.Assert;

public class UserPageTest extends TestBase{

//	initialize
	LoginPage loginPage;
	HomePage homePage;
	UsersPage usersPage;

//	constructor
	public UserPageTest() {
		super();
		
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		usersPage = new UsersPage();
	}
	
	@Test
	public void userProfilesTest() {
		homePage.clickOnUsersLink();
		Assert.assertTrue(usersPage.verifyUserPageTitle(),"Users page title is not loaded");
		Assert.assertTrue(usersPage.verifyUserProfilesTable(),"Users Table is not found");
		Assert.assertTrue(usersPage.verifyUsersListCount(),"Users Table is empty");

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
