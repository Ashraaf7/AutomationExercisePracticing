package com.automationexercise.Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotsUtils
{
    public static  void capturescreenshot(WebDriver driver, String screenshotname) {

        Path path = Paths.get("test-outputs/screenshots",screenshotname+".png");
        try {
            Files.createDirectories(path.getParent());
            FileOutputStream out = new FileOutputStream(path.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        }
        catch (Exception e) {
            System.out.println("Exception while take screenshot"+e.getMessage());
        }
    }

}