package com.automationexercise.tests.Tests;

import com.automationexercise.Pages.PlaceOrder_Page;
import io.restassured.RestAssured;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.automationexercise.DriverManager.DriverFactory.createInstance;
import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.DataUtils.getEnvironmentPropertyValue;
import static com.automationexercise.Utilities.Utility.openWebsite;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class PlaceOrder_Test {
    @BeforeMethod
    public void setup()
    {

        createInstance(getEnvironmentPropertyValue("BROWSER"));
        openWebsite(getEnvironmentPropertyValue("BASE_URL"));

        //Verify that home page is visible successfully
        Assert.assertTrue(new PlaceOrder_Page(getDriver()).checkHomePageVisible());
    }

    @Test
    public void testRegistration() {
        RestAssured.baseURI = "http://automationexercise.com";
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("name", "john_doe")
                .formParam("email", "nora@example.com")
                .formParam("password", "Test@123")
                .formParam("firstname","nora")
                .formParam("lastname","Zk")
                .formParam("company","asd")
                .formParam("address1","wq")
                .formParam("country","India")
                .formParam("zipcode","qwe")
                .formParam("state","asdwqe")
                .formParam("city","sdawe")
                .formParam("mobile_number","213123")
                .when()
                .post("/api/createAccount")
                        .then().log().body();
    }


}
