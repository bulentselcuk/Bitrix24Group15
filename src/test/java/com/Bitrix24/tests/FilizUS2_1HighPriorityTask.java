package com.Bitrix24.tests;

import com.Bitrix24.pages.ActiveStreamPage;
import com.Bitrix24.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FilizUS2_1HighPriorityTask extends TestBase {


    @Test(description = "User should be able to click on 'High Priority' checkbox to set to current task to a top priority task",dataProvider = "credentialsUsers")
    public void highPriority(String userName,String password)  {
        extentTest = extentReports.createTest("User should be able to click on High Priority checkbox." );
        ActiveStreamPage activeStreamPage = new ActiveStreamPage();
        LoginPage loginPage=new LoginPage();
        loginPage.login(userName,password,false);
        wait.until(ExpectedConditions.visibilityOf(activeStreamPage.taskLink));
        wait.until(ExpectedConditions.elementToBeClickable(activeStreamPage.taskLink));
        activeStreamPage.taskLink.click();
        wait.until(ExpectedConditions.visibilityOf(activeStreamPage.highPriorityCheckbox));
        wait.until(ExpectedConditions.elementToBeClickable(activeStreamPage.highPriorityCheckbox));
        activeStreamPage.highPriorityCheckbox.click();
        Assert.assertTrue(activeStreamPage.highPriorityCheckbox.isSelected());

    }

    @DataProvider
    public Object[][] credentialsUsers()
    {
        return new Object[][]{
                {"helpdesk53@cybertekschool.com","UserUser"},
                {"hr53@cybertekschool.com","UserUser"},
                {"marketing53@cybertekschool.com","UserUser"}
        };
    }

}
