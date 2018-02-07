package com.test.utils;


import com.test.config.*;

public class URLGetter {
    String toc_name;

    public String getURLs(String portalName) {
        PropertyReader propertyReader = new PropertyReader();
        String url = propertyReader.readEnvSpecProperty(portalName);
        String environment = getEnvironment();
        if (!environment.toLowerCase().contains("pr")) {
            return "https://" + url;
        } else {
            System.out.println(url);
            return "https://" + url;
        }
    }

    public String getEnvironment() {
        String environment = System.getenv("EnvironmentName");
        if( environment == null ) {
            environment = new PropertyReader().readProperty("environment");
        }
        return environment;
    }

    public String getPassword() {
        return "password";
    }

    public String getPortalName() {
        return toc_name;
    }

    public static void main(String Args[]) {
        URLGetter a = new URLGetter();

    }


}
