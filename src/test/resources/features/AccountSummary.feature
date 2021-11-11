Feature: Account Summary Page

  Background:
    Given the user is logged in
    When Account summary page should be displayed

  Scenario: Account summary page should have the title "Zero – Account summary"
    Then The page should have the title "Zero – Account summary"


  Scenario: Account Types in Account Summary page
    Then Account summary page should have to following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |


  Scenario: Credit Accounts table columns
    Then Credit Accounts table must have following columns
      | Account     |
      | Credit Card |
      | Balance     |

