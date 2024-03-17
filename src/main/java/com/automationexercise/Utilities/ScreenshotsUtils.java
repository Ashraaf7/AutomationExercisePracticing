package com.automationexercise.Utilities;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotsUtils
{
    private static Path path ;

    public Path getPath()
    {
        return path;
    }

    public void setPath(Path path)
    {
        this.path = path;
    }
    //create method to Take screenshot
    public static FileOutputStream captureScreenshot(WebDriver driver, String screenshotname) {

         path = Paths.get("test-outputs/screenshots",screenshotname+".png");
        try {
            Files.createDirectories(path.getParent());
            FileOutputStream out = new FileOutputStream(path.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
            return out;
        }
        catch (Exception e) {
            LogUtils.error(e.getMessage());
            return null;
        }
    }
    //create method to Take screenshot of the whole page
    public static FileOutputStream captureFullScreenshot(WebDriver driver, String screenshotname) {

        path = Paths.get("test-outputs/screenshots",screenshotname+".png");
        try {
            Files.createDirectories(path.getParent());
            FileOutputStream out = new FileOutputStream(path.toString());
            Shutterbug.shootPage(driver, Capture.FULL,true).save(String.valueOf(out));
            return out;
        }
        catch (Exception e) {
            LogUtils.error(e.getMessage());
            return null;
        }
    }
}