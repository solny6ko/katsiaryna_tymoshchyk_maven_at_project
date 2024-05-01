Feature: My Booking bdd scenarios
  Scenario: Booking hover Currency test
    Given I open booking homepage
    And I dismiss sign in
    And I accept cookies
    When I hover mouse on currency button
    Then I see currency tooltip message "Select your currency" of currency button

  Scenario: Booking hover Language test
    Given I open booking homepage
    And I dismiss sign in
    When I hover mouse on language button
    Then I see language tooltip message "Select your language" of language button


  Scenario: Booking London hotel card screenshot test
    Given I open booking homepage
    And I type "London" into city input field
    And I submit search query
    And I click on calendar to close it
    When I scroll to the tenth hotel in search results
    And I change background and font color of the hotel card
    Then I can make a screenshot of hotel card


  Scenario: Booking Prague hotel Stars rating test
    Given I open booking homepage
    And I clear input city field
    And I type "Prague" into city input field
    And I choose Autocomplete City
    And I submit search query
    And I choose 5 stars rating
    When I click on voices rating label
    Then I see 5 stars on opened property

  Scenario: Booking Paris hotel voices rating test
    Given I open booking homepage
    And I clear input city field
    And I type "Paris" into city input field
    And I choose Autocomplete City
    And I fill in 3 days from now checkin and 5 days from now checkout
    And I open stay parameters
    And I add 4 adults
    And I add 2 rooms
    And I submit search query
    And I choose 6+ rating in rating filter
    And I open sort results dropdown
    When I choose Rating Low To High sorting option
    Then I see first hotel with 6 rating











