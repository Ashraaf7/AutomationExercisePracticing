package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.DriverFactory;
import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.P02_HomePage;
import com.automationexercise.Utilities.DataUtils;
import com.automationexercise.Utilities.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.automationexercise.DriverManager.DriverManager.getDriver;

public class TC26_ScrollWithoutArrowButtonTest {

    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down page to bottom
5. Verify 'SUBSCRIPTION' is visible
6. Click on arrow at bottom right side to move upward
7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
 */
    @BeforeMethod
    public void setUp() {
        DriverFactory.createInstance(DataUtils.getEnvironmentPropertyValue("BROWSER"));
        Utility.openWebsite(DataUtils.getEnvironmentPropertyValue("BASE_URL"));
    }


    @Test
    public void verifyScrollDown() {
        new P02_HomePage(getDriver()).scrollToBottom();
        new P02_HomePage(getDriver()).verifyScrollDown();
    }

    @Test
    public void verifyScrollUp() {
        new P02_HomePage(getDriver()).scrollToBottom().
                pressScrollUpButton().verifyScrollUp();


    }

    //Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality
    @Test
    public void ScrollWithoutArrowButton() {
        new P02_HomePage(getDriver()).
                scrollToBottom().
                verifyScrollDown().
                scrollToUpWithOutArrowButton().
                verifyScrollUp();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quit();
    }
}

