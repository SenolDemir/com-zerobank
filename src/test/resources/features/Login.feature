Feature: Login

  Background:
    Given the user in login page

  Scenario: Only authorized users should be able to login to the application
    When the user logs in with valid credentials
    Then Account summary page should be displayed

  Scenario Outline: Users with invalid information should not be able to login
    When the user tries to login with invalid "<username>" and "<password>"
    Then the user should not be able to login with invalid information
    And error message "Login and/or password are wrong." should be displayed.

    Examples:
      | username | password |
      | mike     | password |
      | username | smith    |
      | mike     | smith    |
      |          |          |






