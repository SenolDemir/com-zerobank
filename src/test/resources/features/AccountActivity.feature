
Feature: Account Activity page

  Background:
    Given the user is logged in
    When navigate to Account Activity Page


    Scenario: Account Activity page should have the title "Zero – Account activity"
      Then The page should have the title "Zero - Account Activity"

    Scenario: Default Option in the Account drop down
      Then in the Account drop down default option should be "Savings"

    Scenario: Account drop down
      Then Account dropdown should have the following options
        |Savings     |
        |Checking   |
        |Loan       |
        |Credit Card|
        |Brokerage  |

    Scenario: Transactions table
      Then Transaction table should have following column names
        |Date       |
        |Description|
        |Deposit    |
        |Withdrawal |

