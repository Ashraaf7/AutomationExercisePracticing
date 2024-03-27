package com.automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.automationexercise.Utilities.Utility.clicking;
import static com.automationexercise.Utilities.Utility.getText;

public class P02_ContactUsForm {
    private final WebDriver driver;
    private final By name=By.name("name");
    private final By email=By.name("email");
    private final By subject=By.name("subject");
    private final By message=By.name("message");
    private final By uploadFileButton=By.cssSelector("input[type='file']");
    private final By submitButton=By.name("submit");
    private final By successText=By.className("status");
    private final By successMsg = By.xpath("//div[@class='status alert alert-success']");
    private final By homeBtn = By.xpath("//span[normalize-space()='Home']");

    public P02_ContactUsForm(WebDriver driver) {
        this.driver = driver;
    }

    public P02_ContactUsForm setName(String fname)
    {
        driver.findElement(name).sendKeys(fname);
        return this;
    }
    public P02_ContactUsForm setEmail(String femail)
    {
        driver.findElement(email).sendKeys(femail);
        return this;
    }
    public P02_ContactUsForm setSubject(String fsubject)
    {
        driver.findElement(subject).sendKeys(fsubject);
        return this;
    }
    public P02_ContactUsForm setMessage(String fmessage)
    {
        driver.findElement(message).sendKeys(fmessage);
        return this;
    }
    public P02_ContactUsForm clickSubmitButton()
    {
        driver.findElement(submitButton).click();
        return this;
    }
    public P02_ContactUsForm acceptPopUp()
    {
        driver.switchTo().alert().accept();
        return this;
    }
    public P02_ContactUsForm clickuploadFile(String fileAbsoluteBath)
    {
          driver.findElement(uploadFileButton).sendKeys(fileAbsoluteBath);
          clickSubmitButton();
          acceptPopUp();
        return this;

    }
    public String getSuccessText()
    {
        return getText(driver,successText);
    }

    public boolean isSuccessMsgAppeared(){
        return (driver.findElement(successMsg).isDisplayed());
    }
    public void clickHome(){
        clicking(driver,homeBtn);
    }

}
