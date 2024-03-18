package com.automationexercise.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.DataUtils.getConfigValue;

public class WaitsUtils {


    public static void implicitlyWait() {
        getDriver().manage().timeouts().
                implicitlyWait(Duration.ofSeconds(Integer.parseInt(getConfigValue("config", "WAIT_IMPLICIT"))));
    }

    //TODO: General Explicit Wait
    public static WebDriverWait generalWait(WebDriver driver, int timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    //TODO:  Explicit Wait For Clickability
    public static void explicitlyWaitForClickability(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(getConfigValue("config", "WAIT_EXPLICIT"))))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    //TODO:  Explicit Wait For Visibility
    public static void explicitlyWaitForVisibility(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(getConfigValue("config", "WAIT_EXPLICIT"))))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait for the given element to present
     *
     * @param by an element of object type By
     * @return an existing WebElement object
     */
    public static WebElement waitForElementPresent(By by) {

        try {
            return generalWait(getDriver(), Integer.parseInt(getConfigValue("config", "WAIT_EXPLICIT")))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            LogUtils.error("Element not exist. " + by.toString());
        }
        return null;
    }

    public static boolean waitForElementHasAttribute(By by, String attributeName) {
        try {
            return generalWait(getDriver(), Integer.parseInt(getConfigValue("config", "WAIT_EXPLICIT")))
                    .until(ExpectedConditions.attributeToBeNotEmpty(Objects.requireNonNull(waitForElementPresent(by)), attributeName));
        } catch (Throwable error) {
            LogUtils.error("Timeout for element " + by.toString() + " to exist attribute: " + attributeName);
        }
        return false;
    }


}
