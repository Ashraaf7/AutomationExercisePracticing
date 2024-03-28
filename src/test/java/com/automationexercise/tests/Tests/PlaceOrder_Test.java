package com.automationexercise.tests.Tests;
import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.P01_LoginPage;
import com.automationexercise.Pages.PlaceOrder_Page;
import com.automationexercise.apis.ApiService;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.automationexercise.DriverManager.DriverFactory.createInstance;
import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.DataUtils.*;
import static com.automationexercise.Utilities.Utility.getTimestamp;
import static com.automationexercise.Utilities.Utility.openWebsite;
public class PlaceOrder_Test {
    private final String email = getJsonData("userdata", "email") + getTimestamp() + "@gmail.com"; //ahmedashraf09@gmail
    private final String password = getJsonData("userdata", "password");
    private final String name = getJsonData("userdata", "name");
    private final String firstname = getJsonData("userdata", "firstname");
    private final String lastname = getJsonData("userdata", "lastname");
    private final String company = getJsonData("userdata", "company");
    private final String address1 = getJsonData("userdata", "address1");
    private final String country = getJsonData("userdata", "country");
    private final String zipcode = getJsonData("userdata", "zipcode");
    private final String state = getJsonData("userdata", "state");
    private final String city = getJsonData("userdata", "city");
    private final String mobile_number = getJsonData("userdata", "mobile_number");


    @BeforeMethod
    public void setup()
    {
        createInstance(getEnvironmentPropertyValue("BROWSER"));
        openWebsite(getEnvironmentPropertyValue("BASE_URL"));
        //Verify that home page is visible successfully
        Assert.assertTrue(new PlaceOrder_Page(getDriver()).checkHomePageVisible());
    }



@Test
    public void registerBeforeCheckoutTc15() {
    new ApiService().registrationApi(name,email,password,firstname,lastname,company,address1,country
            ,zipcode,state,city,mobile_number);
    new P01_LoginPage(getDriver()).clickOnSignUpButton();
    new P01_LoginPage(getDriver()).enteringLoginInfo(email,password);
    new P01_LoginPage(getDriver()).clickOnLoginButton();
    new PlaceOrder_Page(getDriver()).checkLogOutVisible();
    new PlaceOrder_Page(getDriver()).addProducts();
    new PlaceOrder_Page(getDriver()).checkCardPageIsDisplyed();
    new PlaceOrder_Page(getDriver()).clickProceedCheckOut();
    List<WebElement> addressDeliveryDetails= new PlaceOrder_Page(getDriver()).getAddressDeliveryDetails();
    Assert.assertEquals(addressDeliveryDetails.get(2).getText(),getJsonData("userdata","company"),"Company name invaild");
    Assert.assertEquals(addressDeliveryDetails.get(3).getText(),getJsonData("userdata","address1"),"address name invaild");
    // Get the JSON values
    String city = getJsonData("userdata", "city");
    String state = getJsonData("userdata", "state");
    String zipcode = getJsonData("userdata", "zipcode");

// Concatenate the values
    String expectedAddress = city + " " + state + " " + zipcode;

// Get the actual address from the web page
    String actualAddress = addressDeliveryDetails.get(5).getText();
    Assert.assertEquals(actualAddress,expectedAddress, "city state zipcode invaild");
    Assert.assertEquals(addressDeliveryDetails.get(6).getText(),getJsonData("userdata","country"),"country name invaild");
    Assert.assertEquals(addressDeliveryDetails.get(7).getText(),getJsonData("userdata","mobile_number"),"mobile_number invaild");
new PlaceOrder_Page(getDriver()).writeOrderComment(getJsonData("userdata","order_comment"));
new PlaceOrder_Page(getDriver()).clickPlaceOrderBtn();
new PlaceOrder_Page(getDriver()).enterPaymentDate(getJsonData("paymentdata","cardname"),
        getJsonData("paymentdata","cardnumber"), getJsonData("paymentdata","cvc"),
        getJsonData("paymentdata","month") ,getJsonData("paymentdata","year"));
new PlaceOrder_Page(getDriver()).clickPayAndConfirmOrder();
new PlaceOrder_Page(getDriver()).clickDeleteAcount();
Assert.assertTrue(new PlaceOrder_Page(getDriver()).checkDeleteAcountMsg().contains("ACCOUNT DELETED!"));
}

    @AfterMethod
    public void quit() {
        DriverManager.quit();
    }
}
