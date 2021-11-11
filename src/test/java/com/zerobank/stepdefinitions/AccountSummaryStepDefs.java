package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryStepDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        new LoginPage().signInBtn.click();
        BrowserUtils.waitFor(3);
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        new LoginPage().login(username,password);
        BrowserUtils.waitFor(3);
    }

    @Then("The page should have the title {string}")
    public void the_page_should_have_the_title(String expectedTitle) {
        String pageTitle = Driver.get().getTitle();
        System.out.println(pageTitle);
        Assert.assertEquals(expectedTitle, pageTitle);
    }



    @Then("Account summary page should have to following account types")
    public void account_summary_page_should_have_to_following_account_types(List<String> expectedAccountType) {

        List<String> actualAccountTypes = new ArrayList<>();

        for (int i=1; i<=4; i++){
            String xpath = "(//h2[@class='board-header'])["+i+"]";
            actualAccountTypes.add(Driver.get().findElement(By.xpath(xpath)).getText());
        }

        System.out.println(actualAccountTypes);
        Assert.assertEquals(expectedAccountType,actualAccountTypes);

    }

    @Then("Credit Accounts table must have following columns")
    public void credit_Accounts_table_must_have_following_columns(List<String> expectedCreditAccountTable) {

        List<String> actualCreditAccountHeaders = new AccountSummaryPage().getCreditAccountHeaders();
        System.out.println(actualCreditAccountHeaders);
        Assert.assertEquals(expectedCreditAccountTable,actualCreditAccountHeaders);
    }



}
