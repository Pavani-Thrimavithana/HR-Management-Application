package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.TimeTrackPage;

public class TimeTrackPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TimeTrackPage timeTrackPage;

	public TimeTrackPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		timeTrackPage = new TimeTrackPage();
	}


	@Test(priority= 1)
	public void timeSheetApprovalTest() {
		homePage.clickOnTimeTrackLink();
		Assert.assertTrue(timeTrackPage.verifyTimeTrackPageTitle(),"Time Track page title is not loaded");
		Assert.assertTrue(timeTrackPage.verifyApproveTimeTrackTab(),"Approve time track tab is not loaded");
		timeTrackPage.clickApproveTimeTrackLink();
		Assert.assertTrue(timeTrackPage.verifyApproveTimeTrackPageTitle(),"Approve Time Track page title is not loaded");
		Assert.assertTrue(timeTrackPage.verifyApproveTimeTable(),"Approve Time Track table is not loaded");
		Assert.assertTrue(timeTrackPage.verifyUserNameListCount(),"Empty users in Approve time track table");
		timeTrackPage.selectFirstUserCheckBox();
		timeTrackPage.clickTimeTrackApproveBtn();
	}
	
	@Test(priority= 2)
	public void timeSheetRejectTest() {
		homePage.clickOnTimeTrackLink();
		Assert.assertTrue(timeTrackPage.verifyTimeTrackPageTitle(),"Time Track page title is not loaded");
		Assert.assertTrue(timeTrackPage.verifyApproveTimeTrackTab(),"Approve time track tab is not loaded");
		timeTrackPage.clickApproveTimeTrackLink();
		Assert.assertTrue(timeTrackPage.verifyApproveTimeTrackPageTitle(),"Approve Time Track page title is not loaded");
		timeTrackPage.getNonRejectedTimeTrack();
		driver.navigate().refresh();
		Assert.assertTrue(timeTrackPage.verifyApproveTimeTable(),"Approve Time Track table is not loaded");
		Assert.assertTrue(timeTrackPage.verifyUserNameListCount(),"Empty users in Approve time track table");
		timeTrackPage.selectFirstUserCheckBox();
		timeTrackPage.clickTimeTrackRejectBtn();
		driver.navigate().refresh();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
