package com.automationexercise.Pages;

import com.automationexercise.Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.automationexercise.DriverManager.DriverManager.getDriver;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver) {this.driver = driver;}
    private final By homePageLogo = By.xpath("//img[@alt='Website for automation practice']");
    private final By secondProduct = By.xpath("//a[@href=\"/product_details/2\"]");

    public boolean isHomePagePresent() {
        return getDriver().findElement(homePageLogo).isDisplayed();
    }
    public HomePage click2ndProduct(){
        Utility.clicking(driver,secondProduct);
        return this;
    }
}
