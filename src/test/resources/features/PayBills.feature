Feature: Pay Bills Page

  Background:
    Given the user is logged in
    And the user navigate to Pay Bills
    Then The page should have the title "Zero - Pay Bills"


  Scenario: Succesfull pay operation
    When the user completes a successful pay operation
    Then "The payment was successfully submitted" should be displayed


  Scenario: Wrong pay operation
    When the user tries to make a payment without entering the amount or date
    Then "Please fill out this field." message should be displayed

        #Amount field should not accept alphabetical or special characters. Date field should
        #not accept alphabetical characters.