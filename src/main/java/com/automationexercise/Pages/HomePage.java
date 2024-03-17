package com.automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public  HomePage(WebDriver driver) {
        super(driver);
    }

    private By testcasebtn_ele = By.xpath("(//a[@href=\"/test_cases\"])[1]");
    public TestCasesPage ClickOnTestCases() {
        driver.findElement(testcasebtn_ele).click();
        return new TestCasesPage(driver);
    }

    public boolean isHomePageVisible() {
        WebElement element = driver.findElement(testcasebtn_ele);
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }
}
