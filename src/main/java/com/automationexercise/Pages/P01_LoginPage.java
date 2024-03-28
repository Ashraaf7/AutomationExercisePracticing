package com.automationexercise.Pages;

import com.automationexercise.Utilities.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.automationexercise.Utilities.DataUtils.getEnvironmentPropertyValue;
import static com.automationexercise.Utilities.Utility.*;

public class P01_LoginPage {

    //Driver object
    private final WebDriver driver;
    //Locators
    private final By emailField = By.cssSelector("[data-qa='login-email']");
    private final By passwordField = By.cssSelector("[data-qa='login-password']");
    private final By loginButton = By.cssSelector("[data-qa='login-button']");
    private final By signUpButton = By.cssSelector("a[href=\"/login\"]");

    private final By errorMessage = By.cssSelector("form[action='/login'] > p");

    //Constructor
    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public P01_LoginPage enteringLoginInfo(String email, String password) {
        sendData(driver, emailField, email);
        LogUtils.info("Email: " + email);
        sendData(driver, passwordField, password);
        return this;
    }


    public P01_LoginPage clickOnLoginButton() {
        clicking(driver, loginButton);
        return this;
    }
    public P01_LoginPage clickOnSignUpButton() {
        clicking(driver, signUpButton);
        return this;
    }

    public void navigateToLoginUrl() {
        openWebsite(getEnvironmentPropertyValue("LOGIN_URL"));
    }
    
   //Validations
    public boolean checkErrorMessageText(String expectedText) {
        return verifyEquals(errorMessage, expectedText);
    }


}
