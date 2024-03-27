package com.automationexercise.Pages;

import com.automationexercise.Utilities.Utility;
import org.openqa.selenium.By;

import static com.automationexercise.DriverManager.DriverManager.getDriver;

public class CartPage {
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

    public void productsNavbarClick() {
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

    public String getTextBlueTopWomenElementPrice() {
        String textMixedPrice = Utility.getText(getDriver(),blueTopWomenItemElementPrice);
        return textMixedPrice;
    }

    public String getTextMenShirtElementPrice() {
        String textMixedPrice = Utility.getText(getDriver(),menShirtItemElementPrice);
        return textMixedPrice;
    }

    public String getTextBlueTopWomenElementQuantity(){
        String textMixedQuantity = Utility.getText(getDriver(),blueTopWomenItemElementQuantity);
        return textMixedQuantity;
    }

    public String getTextMenShirtElementQuantity(){
        String textMixedQuantity = Utility.getText(getDriver(),menShirtItemElementQuantity);
        return textMixedQuantity;
    }

    public float getTextBlueTopWomenItemElementTotal(){
        String fullText = Utility.getText(getDriver(),blueTopWomenItemElementTotal);
        fullText = Utility.replacingTextOnString(fullText,"RS .","");
        return Utility.convertStringToFloat(fullText);
    }

    public String getTextMenShirtItemElementTotal(){
        String textMixedQuantity = Utility.getText(getDriver(),menShirtItemElementTotal);
        return textMixedQuantity;
    }

    /*public int getBlueTopWomenElementIntegerPrice(){
        String textMixedQuantity = getTextBlueTopWomenElementPrice();
        return (int)Utility.extractFloat(textMixedQuantity);
    }

    public int getMenShirtElementIntegerPrice(){
        String textMixedQuantity = getTextMenShirtElementPrice();
        return (int)Utility.extractFloat(textMixedQuantity);
    }

    public int getBlueTopWomenElementIntegerQuantity(){
        String textMixedQuantity = getTextBlueTopWomenElementQuantity();
        return (int)Utility.extractFloat(textMixedQuantity);
    }

    public int getMenShirtElementIntegerQuantity(){
        String textMixedQuantity = getTextMenShirtElementQuantity();
        return (int)Utility.extractFloat(textMixedQuantity);
    }

    public int getBlueTopElementIntegerTotalPrice(){
        String fullText = getTextBlueTopWomenItemElementTotal();
        return (int)Utility.extractFloat(fullText);
    }
    public int getMenShirtElementIntegerTotalPrice()
    {
        String fullText = getTextMenShirtItemElementTotal();
        return (int)Utility.extractFloat(fullText);
    }*/
}//end class Cart
