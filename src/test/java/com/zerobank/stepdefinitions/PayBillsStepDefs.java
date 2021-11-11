package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class PayBillsStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Given("the user navigate to Pay Bills")
    public void the_user_navigate_to_Pay_Bills() {
        WebElement payBills = Driver.get().findElement(By.linkText("Pay Bills"));
        payBills.click();
        BrowserUtils.waitFor(2);
        System.out.println(Driver.get().getTitle());
    }

    @When("the user completes a successful pay operation")
    public void the_user_completes_a_successful_pay_operation() {
        new PayBillsPage().getPaySubmit();


    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String paymentMessage) {
        WebElement successfullMessage = Driver.get().findElement(By.xpath("//span[.='The payment was successfully submitted.']"));
        successfullMessage.getText().contains(paymentMessage);
        System.out.println("paymentMessage = " + paymentMessage);
        Assert.assertTrue(successfullMessage.getText().contains(paymentMessage));
    }

    @When("the user tries to make a payment without entering the amount or date")
    public void the_user_tries_to_make_a_payment_without_entering_the_amount_or_date() {


        Select payeeDropdown = new Select(payBillsPage.payeeElement);
        payeeDropdown.selectByVisibleText("Bank of America");

        Select accountOptions = new Select(payBillsPage.accountDropdown);
        accountOptions.selectByVisibleText("Savings");

        payBillsPage.amountInput.sendKeys("10");
        String amount = payBillsPage.amountInput.getAttribute("value");


        payBillsPage.dateInput.sendKeys("");
        System.out.println(payBillsPage.dateInput.getAttribute("value"));

        payBillsPage.descriptionInput.sendKeys("Sample");
        payBillsPage.payButton.click();



        //Amount field should not accept alphabetical or special characters.
    }


    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectedMessage) {

        //Alert alert = Driver.get().switchTo().alert();
        //Assert.assertFalse(alert.getText().isEmpty());
        //alert.accept();

        String actualMessage = Driver.get().findElement(By.id("sp_date")).getAttribute("validationMessage");
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);

    }


    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        BrowserUtils.waitFor(3);
        payBillsPage.addNewPayTab.click();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> payInfo) {

        BrowserUtils.waitFor(3);
        payBillsPage.newPayeeNameInput.sendKeys(payInfo.get("Payee Name"));
        payBillsPage.newPayeeAddressInput.sendKeys(payInfo.get("Payee Address"));
        payBillsPage.newPayeeAccountInput.sendKeys(payInfo.get("Account"));
        payBillsPage.newPayeeDetailInput.sendKeys(payInfo.get("Payee details"));
        payBillsPage.addNewPayButton.click();


    }


    @Then("the message {string} should be displayed")
    public void the_message_should_be_displayed(String expectedMessage) {

        BrowserUtils.waitFor(3);
        String actualMessage = payBillsPage.newPayMessage.getText();
        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        BrowserUtils.waitFor(3);
        payBillsPage.purchaseForeignCurrencyTab.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencies) {
        BrowserUtils.waitFor(3);
        Select currencyDropdown = new Select(payBillsPage.currencyDropdown);
        List<String> currencyList = BrowserUtils.getElementsText(currencyDropdown.getOptions());
        currencyList.remove(0);
        for(String str: currencies){
            Assert.assertTrue(currencyList.contains(str));
        }

    }

        @When("user tries to calculate cost without selecting a currency")
        public void user_tries_to_calculate_cost_without_selecting_a_currency() {
          BrowserUtils.waitFor(3);
            payBillsPage.payeeAmountInput.sendKeys("100");
            payBillsPage.costCalculateBtn.click();
        }

        @Then("error message should be displayed")
        public void error_message_should_be_displayed() {

            Alert alert = Driver.get().switchTo().alert();
            BrowserUtils.waitFor(3);
            System.out.println(alert.getText());
            Assert.assertFalse(alert.getText().isEmpty());
            alert.accept();


        }


    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        BrowserUtils.waitFor(3);
        Random rand = new Random();
        Select currencyDropdown = new Select(payBillsPage.currencyDropdown);
        int rnd = rand.nextInt(currencyDropdown.getOptions().size());
        currencyDropdown.selectByIndex(rnd);

        payBillsPage.costCalculateBtn.click();

    }








}
