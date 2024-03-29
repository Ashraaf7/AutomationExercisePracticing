package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.DriverFactory;
import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.CartPage;
import com.automationexercise.Pages.P02_HomePage;
import com.automationexercise.Pages.ProductsPage;
import com.automationexercise.Utilities.DataUtils;
import com.automationexercise.Utilities.Utility;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.Utility.VerifyURL;

public class AddtocartTest {


    @BeforeMethod
    public void setup(){
        DriverFactory.createInstance(DataUtils.getEnvironmentPropertyValue("BROWSER"));
        Utility.openWebsite(DataUtils.getEnvironmentPropertyValue("BASE_URL"));
    }
    @Test
    public void TC01_addToCart(){
        new SoftAssert().assertTrue(VerifyURL(getDriver(), DataUtils.getEnvironmentPropertyValue("BASE_URL")));
        new P02_HomePage(getDriver()).ADS();
        new CartPage().productsNavbarClick();
        new ProductsPage()
                .hoverOnBlueTopItemElement()
                .ClickOnBlueTopAddToCart()
                .clickOnContinuoShoppingButton();
        new ProductsPage()
                .hoverOnmenTshirtItemItemElement()
                .ClickOnMenTshitrtAddTOCart()
                .clickOnContinuoShoppingButton()
                .clickOnCartNavbar();
        new SoftAssert().assertTrue(new CartPage().isBlueTopWomenItemExists());
        new SoftAssert().assertTrue(new CartPage().isMenShirtItemExists());
        /*new SoftAssert().assertTrue(new CartPage().getBlueTopWomenElementIntegerPrice()==500 );
        new SoftAssert().assertTrue(new CartPage().getMenShirtElementIntegerPrice()==400);
        new SoftAssert().assertTrue(new CartPage().getBlueTopWomenElementIntegerQuantity()==1);
        new SoftAssert().assertTrue(new CartPage().getMenShirtElementIntegerQuantity()==1);
        new SoftAssert().assertTrue(new CartPage().getBlueTopElementIntegerTotalPrice() == new CartPage().getBlueTopWomenElementIntegerQuantity() * new CartPage().getBlueTopWomenElementIntegerPrice() );
        new SoftAssert().assertTrue(new CartPage().getMenShirtElementIntegerTotalPrice() == new CartPage().getMenShirtElementIntegerQuantity() * new CartPage().getMenShirtElementIntegerPrice());
         */
        new SoftAssert().assertAll();
    }//end method TC01_addToCart()

    @AfterMethod
    public void quitDriver(){
        DriverManager.quit();
    }

}//end class AddtocartTest
