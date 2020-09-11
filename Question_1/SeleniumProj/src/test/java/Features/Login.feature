Feature: LoginFeature
  This feature deals with the login functionality of the website.

  Scenario: Login with correct username and password
    Given I navigate to the login page
    When I enter the following for login
    |Email               |   Password|
    |dummyemail123@gmail.com| dummypass|
    And I click the login button
    Then I should see the homepage with me being logged in