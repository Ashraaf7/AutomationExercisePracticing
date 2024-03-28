package com.automationexercise.apis;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;


public class ApiService {
//private static final  String baseURI = "http://automationexercise.com";
  /*  public static void registerTestCase(String name, String email,String password,String firstname,String lastname,
                                        String company,String address1,String country,String zipcode,String state,String city,String mobile_number ) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://automationexercise.com/api/createAccount"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"name\": \"" + name + "\", \"email\": \"" +email+ "\",\"password\":\""+password+"\" , \"firstname\":\"" + firstname + "\", \"lastname\":\""
                        + lastname + "\", \"company\":\"" +company+ "\", \"address1\": \"" + address1 + "\"" +
                        ", \"country\":\""+ country+"\",\"zipcode\": \"" + zipcode +"\",\"state\":\"" +state + "\"," +
                        " \"city\":\"" + city +"\",\"mobile_number\":\""+mobile_number+"\"}")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Registration Status: " + response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
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
