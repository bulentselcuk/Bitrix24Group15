package com.Bitrix24.tests;

import com.Bitrix24.pages.ActiveStreamPage;
import com.Bitrix24.pages.LoginPage;
import com.Bitrix24.utilities.BrowserUtilities;
import com.Bitrix24.utilities.Driver;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.Bitrix24.tests.TestBase.extentReports;

public class MykytaUS1_3AttachingLink extends TestBase{

    @Test(description = " User should be able to attach link by clicking on the link icon.")
    public void attachLink() throws InterruptedException {
        extentTest = extentReports.createTest("User should be able to attach link by clicking on the link icon." );
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        ActiveStreamPage activeStreamPage = new ActiveStreamPage();
        activeStreamPage.sendMessageInput.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(activeStreamPage.linkIcon));
        wait.until(ExpectedConditions.elementToBeClickable(activeStreamPage.linkIcon));
        activeStreamPage.linkIcon.click();

        wait.until(ExpectedConditions.visibilityOf(activeStreamPage.linkLinkText));

        activeStreamPage.linkLinkText.click();
        activeStreamPage.linkLinkText.sendKeys("link is here");
        activeStreamPage.linkLinkUrl.sendKeys("https://login1.nextbasecrm.com/company/vis_structure.php");
        activeStreamPage.linkSaveBtn.click();
        wait.until(ExpectedConditions.visibilityOf(activeStreamPage.sendBtn));
        wait.until(ExpectedConditions.elementToBeClickable(activeStreamPage.sendBtn));
        activeStreamPage.sendBtn.click();

        Assert.assertEquals( Driver.getDriver().findElement(By.xpath("(//a[text()='link is here'])[1]")).getAttribute("href"),"https://login1.nextbasecrm.com/company/vis_structure.php");
    }
}
