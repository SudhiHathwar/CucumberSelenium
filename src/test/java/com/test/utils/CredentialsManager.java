package com.test.utils;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CredentialsManager {

    public String getCredentials(String tocName,String env) {

        String credentials =
                "testUser" + env + tocName + Thread.currentThread().getName() + "@gmail.com";
/*        customerRegistration(tocName,env,
                credentials);*/
        return credentials;
    }

    public String generateEmail() {
        int min = 10000;
        int max = 30000;
        int res = min + (int) (Math.random() * ((max - min) + 1));
        String r = Integer.toString(res);
        return r + "Seasonstest@thetrainline.com";
    }

    public void customerRegistration(String tocName, String env, String userName) {

        String reqJson = null;

        HashMap<String,String> environmentMap=new HashMap<>();
        environmentMap.put("APP","APPNAME");

        RestAssured.baseURI = "https://" + env + "domain" + environmentMap.get(tocName) + "rest of the url";


        given().
                config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation())).
                contentType("application/x-www-form-urlencoded").
                body(reqJson).
                when().
                post("").getBody().asString();

    }

    public static void main(String Args[]) {
        CredentialsManager credentialsManager =  new CredentialsManager();
        System.out.println(credentialsManager.getCredentials("app","env"));
    }
}
