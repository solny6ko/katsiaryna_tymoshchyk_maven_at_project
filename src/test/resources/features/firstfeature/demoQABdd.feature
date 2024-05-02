Feature: My DemoQA bdd scenarios
  Scenario: DemoQA "Select Value" selector test
    Given I open DemoQA homepage
    And I select "Select Value" selector
    When I choose an option "Group 1, option 2" in selector
    Then I should see the option "Group 1, option 2" is selected

  Scenario: DemoQA "Select Value" selector test
    Given I open DemoQA homepage
    And I select "Select One" selector
    When I choose an option "Mrs." in selector
    Then I should see the option "Mrs." is selected

  Scenario: DemoQA "Select Value" selector test
    Given I open DemoQA homepage
    And I select "Old Style Select Menu" selector
    When I choose an option "Yellow" in selector
    Then I should see the option "Yellow" is selected

  Scenario: DemoQA "Select Value" selector test
    Given I open DemoQA homepage
    And I select "Standard Multi Select" selector
    When I choose an option "Saab And Audi cars" in selector
    Then I should see the option "Saab And Audi cars" is selected

  Scenario: DemoQA "Select Value" selector test
    Given I open DemoQA homepage
    And I select "Multiselect Drop Down" selector
    When I choose an option "Green" in selector
    Then I should see the option "Green" is selected