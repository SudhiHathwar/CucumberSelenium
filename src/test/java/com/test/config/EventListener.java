package com.test.config;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EventListener extends AbstractWebDriverEventListener implements WebDriverEventListener {

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) { }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Running Tests On: "+ url);
    }

    // Need to implement Extent Report functionality

    @Override
    public void onException(Throwable throwable, WebDriver webdriver) {
    }

    // Need to implement function to verify whether the element is stale.

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        }

    // Before Click() function

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("Unable to Find Element");
        }
    }

    // After Click() function

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {}

    // Before SendKeys("") and Clear() functions


    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        try {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    } catch (Exception e) {
        System.out.println("Unable to Find Element");
    }}

    // After SendKeys("") and Clear() functions

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) { }

    // Called before RemoteWebDriver.executeScript(java.lang.String, java.lang.Object[]) -- Need to check how it can be utilized

    @Override
    public void beforeScript(String script, WebDriver driver) {
        // TODO Auto-generated method stub
    }

    // Called before RemoteWebDriver.executeScript(java.lang.String, java.lang.Object[])

    @Override
    public void afterScript(String script, WebDriver driver) {
        // TODO Auto-generated method stub
    }
}


//        for (int i = 0; i < 1; i++) {
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript(
//                    "arguments[0].setAttribute('style', arguments[1]);",
//                    element, "color: black; border: 3px solid grey;");}
