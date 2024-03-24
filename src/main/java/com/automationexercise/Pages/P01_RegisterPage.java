package com.automationexercise.Pages;

import com.automationexercise.Utilities.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.automationexercise.Utilities.Utility.*;

public class P01_RegisterPage {

    //constructor
    private final WebDriver driver;
    private final By signupLoginButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private final By name = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
    private final By email = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
    private final By signupButton = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
    private final By newUserSignupMessage = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
    private final By errorMsg = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p");

    public P01_RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Action
    public P01_RegisterPage clickOnSignupLoginButton() {
        clicking(driver, signupLoginButton);
        return this;
    }


    public P01_RegisterPage enterSignupInfo(String nameParam, String emailParam) {
        sendData(driver, this.name, nameParam);
        LogUtils.info("Name: " + nameParam);
        sendData(driver, this.email, emailParam);
        LogUtils.info("Email: " + emailParam);
        return this;
    }

    public P01_RegisterPage clickOnSignupButton() {
        clicking(driver, signupButton);
        return this;
    }

    //Validations
    public boolean verifyThatErrorMessageAppears(String expectedText) {
        return verifyEquals(errorMsg, expectedText);

    }

    public boolean verifyThatNewUserSignupAppears(String expectedText) {
        return verifyEquals(newUserSignupMessage, expectedText);
    }

}
