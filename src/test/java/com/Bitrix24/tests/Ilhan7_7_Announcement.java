package com.Bitrix24.tests;

import com.Bitrix24.pages.ActiveStreamPage;
import com.Bitrix24.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Ilhan7_7_Announcement extends TestBase {

    @Test(description = "User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.",dataProvider = "credentialsUsers")
    public void VisualEditor(String username,String password){
       extentTest=extentReports.createTest("User is clicking on Visual Editor and text-bar should display");
        ActiveStreamPage activeStreamPage=new ActiveStreamPage();
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password,false);
        activeStreamPage.More.click();
        wait.until(ExpectedConditions.visibilityOf(activeStreamPage.Announcement));
        activeStreamPage.Announcement.click();
        wait.until(ExpectedConditions.visibilityOf(activeStreamPage.Visual_Editor));
        activeStreamPage.Visual_Editor.click();
        wait.until(ExpectedConditions.visibilityOf(activeStreamPage.text_bar));
        Assert.assertTrue(activeStreamPage.text_bar.isDisplayed());

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




