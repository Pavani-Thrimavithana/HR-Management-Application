package com.hrm.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class UsersPage extends TestBase {
	
//	Page Factory Object Repository
    @FindBy(xpath = "//table[contains(@class,'userListTable canEditUsers')]")
    WebElement userTable;
    
    @FindBy(className = "userListRow")
    List<WebElement> userProfilesList;
    
    @FindBy(xpath = "//*[@class='pagetitle']//span[text() = \"List of Users\"]")
    WebElement pageTitle;
	
//	initializing the Page Objects
	public UsersPage(){
		PageFactory.initElements(driver, this);
	}
	
//	methods	
    @SuppressWarnings("deprecation")
	public Boolean verifyUserPageTitle() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        return pageTitle.isDisplayed();
    }
    
    @SuppressWarnings("deprecation")
	public Boolean verifyUserProfilesTable() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return userTable.isDisplayed();
    }
    
    public Boolean verifyUsersListCount() {
        if (userProfilesList.size() == 0)
        {
            return false;
        }
        else {
            return true;
        }
    }
}
