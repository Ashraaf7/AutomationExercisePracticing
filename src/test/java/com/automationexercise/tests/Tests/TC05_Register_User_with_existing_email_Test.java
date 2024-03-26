package com.automationexercise.tests.Tests;
import com.automationexercise.DriverManager.DriverFactory;
import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.P02_register_with_exite_mail;
import com.automationexercise.Utilities.DataUtils;
import com.automationexercise.Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.*;
import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.DataUtils.getJsonData;
import static com.automationexercise.Utilities.Utility.*;

public  class TC05_Register_User_with_existing_email_Test
{
    private final String name=getJsonData("signup_with_exist_email","name");
    private final String email=getJsonData("signup_with_exist_email","email");
  private final String signup_message=getJsonData("signup_with_exist_email","message");
  private final String ERROR_MSG=getJsonData("signup_with_exist_email","error message");
private final String expected_URL = getJsonData("signup_with_exist_email","expected URL");
    P02_register_with_exite_mail P02 = new P02_register_with_exite_mail(getDriver());
  @BeforeMethod
  public void setUp() {
    DriverFactory.createInstance(DataUtils.getEnvironmentPropertyValue("BROWSER"));
    Utility.openWebsite(DataUtils.getEnvironmentPropertyValue("BASE_URL"));
  }
  @Test
  public void navigate_to_signup_page() {
    Assert.assertTrue(VerifyURL(getDriver(), expected_URL));

      new P02_register_with_exite_mail(getDriver())
              .click_On_signup_Login_Button();

    Assert.assertTrue(new P02_register_with_exite_mail(getDriver())
            .assert_on_new_user_signup_message(signup_message));

    new P02_register_with_exite_mail(getDriver())
              .enter_signup_Info(name,email)
              .click_On_signup_Button();

    Assert.assertTrue(new P02_register_with_exite_mail(getDriver())
            .assert_on_error_message(ERROR_MSG));

  }


  @AfterMethod
  public void quit()
  {
    DriverManager.quit();
  }
}



