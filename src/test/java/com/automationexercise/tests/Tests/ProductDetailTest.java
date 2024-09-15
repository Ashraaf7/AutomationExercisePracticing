package com.automationexercise.tests.Tests;

import com.automationexercise.Pages.HomePage;
import com.automationexercise.Pages.ProductDetailPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.automationexercise.DriverManager.DriverFactory.createInstance;
import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.DriverManager.DriverManager.quit;
import static com.automationexercise.Utilities.DataUtils.getJsonData;
import static com.automationexercise.Utilities.Utility.VerifyURL;
import static com.automationexercise.Utilities.Utility.openWebsite;

public class ProductDetailTest {
    String BASE_URL = getJsonData("data","PRODUCTDETAILSPAGE");
    @Test
    public void homePageTest() throws InterruptedException {
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(BASE_URL);
        Assert.assertEquals(getDriver().getCurrentUrl(), BASE_URL);
        new ProductDetailPage(getDriver())
                .changeQuantity(4)
                .addToCart()
                .clickViewCart();

        Thread.sleep(2000);
    }
}
