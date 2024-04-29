Feature: My Booking bdd scenarios
  Scenario: Booking hover test
    Given I open booking homepage
    And I dismiss sign in
    And I accept cookies
    When I hover mouse on currency button
    Then I see currency tooltip message "Select your currency" of currency button