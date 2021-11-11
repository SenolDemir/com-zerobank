package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FindTransactionStepsDefs {

    AccountActivityPage accountActivityPage = new AccountActivityPage();



    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        accountActivityPage.findTransactionTab.click();

    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        BrowserUtils.waitFor(3);
        accountActivityPage.fromDateInput.clear();
        accountActivityPage.fromDateInput.sendKeys(fromDate);
        accountActivityPage.toDateInput.clear();
        accountActivityPage.toDateInput.sendKeys(toDate);

    }

    @When("clicks search")
    public void clicks_search() {
        BrowserUtils.waitFor(3);
        accountActivityPage.findButton.click();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to (String fromDate, String toDate) throws ParseException {
        BrowserUtils.waitFor(3);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date firstDay = dateFormat.parse(fromDate);
        Date lastDay = dateFormat.parse(toDate);

        List<String> allDatesString = BrowserUtils.getElementsText(accountActivityPage.allDates);
        List<Date> actualDates = new ArrayList<>();
        BrowserUtils.waitFor(3);
        for (String stringDate: allDatesString){
            actualDates.add(dateFormat.parse(stringDate));

        }

        boolean isBetween = false;
        for (int i=0; i<actualDates.size(); i++) {
            if (actualDates.get(i).compareTo(firstDay) == 0 || actualDates.get(i).compareTo(firstDay) > 0 &&
                actualDates.get(i).compareTo(lastDay) == 0 || actualDates.get(i).compareTo(lastDay) < 0 ) {
                isBetween=true;
            }
            }
                Assert.assertTrue(isBetween);
        }


    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws ParseException {

        BrowserUtils.waitFor(3);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> allDatesString = BrowserUtils.getElementsText(accountActivityPage.allDates);
        List<Date> actualDates = new ArrayList<>();
        BrowserUtils.waitFor(3);

        for (String stringDate: allDatesString){
            actualDates.add(dateFormat.parse(stringDate));
        }

        boolean mostRecent = false;
        for (int i=0; i<actualDates.size()-1; i++){
            if (actualDates.get(i).compareTo(actualDates.get(i+1))>0){
                mostRecent=true;
                System.out.println(actualDates.get(i) +" is after then " + actualDates.get(i+1) );
            }
        }
        Assert.assertTrue(mostRecent);

    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        BrowserUtils.waitFor(3);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> allDatesString = BrowserUtils.getElementsText(accountActivityPage.allDates);

        boolean cointain = true;
        for (int i=0; i<allDatesString.size(); i++){
            if(allDatesString.get(i).contains(date)){
                cointain=false;
            }
        }
        Assert.assertTrue(cointain);
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String input) {
        BrowserUtils.waitFor(3);
        accountActivityPage.descriptionInput.clear();
        accountActivityPage.descriptionInput.sendKeys(input);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String input) {
        BrowserUtils.waitFor(3);
        List<String> descriptionTexts = BrowserUtils.getElementsText(accountActivityPage.descriptionResults);
        System.out.println(descriptionTexts);

        for (String descriptionText : descriptionTexts){
            Assert.assertTrue(descriptionText.contains(input));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String str) {
        BrowserUtils.waitFor(3);
        List<String> descriptionTexts = BrowserUtils.getElementsText(accountActivityPage.descriptionResults);
        System.out.println(descriptionTexts);

        for (String descriptionText : descriptionTexts){
            Assert.assertFalse(descriptionText.contains(str));
        }
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String type) {
       BrowserUtils.waitFor(3);
        Select typeDropdown = new Select(accountActivityPage.type);
        List<String> depositCells = BrowserUtils.getElementsText(accountActivityPage.depositResults);
        List<String> withdrawalCells = BrowserUtils.getElementsText(accountActivityPage.withdrawalResults);

        switch (type) {
            case "Deposit":
                Assert.assertTrue(depositCells.size()>0);
                break;
            case "Withdrawal":
                Assert.assertTrue(withdrawalCells.size()>0);
                break;
        }


    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        Select typeDropdown = new Select(accountActivityPage.type);
            typeDropdown.selectByVisibleText(type);
            accountActivityPage.findButton.click();
            BrowserUtils.waitFor(2);

    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String type) {
        BrowserUtils.waitFor(3);
        Select typeDropdown = new Select(accountActivityPage.type);
        List<String> depositCells = BrowserUtils.getElementsText(accountActivityPage.depositResults);
        List<String> withdrawalCells = BrowserUtils.getElementsText(accountActivityPage.withdrawalResults);

        switch (type) {
            case "Deposit":
                Assert.assertTrue(depositCells.get(0).equals(""));
                break;
            case "Withdrawal":
                Assert.assertTrue(withdrawalCells.get(0).equals(""));
                break;
        }
    }




}
