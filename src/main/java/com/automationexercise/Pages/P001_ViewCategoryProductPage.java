package com.automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P001_ViewCategoryProductPage {

    public WebDriver driver;

    public P001_ViewCategoryProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By categoryProducts = By.id("accordian");

    private By selectCategory(String type) {
        return By.cssSelector("a[href=\"#" + type + "\"]");
    }


    private final By DressItem = By.cssSelector("li a[href=\"/category_products/1\"]");
    private final By assertOnTextCategoryWomen = By.xpath("//h2[text()='Women - Dress Products']");

    private final By tShirtItem = By.cssSelector("li a[href=\"/category_products/3\"]");
    private final By getAssertOnTextCategoryMen = By.xpath("//h2[text()='Men - Tshirts Products']");


    public WebElement assertVisibleCategoryProducts() {
        return driver.findElement(categoryProducts);
    }

    public WebElement clickOnCategory(String type) {
        return driver.findElement(selectCategory(type));
    }

    public WebElement clickOnDressItem() {
        return driver.findElement(DressItem);
    }

    public WebElement assertTextCategoryWom() {
        return driver.findElement(assertOnTextCategoryWomen);
    }

    public WebElement clickOnTShirtItem() {
        return driver.findElement(tShirtItem);
    }

    public WebElement assertTextCategoryMen() {
        return driver.findElement(getAssertOnTextCategoryMen);
    }

}
