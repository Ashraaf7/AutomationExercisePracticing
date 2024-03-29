package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.P01_RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.automationexercise.DriverManager.DriverFactory.createInstance;
import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.DataUtils.*;
import static com.automationexercise.Utilities.Utility.getTimestamp;

public class TC01_RegisterTest {

    private final String emailTimestamp = getJsonData("RegisterNewUser", "emailTimestamp") + getTimestamp() + "@gmail.com";
    private final String fullNameRegister = getJsonValue("RegisterNewUser", "userData.fullNameRegister");


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        createInstance(getEnvironmentPropertyValue("BROWSER"));
        new P01_RegisterPage(getDriver()).navigateToRegisterPage();
    }

    @Test
    public void RegisterSuccess() {
        new P01_RegisterPage(getDriver())
                .clickOnSignupLoginButton()
                .enterSignupInfo(fullNameRegister, emailTimestamp)
                .clickOnSignupButton()
                .fillUserRegistrationForm(getJsonValue("RegisterNewUser", "userData.password"),
                        getJsonValue("RegisterNewUser", "userData.firstNameInput"),
                        getJsonValue("RegisterNewUser", "userData.lastNameInput"),
                        getJsonValue("RegisterNewUser", "userData.daysSelect"),
                        getJsonValue("RegisterNewUser", "userData.monthsSelect"),
                        getJsonValue("RegisterNewUser", "userData.yearsSelect"),
                        getJsonValue("RegisterNewUser", "userData.companyNameInputField"),
                        getJsonValue("RegisterNewUser", "userData.addressOneInput"),
                        getJsonValue("RegisterNewUser", "userData.addressTwwInput"),
                        getJsonValue("RegisterNewUser", "userData.countrySelect"),
                        getJsonValue("RegisterNewUser", "userData.stateInput"),
                        getJsonValue("RegisterNewUser", "userData.cityInput"),
                        getJsonValue("RegisterNewUser", "userData.zipcodeInput"),
                        getJsonValue("RegisterNewUser", "userData.mobileNumberInput"))

                .createAccount();

        Assert.assertTrue(new P01_RegisterPage(getDriver()).checkSuccessMessageAccountCreated("ACCOUNT CREATED!"));
    }


    @AfterMethod
    public void quit() {
        DriverManager.quit();
    }

}



