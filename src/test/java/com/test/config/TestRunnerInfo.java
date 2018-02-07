package com.test.config;

import com.test.flows.WebFlow;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import com.appium.manager.AppiumDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestRunnerInfo {

    public DeviceInterface runnerInfo;
    static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    PropertyReader propertyReader;
    ViewFactory viewFactory;

    public TestRunnerInfo() {
        propertyReader = PropertyReader.getInstance();
        runnerInfo = runnerInfoStatus();
    }

    public DeviceInterface getRunnerInfo() {
        return runnerInfo;
    }

    public DeviceInterface runnerInfoStatus() {
        try {

            AppiumDriverManager.getDriver().getPlatformName();
            viewFactory = new ViewFactory(AppiumDriverManager.getDriver());
            runnerInfo = viewFactory.getMobilePlatform(AppiumDriverManager.getDriver().
                            getCapabilities().getCapability("platformName").toString(),
                    AppiumDriverManager.getDriver());
            driver.set(AppiumDriverManager.getDriver());
            return runnerInfo;


        } catch (Exception e) {
            driver.set(DriverManager.getDriver());
            return new WebFlow(DriverManager.getDriver());
        }
    }
    public String getPlatform(WebDriver driver) {

        if (propertyReader.readProperty("PLATFORM").equals("Android") || propertyReader.readProperty("PLATFORM").equals("IOS") || propertyReader.readProperty("PLATFORM").equals("Mobile"))  {
            Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

            String devicName = cap.getCapability("deviceName").toString();

            if (devicName.startsWith("i")) {
                return "IOS";
            } else {
                return "Android";
            }
        } else {
            return "Desktop";
        }
    }

    public WebDriver getDriverSession() {
        return driver.get();
    }
}
