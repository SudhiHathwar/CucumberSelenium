package com.test.config;

import java.io.*;
import java.util.Properties;

public class PropertyReader {

    Properties envProperties = new Properties();
    Properties envSpecProperties = new Properties();

    public static PropertyReader instance;

    InputStream inputStreamConfig;
    InputStream inputStreamEnvSpecConfig;
    InputStream inputStreamExternalConfig;

    public static PropertyReader getInstance() {
        if (instance == null) {
            instance = new PropertyReader();
        }
        return instance;
    }
    public PropertyReader() {
        getEnvironment();
    }

    private void getEnvironment() {
        try {
                inputStreamConfig = PropertyReader.class.getResourceAsStream("/properties/config.properties");
                envProperties.load(inputStreamConfig);
                loadPropertiesPerEnv();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void loadPropertiesPerEnv() {
        try {
            String environment = System.getenv("EnvironmentName");
            if( environment == null ) {
                environment = envProperties.getProperty("environment");
            }
            if (environment.toLowerCase().contains("prodonline") || environment.toLowerCase().equalsIgnoreCase("pr1")) {
                inputStreamEnvSpecConfig = PropertyReader.class.getResourceAsStream("/properties/prod_config.properties");
            } else if (environment.toLowerCase().contains("prodoffline")) {
                inputStreamEnvSpecConfig = PropertyReader.class.getResourceAsStream("/properties/prod-offline_config.properties");                inputStreamExternalConfig = PropertyReader.class.getResourceAsStream("/properties/externalLinks.properties");
            } else {
                inputStreamEnvSpecConfig = PropertyReader.class.getResourceAsStream("/properties/non-prod_config.properties");
            }
            envSpecProperties.load(inputStreamEnvSpecConfig);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public String readProperty(String key) { return envProperties.getProperty(key);}
    public String readEnvSpecProperty(String key) {
        return envSpecProperties.getProperty(key);
    }

}
