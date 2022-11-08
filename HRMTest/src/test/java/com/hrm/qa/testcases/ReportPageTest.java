package com.hrm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.ReportsPage;

public class ReportPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ReportsPage reportPage;
	
	public ReportPageTest() {
		super();
		
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		reportPage = new ReportsPage();


	}
	
	@Test
	public void reportsLinkTest() {
		SoftAssert softAssert= new SoftAssert();
		homePage.clickOnReportsTab();
		softAssert.assertTrue(reportPage.verifyReportPageTitle(),"Cannot find the Reports section page title");
		softAssert.assertTrue(reportPage.verifyLeaveChartIsDisplayed(),"Cannot find the Leave Chart in Reports section");
		
		reportPage.clickPastMonthLeaveReport();
		softAssert.assertEquals(reportPage.getReportName(),"Chart: Past Month's Leaves","Incorrect report name is displayed");
		
		reportPage.clickCreateChartCancelBtn();

		reportPage.clickAttendanceReport();
		softAssert.assertEquals(reportPage.getReportName(),"Scheduled vs. Worked Hours+Overtime","Incorrect report name is displayed");
		softAssert.assertAll();

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
