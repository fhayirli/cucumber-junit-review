Feature: Login functionality tests

  @validLogin
  Scenario: Login with valid credential
    Given user is on the login page
    When user enter valid username
    And user enter valid password
    And user clicks the login button
    Then user should be able to login
