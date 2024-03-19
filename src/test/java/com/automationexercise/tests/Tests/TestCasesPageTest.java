package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.BrowserFactory;
import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.HomePage;
import com.automationexercise.Pages.TestCasesPage;
import com.automationexercise.Utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.automationexercise.DriverManager.DriverFactory.createInstance;
import static com.automationexercise.DriverManager.DriverManager.*;
import static com.automationexercise.Utilities.Utility.openWebsite;

public class TestCasesPageTest  {
    WebDriver driver = BrowserFactory.CHROME.createDriver();
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        /*createInstance("chrome");
        openWebsite("https://automationexercise.com/");*/
        driver.get("https://automationexercise.com/");
    }
    @Test
    public void VerifyTestCasesPage() {
        Assert.assertTrue(new HomePage(driver).isHomePageVisible(), "Home page is not visible");

        new HomePage(driver).clickOnTestCases();

        Assert.assertTrue(new TestCasesPage(driver).isTestCasesPageVisible(), "Test cases page is not visible");
    }
    @AfterMethod
    public void tearDown() {
        setDriver(driver);
        quit();
    }
}