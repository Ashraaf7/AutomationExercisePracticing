package com.automationexercise.Pages;

import com.automationexercise.Utilities.LogUtils;
import org.openqa.selenium.By;

import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.Utility.clicking;
import static com.automationexercise.Utilities.Utility.reloadPage;

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

}
