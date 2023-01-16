@Regression
Feature: Test api

  Scenario: Check Nicholas Runolfsdottir V exists
    Given User makes a get request to typicode.com
    Then  User verifies "Nicholas Runolfsdottir V" exist

  Scenario: Verify Nicholas Runolfsdottir address
    Given User makes a get request to typicode.com
    Then  User verifies address exist for "Nicholas Runolfsdottir V"