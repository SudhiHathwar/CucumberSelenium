package com.test.stepDefinitions;

import com.test.config.DriverFactory;
import com.test.config.DriverManager;
import com.test.config.Hooks;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.test.utils.*;
import com.test.pages.*;

public class Login {

    public LoginScreen loginScreen;

    public Login(){
        loginScreen = new LoginScreen();
    }

    @Given("^Navigate to Login page$")
    public  void loadUrl() throws Throwable{
        URLGetter getUrl = new URLGetter();
        DriverManager.getDriver().navigate().to(getUrl.getURLs("GMAIL"));
    }

    @When("^User enters valid username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public  void enterUserNamePassword(String userName, String password) throws  Throwable{
        loginScreen.performLogin(userName, password);
    }

    @Then("^User must be logged in and MyAccount icon must be displayed$")
    public void verifyIsUserLoggedIn(){
        loginScreen.myAccountIcon.isDisplayed();
    }
}
