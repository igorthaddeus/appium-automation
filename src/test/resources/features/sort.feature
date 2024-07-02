@tag
Feature: Sort Products

  @Sort
  Scenario: Successfully sort products by price from low to high
    Given User on the login page
    When User login with username "standard_user" and password "secret_sauce"
    And User sort products
    Then the products should be sorted in ascending order of price