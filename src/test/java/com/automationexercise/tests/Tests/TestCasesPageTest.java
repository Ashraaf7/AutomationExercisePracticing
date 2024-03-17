package com.automationexercise.tests.Tests;

import com.automationexercise.Pages.HomePage;
import com.automationexercise.Pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCasesPageTest extends BaseTest {
    HomePage homePage;
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void VerifyTestCasesPage() {
        homePage = new HomePage(driver);
        softAssert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        homePage.ClickOnTestCases();

        TestCasesPage testCasesPage = new TestCasesPage(driver);
        softAssert.assertTrue(testCasesPage.isTestCasesPageVisible(), "Test cases page is not visible");




    }
}
