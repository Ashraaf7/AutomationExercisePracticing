package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.DriverFactory;
import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.P02_HomePage;
import com.automationexercise.Pages.P03_SearchProductPage;
import com.automationexercise.Utilities.DataUtils;
import com.automationexercise.Utilities.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.automationexercise.DriverManager.DriverManager.getDriver;

public class TC09_SearchProductTest {
    SoftAssert soft = new SoftAssert();

    /**
     * Sets up the test by creating a new instance of the WebDriver and navigating to the website.
     */
    @BeforeMethod
    public void setUp() {
        DriverFactory.createInstance(DataUtils.getEnvironmentPropertyValue("BROWSER"));
        Utility.openWebsite(DataUtils.getEnvironmentPropertyValue("BASE_URL"));
    }

    /**
     * Tests the search functionality of the website.
     */
    @Test
    public void userSearchForProduct() {
        // navigate to the products page
        new P02_HomePage(getDriver()).pressProductsButton();
        new P02_HomePage(getDriver()).ADS();

        // verify that the user is navigated to the all products page

        soft.assertTrue(new P03_SearchProductPage(getDriver()).VerifyUserNavigatedToAllProductsPage());

        // search for a product
        new P03_SearchProductPage(getDriver()).EnterProduct("T-shirt").PressSearchButton();

        // verify that the searched products section is visible
        soft.assertTrue(new P03_SearchProductPage(getDriver()).VerifySearchedProductsSectionVisible());

        // verify that all the products related to the search are visible
        soft.assertEquals(new P03_SearchProductPage(getDriver()).VerifyAllProductRelatedToSearchVisible(), 3);
        soft.assertAll();
    }

    /**
     * Cleans up the state of the test by quitting the WebDriver instance.
     */
    @AfterMethod
    public void tearDown() {
        DriverManager.quit();
    }
}
