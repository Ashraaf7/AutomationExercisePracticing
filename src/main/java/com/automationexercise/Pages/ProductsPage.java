package com.automationexercise.Pages;

import com.automationexercise.Utilities.Utility;
import com.automationexercise.Utilities.WaitsUtils;
import org.openqa.selenium.By;

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
    public CartPage clickOnCartNavbar(){
        Utility.clicking(getDriver(),cartNavbarElement);
        return new CartPage();
    }
    public ProductsPage hoverOnBlueTopItemElement(){
        Utility.hoverOnElement(getDriver(),blueTopItem);
        return this;
    }
    public ProductsPage hoverOnmenTshirtItemItemElement(){
        Utility.hoverOnElement(getDriver(),menTshirtItem);
        return this;
    }
    public ProductsPage ClickOnBlueTopAddToCart(){
       // Utility.reloadPage(); // to avoid the ads appearing before clicking on "Add to cart" button which causes "org.openqa.selenium.ElementClickInterceptedException"
        WaitsUtils.explicitlyWaitForClickability(getDriver(),bluetopaddtoCart);
        Utility.clicking(getDriver(),bluetopaddtoCart);
        return this;
    }
    public ProductsPage ClickOnMenTshitrtAddTOCart(){
        Utility.reloadPage(); // to avoid the ads appearing before clicking on "Add to cart" button which causes "org.openqa.selenium.ElementClickInterceptedException"
        WaitsUtils.explicitlyWaitForClickability(getDriver(),menTshirtAddtocart);
        Utility.clicking(getDriver(),menTshirtAddtocart);
        return this;
    }
    public ProductsPage clickOnContinuoShoppingButton(){
        WaitsUtils.explicitlyWaitForVisibility(getDriver(),continueShoppingButton);
        Utility.clicking(getDriver(),continueShoppingButton);
        return this;
    }

}
