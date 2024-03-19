package com.automationexercise.Pages;

import com.automationexercise.DriverManager.BrowserFactory;
import com.automationexercise.Utilities.WaitsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.automationexercise.Utilities.Utility.verifyElementVisible;

public class TestCasesPage {
    private final WebDriver driver;
    private final By verification_ele =  By.xpath("//*[@id=\"form\"]/div/div[2]/h5/span");

    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isTestCasesPageVisible() {
        verifyElementVisible(verification_ele);
        return true;
    }
}