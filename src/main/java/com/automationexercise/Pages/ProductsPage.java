package com.automationexercise.Pages;

import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Utilities.Utility;
import com.automationexercise.Utilities.WaitsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static com.automationexercise.DriverManager.DriverManager.getDriver;

public class ProductsPage {
    private By blueTopItem = By.xpath("//*[@class='features_items']/div[2]");
    private By menTshirtItem = By.xpath("//*[@class='features_items']/div[3]");
    private By bluetopaddtoCart = By.cssSelector("[data-product-id='1']");
    private By menTshirtAddtocart = By.cssSelector("[data-product-id='2']");
    private By continueShoppingButton = By.cssSelector("[data-dismiss='modal']");
    public void hoverOnBlueTopItemElement(){
        WaitsUtils.explicitlyWaitForVisibility(getDriver(),blueTopItem);
        new Actions(getDriver()).moveToElement(getDriver().findElement(blueTopItem)).perform();
    }
    public void hoverOnmenTshirtItemItemElement(){
        WaitsUtils.explicitlyWaitForVisibility(getDriver(),menTshirtItem);
        new Actions(getDriver()).moveToElement(getDriver().findElement(menTshirtItem)).perform();
    }
    public void bluetopddtoCartclick(){
        Utility.reloadPage(); // to avoid the ads appearing before clicking on "Add to cart" button which causes "org.openqa.selenium.ElementClickInterceptedException"
        WaitsUtils.explicitlyWaitForClickability(getDriver(),bluetopaddtoCart);
        Utility.clicking(getDriver(),bluetopaddtoCart);
    }
    public void menTshirtAddtocartClick(){
        Utility.reloadPage(); // to avoid the ads appearing before clicking on "Add to cart" button which causes "org.openqa.selenium.ElementClickInterceptedException"
        WaitsUtils.explicitlyWaitForClickability(getDriver(),menTshirtAddtocart);
        Utility.clicking(getDriver(),menTshirtAddtocart);
    }
    public void continueShoppingButtonClick(){
        WaitsUtils.explicitlyWaitForVisibility(getDriver(),continueShoppingButton);
        Utility.clicking(getDriver(),continueShoppingButton);
    }

}
