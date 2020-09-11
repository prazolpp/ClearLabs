Feature: SearchFeature
  This feature deals with the search functionality of the website.

  Scenario: Search for an ocean view hotel in Hawaii for one night
    Given I navigate to the search page
    When  I click the location button
    And I enter the following for search details
        |Location |
        |Hawaii |
    And I choose the first option and click the search button
    And I should be able to see a Sort and Filter Button, and a Map button
