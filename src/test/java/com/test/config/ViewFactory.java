package com.test.config;

import com.test.flows.MobileFlow;
import com.test.flows.WebFlow;
import org.openqa.selenium.WebDriver;

public class ViewFactory extends DeviceHelper{

    private MobileFlow mobileFlow;
    private WebFlow webFlow;

    public ViewFactory(WebDriver driver) {
        super(driver);
    }

    public DeviceInterface getMobilePlatform(String platform, WebDriver driver) {
        if (platform == null) {
            return null;
        }
            return mobileFlow = new MobileFlow((WebDriver) driver);
    }
}