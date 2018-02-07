package com.test.pages;

import com.test.config.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen {

    private WebDriver driver;
    private DeviceHelper helper;

    public LoginScreen() {
        this.driver = DriverManager.getDriver();
        helper = new DeviceHelper(driver);
        PageFactory.initElements(driver, this);
    }

    @AndroidBy(className = "")
    @iOSFindBy(className = "")
    @FindBy(id="identifierNext")
    public WebElement userNameNextBtn;

    @AndroidBy(className = "")
    @iOSFindBy(className = "")
    @FindBy(id="identifierId")
    private WebElement userNameField;

    @AndroidBy(className = "")
    @iOSFindBy(className = "")
    @FindBy(name = "password")
    private WebElement passwordField;

    @AndroidBy(className = "")
    @iOSFindBy(className = "")
    @FindBy(id="passwordNext")
    private WebElement passwordNextBtn;

    @AndroidBy(className = "")
    @iOSFindBy(className = "")
    @FindBy(xpath="//a[contains(@title, 'Google Account: ')]")
    public WebElement myAccountIcon;

    public  void performLogin(String userName, String password){
        userNameField.sendKeys(userName);
        userNameNextBtn.click();

        helper.waitForElementToAppear(passwordField);

        passwordField.sendKeys(password);
        passwordNextBtn.click();
    }
}
