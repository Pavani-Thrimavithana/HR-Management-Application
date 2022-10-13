package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class HomePage extends TestBase {
	
//	Page Factory Object Repository 
	@FindBy(xpath = "//div[@id='logo_aT']")
	WebElement logo;
	
	@FindBy(xpath = "//a[@id='logoutLink']")
	WebElement logout;
	
	@FindBy(xpath = "//a[contains(text(),'John')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[@class='content users']")
	WebElement usersTab;
	
	@FindBy(xpath = "//a[@class='content reports']")
	WebElement reportsTab;
	
	@FindBy(xpath = "//a[@class='content tasks']")
	WebElement tasksTab;
	
	@FindBy(xpath = "//a[@class='content selected tt']")
	WebElement timeTrackTab;
	
	@FindBy(xpath = "//div[@class='popup_menu_button popup_menu_button_calendar']//div[@class='popup_menu_icon']//*[name()='svg']")
	WebElement calendar;
	
	@FindBy(xpath = "//div[@class='popup_menu_button popup_menu_button_settings']//div[@class='popup_menu_icon']//*[name()='svg']")
	WebElement settings;
	
	@FindBy(xpath = "//div[@id='popup_menu_button_addons']//div[@class='popup_menu_icon']//*[name()='svg']")
	WebElement interactions;
	
	@FindBy(xpath = "//div[@class='popup_menu_button popup_menu_button_support']//div[@class='popup_menu_icon']")
	WebElement support;
	
//	initializing the Page Objects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
//	methods
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateHRMImage(){
		return logo.isDisplayed();
	}
	
	public boolean validateLogonUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public UsersPage clickOnUserTab(){
		usersTab.click();
		return new UsersPage();
	}
	
	public ReportsPage clickOnReportsTab(){
		reportsTab.click();
		return new ReportsPage();
	}
	
	public TasksPage clickOnTasksTab(){
		tasksTab.click();
		return new TasksPage();
	}
}
