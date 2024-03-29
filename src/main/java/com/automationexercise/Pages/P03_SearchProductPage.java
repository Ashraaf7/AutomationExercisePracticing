package com.automationexercise.Pages;

import com.automationexercise.Utilities.LogUtils;
import com.automationexercise.Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.Utility.*;

public class P03_SearchProductPage {
    private final WebDriver driver;
    private final By AllProductPage = By.cssSelector("div[class=\"features_items\"]>h2");
    private final By SearchField = By.xpath("//input[@id=\"search_product\"]");
    private final By SearchButton = By.cssSelector("button[id=\"submit_search\"]");
    private final By SearchedSection =
            By.xpath("//h2[@class=\"title text-center\" and contains(text(), 'Searched Products')]");
    private final List<WebElement> SearchResults = getDriver().findElements
            (By.xpath("//div[@id=\"cartModal\"]//following::div[@class=\"col-sm-4\"]"));
    private final By cartNavbarElement = By.cssSelector("[class='nav navbar-nav'] li:nth-child(3) a");
    private final By blueTopItem = By.xpath("//*[@class='features_items']/div[2]");
    private final By menTshirtItem = By.xpath("//*[@class='features_items']/div[3]");
    private final By bluetopaddtoCart = By.cssSelector("[data-product-id='1']");
    private final By menTshirtAddtocart = By.cssSelector("[data-product-id='2']");
    private final By continueShoppingButton = By.cssSelector("[data-dismiss='modal']");
    public P03_SearchProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public P03_SearchProductPage EnterProduct(String product) {
        sendData(driver, SearchField, product);
        return this;
    }

    public P03_SearchProductPage PressSearchButton() {
        clicking(driver, SearchButton);
        return this;
    }


    public Boolean VerifyUserNavigatedToAllProductsPage() {
        return verifyElementVisible(AllProductPage);
    }


    public Boolean VerifySearchedProductsSectionVisible() {
        return verifyElementVisible(SearchedSection);
    }

    public int VerifyAllProductRelatedToSearchVisible() {
        LogUtils.info("Search Result Size:" + SearchResults.size());
        return SearchResults.size();


    }

    public P12_CartPage clickOnCartNavbar(){
        Utility.clicking(getDriver(),cartNavbarElement);
        return new P12_CartPage();
    }
    public P03_SearchProductPage hoverOnBlueTopItemElement(){
        Utility.hoverOnElement(getDriver(),blueTopItem);
        return this;
    }
    public P03_SearchProductPage hoverOnmenTshirtItemItemElement(){
        Utility.hoverOnElement(getDriver(),menTshirtItem);
        return this;
    }
    public P03_SearchProductPage ClickOnBlueTopAddToCart(){
        P_AdPage.closeAdByRefreshing(bluetopaddtoCart);
        return this;
    }
    public P03_SearchProductPage ClickOnMenTshitrtAddTOCart(){
        Utility.clicking(driver,menTshirtAddtocart);
        return this;
    }
    public P03_SearchProductPage clickOnContinuoShoppingButton(){
        Utility.clicking(driver,continueShoppingButton);
        return this;
    }

}
