package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityStepDefs {


    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @When("navigate to Account Activity Page")
    public void navigate_to_Account_Activity_Page() {

        WebElement accountActivity = Driver.get().findElement(By.linkText("Account Activity"));
        accountActivity.click();
        BrowserUtils.waitFor(2);
        System.out.println(Driver.get().getTitle());
    }


    @Then("in the Account drop down default option should be {string}")
    public void in_the_Account_drop_down_default_option_should_be(String expectedOption) {

        Select accountDropdown = new Select(accountActivityPage.accountOptions);
        String actualOption = accountDropdown.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);
        Assert.assertEquals(actualOption, expectedOption);

    }

    @Then("Account dropdown should have the following options")
    public void account_dropdown_should_have_the_following_options(List<String> expectedAccountOptions) {

        Select accountDropdown = new Select(accountActivityPage.accountOptions);
        List<WebElement> optionList = accountDropdown.getOptions();
        System.out.println("accountOptions.size() = " + optionList.size());

        optionList.remove(2);
        List<String > actualAccountOptions = BrowserUtils.getElementsText(optionList);

        for (WebElement option : optionList){
            System.out.println(option.getText());
        }

        Assert.assertEquals(expectedAccountOptions,actualAccountOptions);

    }


    @Then("Transaction table should have following column names")
    public void transaction_table_should_have_following_column_names(List<String> expectedHeaders) {

       for (WebElement option : accountActivityPage.columnNames){
            System.out.println(option.getText());
        }
        List<String> actualHeaders = BrowserUtils.getElementsText(accountActivityPage.columnNames);
        for (String option : actualHeaders){
            System.out.println(option);
        }

        Assert.assertEquals(expectedHeaders, actualHeaders);



    }


}
