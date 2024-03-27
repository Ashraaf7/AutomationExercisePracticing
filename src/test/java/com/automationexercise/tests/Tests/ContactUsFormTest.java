package com.automationexercise.tests.Tests;

import com.automationexercise.Pages.P02_ContactUsForm;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.DataUtils.getJsonData;

public class ContactUsFormTest {
    String fname;
    String femail;
    String fsubject;
    String fmessage;
    String path;
    String url;

    @BeforeClass
    public void setUp() {
        fname = getJsonData("data", "name");
        femail = getJsonData("data", "email");
        fsubject = getJsonData("data", "subject");
        fmessage = getJsonData("data", "message");
        path = "C:\\Users\\FAST\\IdeaProjects\\AutomationExercisePracticing\\src\\test\\resources\\test-data";
        url = getJsonData("data","url");
    }

    @Test
    public void contactUsTest() throws InterruptedException {
        new P02_ContactUsForm(getDriver())
                .setName(fname)
                .setEmail(femail)
                .setSubject(fsubject)
                .setMessage(fmessage)
                .clickuploadFile(path);
        boolean isAppeared = new P02_ContactUsForm(getDriver()).isSuccessMsgAppeared();
        Assert.assertTrue(isAppeared);
        new P02_ContactUsForm(getDriver()).clickHome();
        Thread.sleep(2000);
    }
}