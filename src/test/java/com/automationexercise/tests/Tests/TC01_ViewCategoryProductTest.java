package com.automationexercise.tests.Tests;

import com.automationexercise.Pages.P001_ViewCategoryProductPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC01_ViewCategoryProductTest {
    protected WebDriver driver;

    P001_ViewCategoryProductPage viewCategoryProductPage;

    @BeforeMethod
    public void setUp() {
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");
    }

    @Test
    public void categoryProduct() throws InterruptedException {
        viewCategoryProductPage = new P001_ViewCategoryProductPage(driver);

        //scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,275)");


        //Verify that categories are visible on left side bar
        Assert.assertTrue(viewCategoryProductPage.assertVisibleCategoryProducts().isDisplayed());

        //Click on 'Women' category
        viewCategoryProductPage.clickOnCategory("Women").click();

        //Click on any category 'Women' category, for example: Dress
        viewCategoryProductPage.clickOnDressItem().click();

        //Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS
        Assert.assertEquals("WOMEN - DRESS PRODUCTS", viewCategoryProductPage.assertTextCategoryWom().getText(), "care from space");

        //On left side bar, click on any sub-category link of 'Men' category
        viewCategoryProductPage.clickOnCategory("Men").click();

        viewCategoryProductPage.clickOnTShirtItem().click();
        Assert.assertEquals("MEN - TSHIRTS PRODUCTS", viewCategoryProductPage.assertTextCategoryMen().getText(), "care from space");


    }


    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
