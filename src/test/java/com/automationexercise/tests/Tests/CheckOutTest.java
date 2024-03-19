package com.automationexercise.tests.Tests;

import com.automationexercise.Pages.CheckOutPage;
import com.automationexercise.Pages.ProductDetailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.automationexercise.DriverManager.DriverManager.getDriver;

public class CheckOutTest {
    @Test
    public void homePageTest() throws InterruptedException {
        String quantity = new CheckOutPage(getDriver()).checkOutQuantity();
        Assert.assertEquals(quantity,4);
        Thread.sleep(2000);
    }
}
