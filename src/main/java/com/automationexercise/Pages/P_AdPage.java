package com.automationexercise.Pages;

import com.automationexercise.Utilities.LogUtils;
import org.openqa.selenium.By;

import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.Utility.*;

public class P_AdPage {


    public static P_AdPage closeAdByRefreshing(By element) {
        reloadPage();
        try {
            clicking(getDriver(), element);
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
        }
        return new P_AdPage();
    }

    public static P_AdPage closeAdByClicking() {
        try {
            By IframeElement = By.cssSelector("[id=\"aswift_6\"]");
            By ad = By.xpath("//span[@dir=\"auto\" and contains(text(),\"Close\")]");
            By ad2 = By.xpath("//div[@id=\"dismiss-button\"]");
            getDriver().switchTo().frame(findWebElement(getDriver(), IframeElement));
            if (verifyElementVisible(ad)) {
                clicking(getDriver(), ad);
                LogUtils.info("Ad button clicked: " + "AD1");
            } else if (verifyElementVisible(ad2)) {
                clicking(getDriver(), ad2);
                LogUtils.info("Ad button clicked: " + "AD2");
            }
        } catch (Exception e) {
            LogUtils.error("Cannot click on ads");
        }
        return new P_AdPage();
    }
}
