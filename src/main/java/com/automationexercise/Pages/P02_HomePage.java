package com.automationexercise.Pages;

import com.automationexercise.Utilities.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.automationexercise.Utilities.Utility.*;

public class P02_HomePage {


    private final WebDriver driver;

    private final By ProductButton = By.xpath("//a[@href=\"/products\"]");

    //  Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
    private final By SubscriptionText = By.xpath("//h2[contains(text(),'Subscription')]");
    private final By ScrollUpButton = By.cssSelector("[id=\"scrollUp\"]");
    private final By HeaderText = By.cssSelector("div[class='item active'] div[class='col-sm-6'] h2");

    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * This method is used to click on the products button on the home page
     */
    public P03_SearchProductPage pressProductsButton() {
        clicking(driver, ProductButton);
        LogUtils.info("Clicked on product button");
        P_AdPage.closeAdByRefreshing(ProductButton);
        return new P03_SearchProductPage(driver);
    }

    /**
     * This method is used to scroll to the bottom of the home page
     */
    public P02_HomePage scrollToBottom() {
        scrollToElementAtBottom(driver, SubscriptionText);
        return this;
    }

    /**
     * This method is used to verify scroll down to the bottom of the home page
     */
    public P02_HomePage verifyScrollDown() {
        verifyElementVisible(SubscriptionText);
        LogUtils.info("SubscriptionText:" + getText(driver, SubscriptionText));
        return this;
    }

    /**
     * This method is used scrollUp on the home page
     */
    public P02_HomePage pressScrollUpButton() {
        clicking(driver, ScrollUpButton);
        return this;
    }

    /**
     * This method is used to verify scrollUP to the top of the home page
     */
    public P02_HomePage verifyScrollUp() {
        verifyElementVisible(HeaderText);
        LogUtils.info("HeaderText:" + getText(driver, HeaderText));
        return this;
    }

    public P02_HomePage scrollToUpWithOutArrowButton() {
        scrollToElementAtTop(driver, HeaderText);
        return this;

    }
}