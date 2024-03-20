package com.automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.automationexercise.Utilities.DataUtils.getEnvironmentPropertyValue;
import static com.automationexercise.Utilities.Utility.*;

public class ProductDetailPage {
    final WebDriver driver;
    final By productsLink = By.partialLinkText("Produc");
    final By allProductsText = By.xpath("//h2[@class='title text-center']");
    final By viewProductBtn = By.xpath("//a[@href='/product_details/1']");
    final By productName = By.xpath("//h2[contains(text(),'Blue Top')]");
    final By productCategory = By.xpath("//p[contains(text(),'Category: Women > Tops')]");
    final By productPrice = By.xpath("//span[contains(text(),'Rs. 500')]");
    final By quantityField = By.xpath("//input[@id='quantity']");
    final By availability = By.xpath("//body[1]/section[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/p[2]");
    final By condition = By.xpath("//body[1]/section[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/p[3]");
    final By Brand = By.xpath("//body[1]/section[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/p[4]");


    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openAllProductsPage()
    {
        clicking(driver,productsLink);
    }
    public void navigateToAllProductsPage()
    {
        openWebsite(getEnvironmentPropertyValue("allProducts_URL"));
    }
    public void openProductDetailPage()
    {
        clicking(driver,viewProductBtn);
    }
    public boolean CheckProductName(String pName)
    {
        return verifyEquals(productName, pName);

    }
    public boolean CheckProductCategory(String pCategory)
    {
        return verifyEquals(productCategory, pCategory);

    }
    public boolean CheckProductPrice(String pPrice)
    {
        return verifyEquals(productPrice, pPrice);

    }
    public boolean CheckProductQuantity(String pQuantity)
    {
        return verifyEquals(quantityField, pQuantity);

    }
    public boolean CheckProductAvailability(String pAvailability)
    {
        return verifyEquals(availability, pAvailability);
    }
}
