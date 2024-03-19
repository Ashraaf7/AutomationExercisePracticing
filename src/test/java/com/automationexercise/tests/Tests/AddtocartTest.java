package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.DriverFactory;
import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.CartPage;
import com.automationexercise.Pages.HomePage;
import com.automationexercise.Pages.ProductsPage;
import com.automationexercise.Utilities.DataUtils;
import com.automationexercise.Utilities.Utility;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddtocartTest {
    SoftAssert softAssert = new SoftAssert();
    CartPage cart = new CartPage();
    HomePage home = new HomePage();
    ProductsPage productsPage = new ProductsPage();
    @BeforeMethod
    public void openUrlAndLogin(){
        DriverFactory.createInstance("edge");
        Utility.openWebsite(DataUtils.getEnvironmentPropertyValue("BASE_URL"));
    }
    @Test
    public void navigateToUrl(){
        softAssert.assertTrue(home.verifyHomePageVisability());
        cart.productsNavbarClick();
        productsPage.hoverOnBlueTopItemElement();
        productsPage.bluetopddtoCartclick();
        productsPage.continueShoppingButtonClick();
        productsPage.hoverOnmenTshirtItemItemElement();
        productsPage.menTshirtAddtocartClick();
        productsPage.continueShoppingButtonClick();
        cart.cartNavbarClick();
        softAssert.assertTrue(cart.isBlueTopWomenItemExists());
        softAssert.assertTrue(cart.isMenShirtItemExists());
        softAssert.assertTrue( cart.getBlueTopWomenElementIntegerPrice()==500 );
        softAssert.assertTrue( cart.getMenShirtElementIntegerPrice()==400);
        softAssert.assertTrue(cart.getBlueTopWomenElementIntegerQuantity()==1);
        softAssert.assertTrue(cart.getMenShirtElementIntegerQuantity()==1);
        softAssert.assertTrue(cart.getBlueTopElementIntegerTotalPrice() == cart.getBlueTopWomenElementIntegerQuantity() * cart.getBlueTopWomenElementIntegerPrice() );
        softAssert.assertTrue(cart.getMenShirtElementIntegerTotalPrice() == cart.getMenShirtElementIntegerQuantity() * cart.getMenShirtElementIntegerPrice());

        softAssert.assertAll();
    }

    @AfterMethod
    public void quitDriver(){
        DriverManager.quit();
    }


}
