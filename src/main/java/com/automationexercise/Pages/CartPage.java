package com.automationexercise.Pages;

import com.automationexercise.Utilities.Utility;
import org.openqa.selenium.By;

import static com.automationexercise.DriverManager.DriverManager.getDriver;

public class CartPage {
    private final static int ZERO = 0;
    private static int blueTopWomenItemPrice;
    private static int menShirtItemPrice;
    private static int blueTopWomenItemQuantity;
    private static int menShirtItemQuantity;

    private By homeNavbarElement = By.cssSelector("[class='nav navbar-nav'] li:nth-child(1) a");
    private By productsNavbarElement = By.cssSelector("[class='nav navbar-nav'] li:nth-child(2) a");
    private By cartNavbarElement = By.cssSelector("[class='nav navbar-nav'] li:nth-child(3) a");
    private By blueTopWomenItem = By.linkText("Blue Top");
    //private By blueTopItem = By.xpath("//*[@id='product-1']/td[@class='cart_description']/h4/a")
    private By menShirtItem = By.linkText("Men Tshirt");
    private By blueTopWomenItemElementPrice = By.cssSelector("#product-1 .cart_price p");
    private By blueTopWomenItemElementQuantity = By.cssSelector("#product-1 .cart_quantity button");
    private By menShirtItemElementPrice = By.cssSelector("#product-2 .cart_price p");
    private By menShirtItemElementQuantity = By.cssSelector("#product-2 .cart_quantity button");
    private By blueTopWomenItemElementTotal = By.cssSelector("#product-1 .cart_total p");
    private By menShirtItemElementTotal = By.cssSelector("#product-2 .cart_total p");



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
    }//end isBlueTopWomenItemExists()

    public boolean isBlueTopWomenItemExists() {
        return Utility.findWebElement(getDriver(), blueTopWomenItem).isDisplayed();
    }//end isBlueTopWomenItemExists()

    public String getBlueTopWomenElementPrice() {
        String textMixedPrice = Utility.findWebElement(getDriver(), blueTopWomenItemElementPrice).getText();
        return textMixedPrice;
    }//end getBlueTopWomenItemPrice()
    public String getMenShirtElementPrice() {
        String textMixedPrice = Utility.findWebElement(getDriver(), menShirtItemElementPrice).getText();
        return textMixedPrice;
    }//end getMenShirtItemPrice()
    public String getBlueTopWomenElementQuantity(){
        String textMixedQuantity = Utility.findWebElement(getDriver(),blueTopWomenItemElementQuantity).getText();
        return textMixedQuantity;
    }
    public String getMenShirtElementQuantity(){
        String textMixedQuantity = Utility.findWebElement(getDriver(),menShirtItemElementQuantity).getText();
        return textMixedQuantity;
    }
    public String getBlueTopWomenItemElementTotal(){
        String textMixedQuantity = Utility.findWebElement(getDriver(),blueTopWomenItemElementTotal).getText();
        return textMixedQuantity;
    }
    public String getMenShirtItemElementTotal(){
        String textMixedQuantity = Utility.findWebElement(getDriver(),menShirtItemElementTotal).getText();
        return textMixedQuantity;
    }

    public int getBlueTopWomenElementIntegerPrice(){
        String textMixedQuantity = getBlueTopWomenElementPrice();
        return extractInt(textMixedQuantity);
    }
    public int getMenShirtElementIntegerPrice(){
        String textMixedQuantity = getMenShirtElementPrice();
        return extractInt(textMixedQuantity);
    }
    public int getBlueTopWomenElementIntegerQuantity(){
        String textMixedQuantity = getBlueTopWomenElementQuantity();
        return extractInt(textMixedQuantity);
    }
    public int getMenShirtElementIntegerQuantity(){
        String textMixedQuantity = getMenShirtElementQuantity();
        return extractInt(textMixedQuantity);
    }

    public int getBlueTopElementIntegerTotalPrice(){
        String fullText = getBlueTopWomenItemElementTotal();
        return extractInt(fullText);
    }
    public int getMenShirtElementIntegerTotalPrice()
    {
        String fullText = getMenShirtItemElementTotal();
        return extractInt(fullText);
    }


    //TODO:  Extract the Integer numbers out of a string
    public static int extractInt(String str)
    {
        try{
            str = str.replaceAll("[^0-9]", ""); // replace all the characters with "" which means delete it
            return Integer.parseInt(str); //convert the string into an integer number
        }
        catch(NumberFormatException e){
            return 0;
        }
    }//end method extractInt()
}//end class Cart
