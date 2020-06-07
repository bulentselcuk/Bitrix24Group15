package com.Bitrix24.pages;

import com.Bitrix24.utilities.ConfigurationsReader;
import com.Bitrix24.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "[name='USER_LOGIN']")
    public WebElement usernameInput;
    @FindBy(css = "[name='USER_PASSWORD']")
    public WebElement passwordInput;
    @FindBy(className = "login-btn")
    public WebElement logInBtn;
    @FindBy(id = "USER_REMEMBER")
    public WebElement remember;

    public void login(){
        usernameInput.sendKeys(ConfigurationsReader.getProperty("username"));
        passwordInput.sendKeys(ConfigurationsReader.getProperty("password"));
        logInBtn.click();
    }

    public void login (String username,String password, boolean ifRemember) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        if (ifRemember) {
            remember.click();
        }
        logInBtn.click();

    }
}
