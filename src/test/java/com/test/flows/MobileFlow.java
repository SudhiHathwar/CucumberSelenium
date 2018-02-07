package com.test.flows;

import com.test.config.DeviceInterface;
import com.test.config.Messages;
import com.test.config.WebMessages;
import org.openqa.selenium.WebDriver;

public class MobileFlow implements DeviceInterface {

    WebDriver webDriver;
    DeviceInterface runnerInfo;

    public MobileFlow(WebDriver driver) {
        this.webDriver = driver;

        //homePageObjects = new HomePageObjects();
        // PageFactory.initElements(driver, homePageObjects);
    }

    @Override
    public Messages getMessages() {
        return new WebMessages();
    }
}
