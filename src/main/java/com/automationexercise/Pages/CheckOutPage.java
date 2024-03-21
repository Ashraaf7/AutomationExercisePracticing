package com.automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.Utility.clicking;
import static com.automationexercise.Utilities.Utility.getText;

public class CheckOutPage {
    private WebDriver driver;
    private final By quantity= By.xpath("(//button[@class='disabled'])[1]");
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
    public String checkOutQuantity() {
        return getText(getDriver(),quantity);
    }
}
