@Regression
Feature: Test login functionality

  Scenario: Check login with valid credentials
    Given User navigates to homepage
    When  User enters "username" and "password"
    And   User clicks on login button
    Then  User should see message "You logged into a secure area!"