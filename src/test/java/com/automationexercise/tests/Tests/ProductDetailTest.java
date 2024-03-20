package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.ProductDetailPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.automationexercise.DriverManager.DriverFactory.createInstance;
import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.DataUtils.getEnvironmentPropertyValue;
import static com.automationexercise.Utilities.DataUtils.getJsonData;
import static com.automationexercise.Utilities.Utility.openWebsite;

public class ProductDetailTest {

    private final String productName = getJsonData("productDetails", "proName");
    private final String productCategory = getJsonData("productDetails", "proCategory");
    private final String productPrice = getJsonData("productDetails", "proPrice");
    private final String productAvailability = getJsonData("productDetails", "proAvailability");

    @BeforeMethod
    public void setUp()
    {
        createInstance(getEnvironmentPropertyValue("BROWSER"));
        openWebsite("https://automationexercise.com/products");
        new ProductDetailPage(getDriver()).openProductDetailPage();
    }

    @Test
    public void verifyProductDetails()
    {
        Assert.assertTrue(new ProductDetailPage(getDriver()).CheckProductName(productName));
        Assert.assertTrue(new ProductDetailPage(getDriver()).CheckProductCategory(productCategory));
        Assert.assertTrue(new ProductDetailPage(getDriver()).CheckProductPrice(productPrice));
        Assert.assertTrue(new ProductDetailPage(getDriver()).CheckProductAvailability(productAvailability));
    }

    @AfterMethod
    public void quit()
    {
        DriverManager.quit();
    }
}
