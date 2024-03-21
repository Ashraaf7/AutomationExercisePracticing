package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.DriverFactory;
import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.HomePage;
import com.automationexercise.Utilities.Utility;
import com.automationexercise.Utilities.WaitsUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import static com.automationexercise.DriverManager.DriverFactory.createInstance;
import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.DriverManager.DriverManager.quit;
import static com.automationexercise.Utilities.Utility.openWebsite;

public class HomePageTest {

    private HomePage homePage;
    @BeforeTest
    public void setUp() {
        createInstance("chrome");
        openWebsite("https://www.automationexercise.com/");
    }
    @AfterTest
    public void tearDown() {quit();}
    @Test
    public void homePageTest() {
        new HomePage(getDriver()).isHomePagePresent();new HomePage(getDriver()).click2ndProduct();
    }
}
