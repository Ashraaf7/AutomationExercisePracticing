package com.automationexercise.apis;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;


public class ApiService {
    public void registrationApi(String name, String email,String password,String firstname,String lastname,
                                String company,String address1,String country,String zipcode,String state,String city,String mobile_number) {
         RestAssured.baseURI = "http://automationexercise.com";
        RestAssured.given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("name", name)
                .formParam("email", email)
                .formParam("password", password)
                .formParam("firstname",firstname)
                .formParam("lastname",lastname)
                .formParam("company",company)
                .formParam("address1",address1)
                .formParam("country",country)
                .formParam("zipcode",zipcode)
                .formParam("state",state)
                .formParam("city",city)
                .formParam("mobile_number",mobile_number)
                .when()
                .post("/api/createAccount")
                .then().log().body();
    }

public void loginApi(String email, String password)
{
    RestAssured.baseURI = "http://automationexercise.com";
    RestAssured.given()
        .contentType("application/x-www-form-urlencoded")
        .formParam("email", email)
        .formParam("password", password)
        .when()
        .post("/api/verifyLogin")
        .then().log().body();

}
}
