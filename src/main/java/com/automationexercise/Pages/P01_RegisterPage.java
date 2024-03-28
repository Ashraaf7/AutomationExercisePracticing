package com.automationexercise.Pages;

import com.automationexercise.Utilities.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.automationexercise.Utilities.DataUtils.getEnvironmentPropertyValue;
import static com.automationexercise.Utilities.Utility.*;

public class P01_RegisterPage {

    //click button in the header
    private final By signupLoginButton = By.cssSelector("a[href='/login']");
    //input feald name && email then signup button to redirect to the form page
    private final By signUpName = By.cssSelector("input[data-qa=\"signup-name\"]");
    private final By signUpEmail = By.cssSelector("input[data-qa=\"signup-email\"]");
    private final By signUpButton = By.cssSelector("button[data-qa=\"signup-button\"]");
    private final By errorMsg = By.cssSelector("[action=\"/signup\"] p");
    private final By newUserSignupMessage = By.cssSelector(".signup-form h2");
    //radio button for selecting gender
    private final By genderMrRadioButton = By.id("id_gender1");
    private final By genderMrsRadioButton = By.id("id_gender2");
    //password feald
    private final By passwordFeald = By.id("password");
    //selecting date  of birth
    private final By daysSelect = By.id("days");
    private final By monthsSelect = By.id("months");
    private final By yearsSelect = By.id("years");

    //newsletter && spec offers optin
    private final By signUpForNewsletter = By.id("years");
    private final By specsOffersoptin = By.id("optin");
    //first name && lastname
    private final By firstNameInput = By.id("first_name");
    private final By lastNameInput = By.id("last_name");
    //company
    private final By companyNameInputField = By.id("company");
    private final By addressOneInput = By.id("address1");
    private final By addressTwoInput = By.id("address2");
    private final By countrySelect = By.id("country");
    private final By stateInput = By.id("state");
    private final By cityInput = By.id("city");
    private final By zipcodeInput = By.id("zipcode");
    private final By mobileNumberInput = By.id("mobile_number");
    private final By createAccountButton = By.xpath("//button[@data-qa='create-account']");
    private final By accountCreated = By.xpath("//h2[@data-qa='account-created']");

    //define Driver
    private final WebDriver driver;

    public P01_RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public P01_RegisterPage clickOnSignupLoginButton() {
        clicking(driver, signupLoginButton);
        return this;
    }

    public P01_RegisterPage fillUserRegistrationForm(String pass, String userFirstName, String userLastName, String day, String month, String year
            , String company, String userAddressOne, String userAddressTwo, String country, String state, String city, String zipCode, String userMobileNumber) {
        //select checkbox of Mr
        clicking(driver, genderMrRadioButton);

        sendData(driver, passwordFeald, pass);
        LogUtils.info("Password: " + pass);

        sendData(driver, firstNameInput, userFirstName);
        LogUtils.info("First Name: " + userFirstName);

        sendData(driver, lastNameInput, userLastName);
        LogUtils.info("Last Name: " + userLastName);

        selectFromDropDown(driver, daysSelect, day);
        LogUtils.info("Day: " + day);

        selectFromDropDown(driver, monthsSelect, month);
        LogUtils.info("Month: " + month);

        selectFromDropDown(driver, yearsSelect, year);
        LogUtils.info("Year: " + year);

        clicking(driver, signUpForNewsletter);
        clicking(driver, specsOffersoptin);

        sendData(driver, companyNameInputField, company);
        LogUtils.info("Company Name: " + company);

        sendData(driver, addressOneInput, userAddressOne);
        LogUtils.info("Address One: " + userAddressOne);

        sendData(driver, addressTwoInput, userAddressTwo);
        LogUtils.info("Address Two: " + userAddressTwo);

        selectFromDropDown(driver, countrySelect, country);
        LogUtils.info("Country: " + country);

        sendData(driver, stateInput, state);
        LogUtils.info("State: " + state);

        sendData(driver, cityInput, city);
        LogUtils.info("City: " + city);

        sendData(driver, zipcodeInput, zipCode);
        LogUtils.info("Zip Code: " + zipCode);

        sendData(driver, mobileNumberInput, userMobileNumber);
        LogUtils.info("Mobile Number: " + userMobileNumber);

        return this;
    }


    public void navigateToRegisterPage() {
        openWebsite(getEnvironmentPropertyValue("REGISTER_URL"));
    }

    public void createAccount() {
        scrollToElement(driver, createAccountButton);
        clicking(driver, createAccountButton);
    }


    //Validations
    public boolean checkSuccessMessageAccountCreated(String expectedText) {
        return verifyEquals(accountCreated, expectedText);
    }


    ////////////////////////////////////////////////////////////
    public P01_RegisterPage enterSignupInfo(String nameParam, String emailParam) {
        sendData(driver, this.signUpName, nameParam);
        LogUtils.info("Name: " + nameParam);
        sendData(driver, this.signUpEmail, emailParam);
        LogUtils.info("Email: " + emailParam);
        return this;
    }

    public P01_RegisterPage clickOnSignupButton() {
        clicking(driver, signUpButton);
        return this;
    }

    //Validations
    public boolean verifyThatErrorMessageAppears(String expectedText) {
        return verifyEquals(errorMsg, expectedText);

    }

    public boolean verifyThatNewUserSignupAppears(String expectedText) {
        return verifyEquals(newUserSignupMessage, expectedText);
    }

}
