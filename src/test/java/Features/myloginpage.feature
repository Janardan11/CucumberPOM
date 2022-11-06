Feature: my login page

  Scenario: Validate my login page
    Given the user is on home page
    When the user enter user name
    Then the user enter password
    And  the user click on login button