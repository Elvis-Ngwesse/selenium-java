@Regression
Feature: Test login

  Scenario: Check User login/logout with valid credentials
    Given User navigates to herokuapp homepage
    When  User enters "tomsmith4" and "SuperSecretPassword!"
    And   User clicks on login button
    And   User should see message "You logged into a secure area!"
    And   User clicks on logout button
    Then  User should see message "You logged out of the secure area!"
    Then  User verifies page url "http://the-internet.herokuapp.com/login"