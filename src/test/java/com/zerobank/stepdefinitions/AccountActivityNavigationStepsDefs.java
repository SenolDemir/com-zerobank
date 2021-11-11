package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityNavigationStepsDefs {

    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();


    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String accountType) {



        switch (accountType){
            case "Savings":
                accountSummaryPage.savingsLink.click();
                break;
            case "Brokerage":
                accountSummaryPage.brokerageLink.click();
                break;
            case "Checking":
                accountSummaryPage.checkingLink.click();
                break;
            case "Credit Card":
                accountSummaryPage.creditCardLink.click();
                break;
            case "Loan":
                accountSummaryPage.loanLink.click();
                break;

        }


    }


    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String expectedPage) {

        System.out.println(Driver.get().getTitle());
        String actualPage = Driver.get().getTitle();
        //Assert.assertEquals(Driver.get().getTitle(), expectedPage);
        Assert.assertTrue(actualPage.contains(expectedPage));

    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedOption) {

        Select accountDropdown = new Select(accountActivityPage.accountOptions);
       String selectedOption = accountDropdown.getFirstSelectedOption().getText();
        System.out.println("selectedOption = " + selectedOption);

        Assert.assertEquals(selectedOption, expectedOption);


    }



}
