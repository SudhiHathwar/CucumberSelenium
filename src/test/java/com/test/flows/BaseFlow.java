package com.test.flows;

import com.test.config.DeviceHelper;
import org.openqa.selenium.WebDriver;

public class BaseFlow {

    WebDriver driver;
    DeviceHelper deviceHelper;
    //HomePageObjects homePageObjects;

    public BaseFlow(WebDriver driver) {
        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        //homePageObjects = new HomePageObjects();
        //PageFactory.initElements(driver, homePageObjects);
    }
}
