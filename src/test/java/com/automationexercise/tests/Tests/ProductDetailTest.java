package com.automationexercise.tests.Tests;

import com.automationexercise.Pages.HomePage;
import com.automationexercise.Pages.ProductDetailPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.automationexercise.DriverManager.DriverFactory.createInstance;
import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.DriverManager.DriverManager.quit;
import static com.automationexercise.Utilities.Utility.openWebsite;

public class ProductDetailTest {
    @Test
    public void homePageTest() throws InterruptedException {
    new ProductDetailPage(getDriver())
            .changeQuantity(4)
            .addToCart();
    Thread.sleep(2000);
    }
}
