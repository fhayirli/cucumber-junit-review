Feature: Login functionality tests

  @validLogin
  Scenario: Login with valid credential
    Given user is on the login page
    When user enter valid username
    And user enter valid password
    And user clicks the login button
    Then user should be able to login

  @validLoginWithParams
  Scenario: Login with valid credential
    Given user is on the login page
    When user enter username "Employee61"
    And user enter password "Employee123"
    And user clicks the login button
    Then user should be able to login

  @invalidLoginWithParams
  Scenario: Login with valid credential
    Given user is on the login page
    When user enter username "Employee61"
    And user enter password "Employee1234"
    And user clicks the login button
    Then user should see be wrong message

  @invalidLoginWithParams
  Scenario: Login with valid credential
    Given user is on the login page
    When user enter username "Employee615"
    And user enter password "Employee123"
    And user clicks the login button
    Then user should see be wrong message

  @invalidLoginWithParamsScenarioOutline
  Scenario Outline: Login with valid credential
    Given user is on the login page
    When user enter username "<username>"
    And user enter password "<password>"
    And user clicks the login button
    Then user should see be wrong message
    Examples:
      | username    | password     |
      | Employee61  | Employee123  |
      | Employee61  | Employee1234 |
      | Employee616 | Employee123  |
      | null        | null         |