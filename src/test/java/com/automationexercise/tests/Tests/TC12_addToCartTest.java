package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.DriverFactory;
import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.P12_CartPage;
import com.automationexercise.Pages.P03_SearchProductPage;
import com.automationexercise.Utilities.DataUtils;
import com.automationexercise.Utilities.Utility;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.Utility.VerifyURL;

public class TC12_addToCartTest {


    @BeforeMethod
    public void setup(){
        DriverFactory.createInstance(DataUtils.getEnvironmentPropertyValue("BROWSER"));
        Utility.openWebsite(DataUtils.getEnvironmentPropertyValue("BASE_URL"));
    }
    @Test
    public void TC12_addToCart(){
        new SoftAssert().assertTrue(VerifyURL(getDriver(), DataUtils.getEnvironmentPropertyValue("BASE_URL")));
        new P12_CartPage().clickONproductsNavbar();
        new P03_SearchProductPage(getDriver())
                .hoverOnBlueTopItemElement()
                .ClickOnBlueTopAddToCart()
                .clickOnContinuoShoppingButton();
        new P03_SearchProductPage(getDriver())
                .hoverOnmenTshirtItemItemElement()
                .ClickOnMenTshitrtAddTOCart()
                .clickOnContinuoShoppingButton()
                .clickOnCartNavbar();
        new SoftAssert().assertTrue(new P12_CartPage().isBlueTopWomenItemExists());
        new SoftAssert().assertTrue(new P12_CartPage().isMenShirtItemExists());
        new SoftAssert().assertTrue(new P12_CartPage().verifyBlueTopWomenPrice());
        new SoftAssert().assertTrue(new P12_CartPage().verifyMenShirtPrice());
        new SoftAssert().assertTrue(new P12_CartPage().verifyBlueTopWomenQuantity());
        new SoftAssert().assertTrue(new P12_CartPage().verifyMenShirtQuantity());
        new SoftAssert().assertTrue(new P12_CartPage().verifyMenShirtTotlaPrice());
        new SoftAssert().assertTrue(new P12_CartPage().verifyBlueTopWomenTotlaPrice());

        new SoftAssert().assertAll();
    }//end method TC12_addToCart()

    @AfterMethod
    public void tearDown(){
        DriverManager.quit();
    }

}//end class AddtocartTest
