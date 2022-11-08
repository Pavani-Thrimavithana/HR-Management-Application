package com.hrm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;
import org.apache.log4j.Logger;

public class ReportsPage extends TestBase {

//	Page Factory Object Repository
    @FindBy(xpath = "//*[@class='pagetitle'][text() = \"Reports Dashboard\"]")
    WebElement reportMainPageTitle;
    
    @FindBy(xpath = "//*[@id='reportConfig_119']")
    WebElement pastMonthsLeaveReportContainer;
    
    @FindBy(xpath = "//*[@id='reportConfig_90']")
    WebElement attendanceReportContainer;
    
    @FindBy(xpath = "//*[@class='reportName']")
    WebElement reportName;
    
    @FindBy(xpath = "//*[@id='closeCreateChartLightboxButton']")
    WebElement createCharCancelBtn;
    
    @FindBy(xpath = "//*[@id='createChartLightbox_content']")
    WebElement createChartLightboxContent;
    
    @FindBy(xpath = "//div[@class='reportNameWrapper']/div[@class='reportName']")
    WebElement reportTitle;
	
    public static Logger logger = Logger.getLogger(ReportsPage.class);
    
//	initializing the Page Objects
	public ReportsPage(){
		PageFactory.initElements(driver, this);
	}
	
//	methods
    @SuppressWarnings("deprecation")
	public Boolean verifyReportPageTitle() {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS) ;
        return reportMainPageTitle.isDisplayed();
    }
    public Boolean verifyLeaveChartIsDisplayed() {
        return pastMonthsLeaveReportContainer.isDisplayed();
    }
    @SuppressWarnings("deprecation")
	public void clickPastMonthLeaveReport() {
    	logger.info("Clicking past Months Leave Chart Section-----");
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS) ;
        pastMonthsLeaveReportContainer.click();
    }
    @SuppressWarnings("deprecation")
	public String getReportName() {
    	logger.info("get Report Name-----");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
            return reportTitle.getText();

    }
    @SuppressWarnings("deprecation")
	public void clickAttendanceReport() {
    	logger.info("Clicking Attendance Chart Section-----");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
        attendanceReportContainer.click();
    }
    @SuppressWarnings("deprecation")
	public void clickCreateChartCancelBtn() {
    	logger.info("Clicking cancel button-----");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
        createCharCancelBtn.click();
    }
}
