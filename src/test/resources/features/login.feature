@tag
Feature: Login

  @Login
  Scenario: User successfully login with valid username and password
    Given User is on Login page
    And User input username "standard_user"
    And User input password "secret_sauce"
    When User click on login button
    Then User in on home page