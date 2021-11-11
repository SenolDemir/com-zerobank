package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivityPage {

    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(), this); }

    @FindBy(linkText = "/bank/redirect.html?url=account-activity.html")
    public WebElement accountActivityPage;

    @FindBy(id = "aa_accountId")
    public WebElement dropdownElement;

    @FindBy(id = "aa_accountId")
    public WebElement accountOptions;

    @FindBy(xpath = "//table[@class='table table-condensed table-hover']//th")
    public List<WebElement> columnNames;

    @FindBy(xpath = "//a[.='Find Transactions']")
    public WebElement findTransactionTab;

    @FindBy(id= "aa_description")
    public WebElement descriptionInput;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDateInput;

    @FindBy(id = "aa_toDate")
    public WebElement toDateInput;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[1]")
    public List<WebElement> allDates;

    @FindBy(xpath = "//button[.='Find']")
    public WebElement findButton;

    @FindBy(xpath = "//table[@class='table table-condensed table-hover'])[2]")
    public WebElement resultTable;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//td[2]")
    public List<WebElement> descriptionResults;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//td[3]")
    public  List<WebElement> depositResults;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//td[4]")
    public List<WebElement> withdrawalResults;

    @FindBy(id = "aa_type")
    public WebElement type;




}
