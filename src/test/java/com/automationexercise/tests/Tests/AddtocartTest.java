package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.DriverFactory;
import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.CartPage;
import com.automationexercise.Pages.ProductsPage;
import com.automationexercise.Utilities.DataUtils;
import com.automationexercise.Utilities.Utility;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddtocartTest {


    @BeforeMethod
    public void setup(){
        DriverFactory.createInstance(DataUtils.getEnvironmentPropertyValue("BROWSER"));
        Utility.openWebsite(DataUtils.getEnvironmentPropertyValue("BASE_URL"));
    }
    @Test
    public void TC01_addToCart(){
        new SoftAssert().assertTrue(new HomePage().verifyHomePageVisability());
        new CartPage().productsNavbarClick();
        new ProductsPage()
                .hoverOnBlueTopItemElement()
                .bluetopddtoCartclick()
                .continueShoppingButtonClick();
        new ProductsPage()
                .hoverOnmenTshirtItemItemElement()
                .menTshirtAddtocartClick()
                .continueShoppingButtonClick()
                .cartNavbarElementClick();
        new SoftAssert().assertTrue(new CartPage().isBlueTopWomenItemExists());
        new SoftAssert().assertTrue(new CartPage().isMenShirtItemExists());
        new SoftAssert().assertTrue(new CartPage().getBlueTopWomenElementIntegerPrice()==500 );
        new SoftAssert().assertTrue(new CartPage().getMenShirtElementIntegerPrice()==400);
        new SoftAssert().assertTrue(new CartPage().getBlueTopWomenElementIntegerQuantity()==1);
        new SoftAssert().assertTrue(new CartPage().getMenShirtElementIntegerQuantity()==1);
        new SoftAssert().assertTrue(new CartPage().getBlueTopElementIntegerTotalPrice() == new CartPage().getBlueTopWomenElementIntegerQuantity() * new CartPage().getBlueTopWomenElementIntegerPrice() );
        new SoftAssert().assertTrue(new CartPage().getMenShirtElementIntegerTotalPrice() == new CartPage().getMenShirtElementIntegerQuantity() * new CartPage().getMenShirtElementIntegerPrice());

        new SoftAssert().assertAll();
    }//end method TC01_addToCart()

    @AfterMethod
    public void quitDriver(){
        DriverManager.quit();
    }

}//end class AddtocartTest
