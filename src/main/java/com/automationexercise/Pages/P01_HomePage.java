package com.automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.Utility.clicking;

public class P01_HomePage {
    final private WebDriver driver;
    private final By contactUsButton=By.xpath("//a[normalize-space()='Contact us']");

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean checkCurrentUrl(String url) {
        System.out.println(url);
        System.out.println(getDriver().getCurrentUrl());
        String currentUrl = driver.getCurrentUrl();
        if (url.equalsIgnoreCase(currentUrl)) {
            return true;
        }
        return false;
    }
    public P01_HomePage clickContactUs()
    {
        clicking(driver,contactUsButton);
        return this;
    }


}
