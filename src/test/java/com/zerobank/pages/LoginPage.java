package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement signInBtn;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submit;

    @FindBy(css = ".alert.alert-error")
    public WebElement errorAlert;

    public void login(String userNameStr, String passwordStr){

        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();

    }

}
