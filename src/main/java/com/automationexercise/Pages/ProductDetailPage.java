package com.automationexercise.Pages;

import com.automationexercise.Utilities.WaitsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.Utility.clicking;
import static com.automationexercise.Utilities.Utility.sendData;

public class ProductDetailPage {
    private final WebDriver driver;
    private final By quantityBox = By.id("quantity");
    private final By addToCartBtn = By.xpath("//button[normalize-space()='Add to cart']");
    private final By viewCartBtn = By.xpath("//u[normalize-space()='View Cart']");
    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }
    public ProductDetailPage changeQuantity(int quantity) {
        driver.findElement(quantityBox).clear();
        sendData(driver,quantityBox,String.valueOf( quantity));
        return this;
    }
    public ProductDetailPage addToCart() {
        clicking(driver,addToCartBtn);
        return this;
    }
    public ProductDetailPage clickViewCart(){
        WaitsUtils.explicitlyWaitForVisibility(getDriver(),viewCartBtn);
        clicking(driver,viewCartBtn);
        return this;
    }

}
