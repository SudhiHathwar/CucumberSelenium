package com.test.config;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;

public class JsonParser {

    public static JSONObject getUserData(String toc, int threadID) {
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        try {

            Object jsonFile = parser.parse(new FileReader("./src/test/resources/properties/" +
                    "credentials.json"));
            JSONObject jsonData = (JSONObject) jsonFile;
            JSONArray credentialsObj = (JSONArray) jsonData.get("credentials");
            JSONObject tocCredentials = (JSONObject) credentialsObj.get(threadID);
            JSONObject credentials = (JSONObject) tocCredentials.get(toc);
            return credentials;

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Unable to parse json file");
        return null;
    }

    public static void main(String args[]) {
        JSONObject a = getUserData("", 0);

        System.out.println(a);
        System.out.println(a.get("userName"));
        System.out.println(a.get("password"));
    }
}
