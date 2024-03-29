package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.P01_RegisterPage;
import com.automationexercise.Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.automationexercise.DriverManager.DriverFactory.createInstance;
import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.DataUtils.getEnvironmentPropertyValue;
import static com.automationexercise.Utilities.DataUtils.getJsonData;
import static com.automationexercise.Utilities.Utility.VerifyURL;

public class TC05_RegisterWithExistingEmailTest {
    //JSONObject user = new JSONObject();
    // public final String PASSWORD = getJsonData("registerData", "password");
    private final String NAME = getJsonData("ExistedRegistrationData", "name");
    private final String EMAIL = getJsonData("ExistedRegistrationData", "email");
    private final String SIGNUP_MSG = getJsonData("ExistedRegistrationData", "message");
    private final String ERROR_MSG = getJsonData("ExistedRegistrationData", "error message");

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        createInstance(getEnvironmentPropertyValue("BROWSER"));
        Utility.openWebsite(getEnvironmentPropertyValue("BASE_URL"));
    }

    @Test
    public void RegisterWithExistingEmailPage() {
        Assert.assertTrue(VerifyURL(getDriver(), getEnvironmentPropertyValue("BASE_URL")));

        new P01_RegisterPage(getDriver())
                .clickOnSignupLoginButton();

        Assert.assertTrue(new P01_RegisterPage(getDriver())
                .verifyThatNewUserSignupAppears(SIGNUP_MSG));

        new P01_RegisterPage(getDriver())
                .enterSignupInfo(NAME, EMAIL)
                .clickOnSignupButton();

        Assert.assertTrue(new P01_RegisterPage(getDriver())
                .verifyThatErrorMessageAppears(ERROR_MSG));

    }


    @AfterMethod
    public void quit() {
        DriverManager.quit();
    }

}



