@Regression
Feature: Test login error
  Background: Navigate to home page
    Given User navigates to herokuapp homepage

  Scenario: Check error message with no username and password
    When  User enters "" and ""
    And   User clicks on login button
    Then  User should see error message "Your username is invalid!"

  Scenario: Check error message with valid username and password
    When  User enters "tomsmith" and ""
    And   User clicks on login button
    Then  User should see error message "Your password is invalid!"

  Scenario: Check error message with invalid username and password
    When  User enters "James" and ""
    And   User clicks on login button
    Then  User should see error message "Your username is invalid!"

  Scenario: Check error message with valid username and invalid password
    When  User enters "tomsmith" and "SuperSecretPassword!!"
    And   User clicks on login button
    Then  User should see error message "Your password is invalid!"

  Scenario: Check error message with invalid username and invalid password
    When  User enters "tomsmithh" and "SuperSecretPassword!!"
    And   User clicks on login button
    Then  User should see error message "Your username is invalid!"