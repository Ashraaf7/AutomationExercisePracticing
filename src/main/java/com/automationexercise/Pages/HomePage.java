package com.automationexercise.Pages;

import com.automationexercise.Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.automationexercise.Utilities.Utility.clicking;
import static com.automationexercise.Utilities.Utility.verifyElementVisible;


public class HomePage {

    private final WebDriver driver;
    private final By testCaseButton = By.xpath("(//a[@href=\"/test_cases\"])[1]");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage clickOnTestCases() {
        clicking(driver, testCaseButton);
        return this;
    }
    public boolean isHomePageVisible() {
        return verifyElementVisible(testCaseButton);
    }
}
