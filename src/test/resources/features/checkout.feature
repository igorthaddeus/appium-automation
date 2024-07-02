@tag
Feature: Successful Checkout

  @Checkout
  Scenario: User successfully checks out after logging in
    Given User is on the login page
    When User input username "standard_user" and password "secret_sauce"
    And User adds an item to the cart
    And User input first name "test", last name "test", and postal code "123"
    And User continues to the checkout
    And User completes the purchase
    Then User should see a confirmation message
