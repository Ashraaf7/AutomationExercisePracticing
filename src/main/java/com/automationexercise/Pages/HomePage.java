package com.automationexercise.Pages;

import com.automationexercise.Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.automationexercise.Utilities.Utility.clicking;
import static com.automationexercise.Utilities.Utility.verifyElementVisible;


public class HomePage {

    private final WebDriver driver;
    private final By testcasebtn_ele = By.xpath("(//a[@href=\"/test_cases\"])[1]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public TestCasesPage clickOnTestCases() {
        clicking(driver, testcasebtn_ele);
        return new TestCasesPage(driver);
    }

    public boolean isHomePageVisible() {
        verifyElementVisible(testcasebtn_ele);
        return true;
    }
}
