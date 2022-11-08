package com.hrm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

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
	
//	initializing the Page Objects
	public ReportsPage(){
		PageFactory.initElements(driver, this);
	}
	
//	methods
    @SuppressWarnings("deprecation")
	public Boolean verifyReportPageTitle() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
        return reportMainPageTitle.isDisplayed();
    }
    public Boolean verifyLeaveChartIsDisplayed() {
        return pastMonthsLeaveReportContainer.isDisplayed();
    }
    @SuppressWarnings("deprecation")
	public void clickPastMonthLeaveReport() {
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS) ;
        pastMonthsLeaveReportContainer.click();
    }
    @SuppressWarnings("deprecation")
	public String getReportName() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
            return reportTitle.getText();

    }
    @SuppressWarnings("deprecation")
	public void clickAttendanceReport() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
        attendanceReportContainer.click();
    }
    @SuppressWarnings("deprecation")
	public void clickCreateChartCancelBtn() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
        createCharCancelBtn.click();
    }
}
