package com.Bitrix24.tests;

import com.Bitrix24.pages.ActiveStreamPage;
import com.Bitrix24.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Yusuf_1_6_AddMention extends TestBase {
    @Test(description = "User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.")
    public void addMention() {
        extentTest = extentReports.createTest("User clicking add mention icon and select contacts from list.");
        ActiveStreamPage activeStreamPage = new ActiveStreamPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        activeStreamPage.sendMessageInput.click();
        wait.until(ExpectedConditions.visibilityOf(activeStreamPage.addMentionIcon));
        activeStreamPage.addMentionIcon.click();
        wait.until(ExpectedConditions.elementToBeClickable(activeStreamPage.employeesAndDepartments));
        activeStreamPage.employeesAndDepartments.click();
        wait.until(ExpectedConditions.elementToBeClickable(activeStreamPage.firstContact));
        String actualFirstContact = activeStreamPage.firstContact.getText();
        activeStreamPage.firstContact.click();
        activeStreamPage.addMentionIcon.click();
        wait.until(ExpectedConditions.elementToBeClickable(activeStreamPage.employeesAndDepartments));
        activeStreamPage.employeesAndDepartments.click();
        wait.until(ExpectedConditions.elementToBeClickable(activeStreamPage.secondContact));
        String actualSecondContact = activeStreamPage.secondContact.getText();
        activeStreamPage.secondContact.click();


        String expectedFirstContact = activeStreamPage.firstContactIntoMentionBox.getText();
        String expectedSecondContact = activeStreamPage.secondContactIntoMentionBox.getText();

        Assert.assertEquals(expectedFirstContact, actualFirstContact);
        Assert.assertEquals(expectedSecondContact, actualSecondContact);
    }
}
