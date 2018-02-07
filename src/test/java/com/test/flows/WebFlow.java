package com.test.flows;

import com.test.config.DeviceInterface;
import com.test.config.Messages;
import com.test.config.WebMessages;
import org.openqa.selenium.*;

public class WebFlow implements DeviceInterface {

    WebDriver webDriver;
    DeviceInterface runnerInfo;

    public WebFlow(WebDriver driver) {
        this.webDriver = driver;

        //homePageObjects = new HomePageObjects();
        // PageFactory.initElements(driver, homePageObjects);

    }

    @Override
    public Messages getMessages() {
        return new WebMessages();
    }
}
