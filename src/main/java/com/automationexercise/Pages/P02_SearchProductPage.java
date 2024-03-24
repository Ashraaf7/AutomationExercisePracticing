package com.automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.Utility.*;
import static com.automationexercise.Utilities.WaitsUtils.explicitlyWaitForVisibility;

public class P02_SearchProductPage {
    private final WebDriver driver;

    public P02_SearchProductPage(WebDriver driver) {
        this.driver = driver;
    }


    WebElement AllProductsPage = getDriver().findElement
            (By.cssSelector("div[class=\"features_items\"]>h2"));
    By AllProductPage = By.cssSelector("div[class=\"features_items\"]>h2");
    By SearchField = By.xpath("//input[@id=\"search_product\"]");
    By SearchButton = By.cssSelector("button[id=\"submit_search\"]");
    By SearchedSection =
            By.xpath("//h2[@class=\"title text-center\" and contains(text(), 'Searched Products')]");
    List<WebElement> SearchResults = getDriver().findElements
            (By.xpath("//div[@id=\"cartModal\"]//following::div[@class=\"col-sm-4\"]"));


    public void EnterProduct(String product) {
        explicitlyWaitForVisibility(driver, SearchField);
        sendData(driver, SearchField, product);
    }

    public void PressSearchButton() {
        explicitlyWaitForVisibility(driver, SearchButton);
        clicking(driver, SearchButton);
    }
    //Verify

    public Boolean VerifyUserNavigatedToAllProductsPage() {
        explicitlyWaitForVisibility(driver, AllProductPage);
        return AllProductsPage.isDisplayed();
    }


    public Boolean VerifySearchedProductsSectionVisible() {
        explicitlyWaitForVisibility(driver, SearchedSection);
        return verifyElementVisible(SearchedSection);
    }

    public int VerifyAllProductRelatedToSearchVisible() {
        return SearchResults.size();
    }


}
