package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class LoginStepsDefs{


    @Given("the user in login page")
    public void the_user_in_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        new LoginPage().signInBtn.click();
        BrowserUtils.waitFor(3);



    }

    @When("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() {
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        new LoginPage().login(username,password);
        BrowserUtils.waitFor(3);


    }

    @Then("Account summary page should be displayed")
    public void account_summary_page_should_be_displayed() {

        String expectedTitle = "Zero - Account Summary";
        String pageTitle = Driver.get().getTitle();
        System.out.println(pageTitle);
        Assert.assertEquals(expectedTitle, pageTitle);

    }

    @When("the user tries to login with invalid {string} and {string}")
    public void the_user_tries_to_login_with_invalid_and(String username, String password) {
        new LoginPage().login(username, password);
    }



    @Then("the user should not be able to login with invalid information")
    public void the_user_should_not_be_able_to_login_with_invalid_information() {

        String expectedTitle = "Zero - Account Summary";
        String pageTitle = Driver.get().getTitle();
        Assert.assertNotEquals(expectedTitle, pageTitle);

    }

    @Then("error message {string} should be displayed.")
    public void error_message_should_be_displayed(String expectedErrorMessage) {


        String actualMessage = new LoginPage().errorAlert.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedErrorMessage, actualMessage);

    }

}