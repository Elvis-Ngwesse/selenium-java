@Regression
Feature: Test Status Code

  Background: Navigate to home page
    Given User navigates to herokuappstatuscode homepage

  Scenario Outline: Check page returns 200 status code

    When  User clicks on status code <status_codes>
    Then  User should see <url> in page url
    Examples:
      |status_codes  |url|
      |200           |status_codes/200|
      |301           |status_codes/301|
      |404           |status_codes/404|
      |500           |status_codes/500|