package com.automationexercise.Pages;

import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Utilities.Utility;
import com.automationexercise.Utilities.WaitsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static com.automationexercise.DriverManager.DriverManager.getDriver;

public class ProductsPage {
    /*  Selectors Sections  */
    private By cartNavbarElement = By.cssSelector("[class='nav navbar-nav'] li:nth-child(3) a");
    private By blueTopItem = By.xpath("//*[@class='features_items']/div[2]");
    private By menTshirtItem = By.xpath("//*[@class='features_items']/div[3]");
    private By bluetopaddtoCart = By.cssSelector("[data-product-id='1']");
    private By menTshirtAddtocart = By.cssSelector("[data-product-id='2']");
    private By continueShoppingButton = By.cssSelector("[data-dismiss='modal']");

    /*  Behaviour Sections  */
    public CartPage cartNavbarElementClick(){
        Utility.clicking(getDriver(),cartNavbarElement);
        return new CartPage();
    }
    public ProductsPage hoverOnBlueTopItemElement(){
        WaitsUtils.explicitlyWaitForVisibility(getDriver(),blueTopItem);
        new Actions(getDriver()).moveToElement(getDriver().findElement(blueTopItem)).perform();
        return this;
    }
    public ProductsPage hoverOnmenTshirtItemItemElement(){
        WaitsUtils.explicitlyWaitForVisibility(getDriver(),menTshirtItem);
        new Actions(getDriver()).moveToElement(getDriver().findElement(menTshirtItem)).perform();
        return this;
    }
    public ProductsPage bluetopddtoCartclick(){
        Utility.reloadPage(); // to avoid the ads appearing before clicking on "Add to cart" button which causes "org.openqa.selenium.ElementClickInterceptedException"
        WaitsUtils.explicitlyWaitForClickability(getDriver(),bluetopaddtoCart);
        Utility.clicking(getDriver(),bluetopaddtoCart);
        return this;
    }
    public ProductsPage menTshirtAddtocartClick(){
        Utility.reloadPage(); // to avoid the ads appearing before clicking on "Add to cart" button which causes "org.openqa.selenium.ElementClickInterceptedException"
        WaitsUtils.explicitlyWaitForClickability(getDriver(),menTshirtAddtocart);
        Utility.clicking(getDriver(),menTshirtAddtocart);
        return this;
    }
    public ProductsPage continueShoppingButtonClick(){
        WaitsUtils.explicitlyWaitForVisibility(getDriver(),continueShoppingButton);
        Utility.clicking(getDriver(),continueShoppingButton);
        return this;
    }

}
