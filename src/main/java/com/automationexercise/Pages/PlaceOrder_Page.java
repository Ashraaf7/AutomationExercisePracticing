package com.automationexercise.Pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.automationexercise.Utilities.DataUtils.getEnvironmentPropertyValue;
import static com.automationexercise.Utilities.Utility.*;

public class PlaceOrder_Page {
   //define driver
    private final WebDriver driver;
//Define constructor
    public PlaceOrder_Page(WebDriver driver) {
        this.driver = driver;
    }
    //Locator
private final By logOutBtn=By.cssSelector("a[href=\"/logout\"]");
    //Validations
    public boolean checkHomePageVisible() {
        return VerifyURL(driver, getEnvironmentPropertyValue("BASE_URL"));
    }

    public boolean checkLogOutVisible() {
        return verifyElementVisible(logOutBtn);
    }



}
