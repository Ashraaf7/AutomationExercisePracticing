package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.BrowserFactory;
import com.automationexercise.Pages.HomePage;
import com.automationexercise.Pages.TestCasesPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.automationexercise.DriverManager.DriverFactory.createInstance;
import static com.automationexercise.DriverManager.DriverManager.*;
import static com.automationexercise.Utilities.Utility.openWebsite;

public class TestCasesPageTest  {
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        createInstance("chrome");
        openWebsite("https://automationexercise.com/");
    }
    @Test
    public void verifyTestCasesPage() {
        WebDriver driver = getDriver();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(new HomePage(driver).isHomePageVisible(), "Home page is not visible");

        new HomePage(driver).clickOnTestCases();

        softAssert.assertTrue(new TestCasesPage(driver).isTestCasesPageVisible(), "Test cases page is not visible");

        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown() {
        quit();
    }
}