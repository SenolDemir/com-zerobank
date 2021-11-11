package com.zerobank.pages;


import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PayBillsPage {

    public PayBillsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "sp_amount")
    public WebElement amountInput;

    @FindBy(id = "sp_date")
    public WebElement dateInput;

    @FindBy(id = "sp_account")
    public WebElement accountDropdown;

    @FindBy(id = "sp_payee")
    public WebElement payeeElement;

    @FindBy(id = "sp_description")
    public WebElement descriptionInput;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement payButton;

    @FindBy(xpath = "//a[.='Add New Payee']")
    public WebElement addNewPayTab;

    @FindBy(id = "np_new_payee_name")
    public WebElement newPayeeNameInput;

    @FindBy(id = "np_new_payee_address")
    public WebElement newPayeeAddressInput;

    @FindBy(id = "np_new_payee_account")
    public WebElement newPayeeAccountInput;

    @FindBy(id = "np_new_payee_details")
    public WebElement newPayeeDetailInput;

    @FindBy(id = "add_new_payee")
    public WebElement addNewPayButton;

    @FindBy(id = "alert_content")
    public WebElement newPayMessage;

    @FindBy(xpath = "//a[.='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrencyTab;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropdown;

    @FindBy(id = "pc_amount")
    public WebElement payeeAmountInput;

    @FindBy(id = "purchase_cash")
    public WebElement costCalculateBtn;





    public void getPaySubmit() {

        Select payeeDropdown = new Select(payeeElement);
        payeeDropdown.selectByVisibleText("Bank of America");

        Select accountOptions = new Select(accountDropdown);
        accountOptions.selectByVisibleText("Savings");

        amountInput.sendKeys("10");
        dateInput.sendKeys("2020-11-18");


        descriptionInput.sendKeys("Sample");

        payButton.click();

    }


}
