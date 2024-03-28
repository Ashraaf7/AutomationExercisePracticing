package com.automationexercise.Pages;

import com.automationexercise.Utilities.Utility;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.automationexercise.Utilities.DataUtils.getEnvironmentPropertyValue;
import static com.automationexercise.Utilities.DataUtils.getJsonData;
import static com.automationexercise.Utilities.Utility.*;

public class PlaceOrder_Page {
    private final WebDriver driver;

    //Define constructor

    public PlaceOrder_Page(WebDriver driver) {
        this.driver = driver;
    }
    //Locator
    private final By logOutBtn=By.cssSelector("a[href=\"/logout\"]");
    private final By userNameLable=By.cssSelector(" #header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a > b");

    private final By addCardBtnProduct=By.cssSelector(".single-products .productinfo.text-center .add-to-cart");
private final By continueShoppingBtn=By.cssSelector("button[class=\"btn btn-success close-modal btn-block\"]");

private final By cardBtnAtHeader=By.cssSelector("a[href=\"/view_cart\"]>i");
private final By checkOutBtn=By.cssSelector("a[class=\"btn btn-default check_out\"]");
private final By addressDeliveryDetails=By.tagName("li");
private final By addressDelivey= By.id("address_delivery");
private final By orderComment=By.cssSelector("textarea[name=\"message\"]");
private final By placeOrderBtn=By.cssSelector("[href=\"/payment\"]");
private final By cardNameTxtbox=By.cssSelector("input[name=\"name_on_card\"]");
private final By cardNumberTxtbox=By.cssSelector("input[name=\"card_number\"]");
private final By cardCvcTxtbox=By.cssSelector("input[name=\"cvc\"]");
private final By expireMonthTxtbox=By.cssSelector("input[name=\"expiry_month\"]");
    private final By expireYearTxtbox=By.cssSelector("input[name=\"expiry_year\"]");
    private final By payAndConfirmBtn=By.cssSelector("button[id=\"submit\"]");
    private final By sucessMsgLabel=By.cssSelector("div[id=\"success_message\"]>div[class=\"alert-success alert\"]");
    private final By deleteAccountBtn=By.cssSelector("a[href=\"/delete_account\"]");
    private final By deleteMsg=By.cssSelector("h2[class=\"title text-center\"]");
    //Validations
    public boolean checkHomePageVisible() {
        return VerifyURL(driver, getEnvironmentPropertyValue("BASE_URL"));
    }

    public boolean checkLogOutVisible() {
        return verifyElementVisible(logOutBtn);
    }
    public boolean checkUserNameAtTop()
    {
        return getElementLocation(userNameLable);
    }
    public void addProducts()  {
       List<WebElement> addToCardBtns= findWebElements(driver,addCardBtnProduct);
        for (int i = 0; i < 3; i++) {
            WebElement secondAddToCartButton = addToCardBtns.get(i);
            System.out.println(secondAddToCartButton.getText());
            ScrollToElement(secondAddToCartButton);
            hoverElement(secondAddToCartButton);
            clicking(driver,continueShoppingBtn);
        }
        scrollToElement(driver,cardBtnAtHeader);
        clicking(driver,cardBtnAtHeader);
        }
    public boolean checkCardPageIsDisplyed()
    {
        return verifyElementVisible(checkOutBtn);
    }
    public void clickProceedCheckOut()
    {
        clicking(driver,checkOutBtn);
    }
public List<WebElement> getAddressDeliveryDetails()
{
    WebElement addressDelivery = driver.findElement(addressDelivey);

    List<WebElement> AddressDeliveryDetailsList= addressDelivery.findElements(addressDeliveryDetails);
    System.out.println(AddressDeliveryDetailsList.size());

    for (int i = 0; i < AddressDeliveryDetailsList.size(); i++) {
        System.out.println(AddressDeliveryDetailsList.get(i).getText());

    }
    return AddressDeliveryDetailsList;

}
public void writeOrderComment(String comment)
{
    scrollToElement(driver,orderComment);
    sendData(driver,orderComment,comment);
}
public void clickPlaceOrderBtn()
{

    clicking(driver,placeOrderBtn);}
    public void enterPaymentDate(String cardName,String cardNo,String cvc, String expireMonth ,String expireYear)
    {
        sendData(driver,cardNameTxtbox,cardName);
        sendData(driver,cardNumberTxtbox,cardNo);
        sendData(driver,cardCvcTxtbox,cvc);
        sendData(driver,expireMonthTxtbox,expireMonth);
        sendData(driver,expireYearTxtbox,expireYear);
    }
    public void clickPayAndConfirmOrder()
    {clicking(driver,payAndConfirmBtn);}
    public String checkPaymentSucessMsg()
    {
        System.out.println(getText(driver,sucessMsgLabel));

        return getText(driver,sucessMsgLabel);
    }
    public void clickDeleteAcount()
    {
        clicking(driver,deleteAccountBtn);
    }
    public String checkDeleteAcountMsg()
    {

        return getText(driver,deleteMsg);
    }

}

