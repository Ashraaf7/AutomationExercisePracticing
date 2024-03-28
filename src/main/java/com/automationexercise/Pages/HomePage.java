package com.automationexercise.Pages;

import com.automationexercise.Utilities.Utility;
import com.automationexercise.Utilities.WaitsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private By homePageSign = By.cssSelector("#slider-carousel > div");
    public boolean verifyHomePageVisability(){
        return Utility.verifyElementVisible(homePageSign);
    }
}
