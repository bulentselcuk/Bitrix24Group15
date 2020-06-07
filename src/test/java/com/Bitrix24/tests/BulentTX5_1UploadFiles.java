package com.Bitrix24.tests;

import com.Bitrix24.pages.ActiveStreamPage;
import com.Bitrix24.pages.LoginPage;
import com.Bitrix24.utilities.BrowserUtilities;
import com.Bitrix24.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BulentTX5_1UploadFiles extends TestBase {

    @Test(description=" User should be able to click upload files.")
    public void uploadTest() throws InterruptedException {
        extentTest=extentReports.createTest ( "User should be able to click upload files." );
        LoginPage loginPage=new LoginPage ();
        loginPage.login ();
        ActiveStreamPage activeStreamPage=new ActiveStreamPage ();
        activeStreamPage.sendMessageInput.click ();
        WebDriverWait wait=new WebDriverWait ( Driver.getDriver (), 10 );
        wait.until ( ExpectedConditions.visibilityOf ( activeStreamPage.upload ) );
        wait.until ( ExpectedConditions.elementToBeClickable ( activeStreamPage.upload ) );
        activeStreamPage.upload.click ();
        BrowserUtilities.wait ( 4 );
        extentTest.pass("upload button has clicked!");

    }
}