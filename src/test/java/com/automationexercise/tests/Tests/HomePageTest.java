package com.automationexercise.tests.Tests;


import com.automationexercise.Pages.P01_HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.automationexercise.DriverManager.DriverFactory.createInstance;
import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.DataUtils.getJsonData;
import static com.automationexercise.Utilities.Utility.openWebsite;

public class HomePageTest {
    @BeforeTest
    public void setUp()
    {
        createInstance("chrome");
        openWebsite("https://automationexercise.com/");
    }
    @Test
    public void homePageTest()
    {
        String expectedUrl=getJsonData("data","url");
        Assert.assertTrue( new P01_HomePage(getDriver()).checkCurrentUrl(expectedUrl));
        new P01_HomePage(getDriver()).clickContactUs();
    }
    @AfterTest
    public void tearDown()
    {
        getDriver().quit();
    }


}
