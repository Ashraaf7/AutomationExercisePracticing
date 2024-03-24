package com.automationexercise.Pages;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class RegistrationService {
    public static void registerTestCase(String name, String email,String password,String firstname,String lastname,
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
    }


}
