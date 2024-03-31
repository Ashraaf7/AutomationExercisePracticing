package com.automationexercise.Pages;

import com.automationexercise.Utilities.Utility;
import org.openqa.selenium.By;

import static com.automationexercise.DriverManager.DriverManager.getDriver;

public class P12_CartPage {
    /*   Locators Section          */
    private final By homeNavbarElement = By.cssSelector("[class='nav navbar-nav'] li:nth-child(1) a");
    private final By productsNavbarElement = By.cssSelector("[class='nav navbar-nav'] li:nth-child(2) a");
    private final By cartNavbarElement = By.cssSelector("[class='nav navbar-nav'] li:nth-child(3) a");
    private final By blueTopWomenItem = By.linkText("Blue Top");
    private final By menShirtItem = By.linkText("Men Tshirt");
    private final By blueTopWomenItemElementPrice = By.cssSelector("#product-1 .cart_price p");
    private final By blueTopWomenItemElementQuantity = By.cssSelector("#product-1 .cart_quantity button");
    private final By menShirtItemElementPrice = By.cssSelector("#product-2 .cart_price p");
    private final By menShirtItemElementQuantity = By.cssSelector("#product-2 .cart_quantity button");
    private final By blueTopWomenItemElementTotal = By.cssSelector("#product-1 .cart_total p");
    private final By menShirtItemElementTotal = By.cssSelector("#product-2 .cart_total p");

    /*   Behaviour Section             */
    public void homeNavbarClick() {
        Utility.clicking(getDriver(), homeNavbarElement);
    }

    public void clickONproductsNavbar() {
        Utility.clicking(getDriver(), productsNavbarElement);
    }

    public void cartNavbarClick() {
        Utility.clicking(getDriver(), cartNavbarElement);
    }

    public boolean isMenShirtItemExists() {
        return Utility.findWebElement(getDriver(), menShirtItem).isDisplayed();
    }

    public boolean isBlueTopWomenItemExists() {
        return Utility.findWebElement(getDriver(), blueTopWomenItem).isDisplayed();
    }

    public float getBlueTopWomenPrice() {
        String fullText = Utility.getText(getDriver(),blueTopWomenItemElementPrice);
        System.out.println("fullText = "+fullText);
        String textnumber = Utility.replacingTextOnString(fullText,"Rs. ","");
        System.out.println("fullText after replacing = "+textnumber);
        return Utility.convertStringToFloat(textnumber);
    }

    public float getMenShirtPrice() {
        String fullText = Utility.getText(getDriver(),menShirtItemElementPrice);
        fullText = Utility.replacingTextOnString(fullText,"Rs. ","");
        return Utility.convertStringToFloat(fullText);
    }

    public float getBlueTopWomenQuantity(){
        String fullText = Utility.getText(getDriver(),blueTopWomenItemElementQuantity);
        return Utility.convertStringToFloat(fullText);
    }

    public float getMenShirtQuantity(){
        String fullText = Utility.getText(getDriver(),menShirtItemElementQuantity);
        return Utility.convertStringToFloat(fullText);
    }

    public float getBlueTopWomenTotalPrice(){
        String fullText = Utility.getText(getDriver(),blueTopWomenItemElementTotal);
        fullText = Utility.replacingTextOnString(fullText,"Rs. ","");
        return Utility.convertStringToFloat(fullText);
    }

    public float getMenShirtTotalPrice(){
        String fullText = Utility.getText(getDriver(),menShirtItemElementTotal);
        fullText = Utility.replacingTextOnString(fullText,"Rs. ","");
        return Utility.convertStringToFloat(fullText);
    }
    public boolean verifyBlueTopWomenTotlaPrice(){
        if(getBlueTopWomenPrice() * getBlueTopWomenQuantity() == getBlueTopWomenTotalPrice() )
            return true;
        else
            return false;
    }
    public boolean verifyMenShirtTotlaPrice(){
        if(getMenShirtPrice() * getMenShirtQuantity() == getMenShirtTotalPrice() )
            return true;
        else
            return false;
    }
    public boolean verifyBlueTopWomenPrice(){
        if(getBlueTopWomenPrice() == 500.0 )
            return true;
        else
            return false;
    }
    public boolean verifyMenShirtPrice(){
        if(getMenShirtPrice() == 400.0 )
            return true;
        else
            return false;
    }
    public boolean verifyBlueTopWomenQuantity(){
        if(getBlueTopWomenQuantity() == 1.0 )
            return true;
        else
            return false;
    }
    public boolean verifyMenShirtQuantity(){
        if(getMenShirtQuantity() == 1.0 )
            return true;
        else
            return false;
    }



}//end class Cart
