package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.List;

public class AccountSummaryPage {

    public AccountSummaryPage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement> accountTypeElements;

    @FindBy(xpath = "(//a[.='Savings'])[1]")
    public WebElement savingsLink;

    @FindBy(xpath = "//a[.='Brokerage']")
    public WebElement brokerageLink;

    @FindBy(xpath = "//a[.='Checking']")
    public WebElement checkingLink;

    @FindBy(xpath = "//a[.='Credit Card']")
    public WebElement creditCardLink;

    @FindBy(xpath = "//a[.='Loan']")
    public WebElement loanLink;




    public List<String> getCreditAccountHeaders(){

        List<String> creditAccountHeaders = new ArrayList<>();
        for (int i=1; i<=3; i++){
            String xpath = "(//table[@class='table'])[3]//th["+i+"]";
            creditAccountHeaders.add(Driver.get().findElement(By.xpath(xpath)).getText());
        }
        System.out.println(creditAccountHeaders);
        return  creditAccountHeaders;
    }




}
