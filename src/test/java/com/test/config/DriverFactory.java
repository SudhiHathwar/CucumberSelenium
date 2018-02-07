package com.test.config;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class DriverFactory {
    private static String OS = System.getProperty("os.name").toLowerCase();
    private static EventFiringWebDriver e_driver;
    private static EventListener eventListener;

    public static WebDriver createInstance(String browserName) {
        WebDriver driver = null;
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.ALL);

        switch(browserName.toLowerCase()){
            case "chrome":

                System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximised");
                driver = new ChromeDriver(options);
                break;

            case "firefox":

                System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;

            case "edge":
                System.setProperty("webdriver.edge.driver", "./drivers/MicrosoftWebDriver");
                driver = new EdgeDriver();
            break;

            case "ie":
                System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                        true);
                driver = new InternetExplorerDriver(capabilities);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                driver.manage().window().setSize(new Dimension(1024,768));
                break;

            case "safari":
                driver = new SafariDriver();
                driver.manage().window().maximize();
                break;
        }

        e_driver = new EventFiringWebDriver(driver);
        eventListener = new EventListener();
        e_driver.register(eventListener);

        return e_driver;
    }
}
