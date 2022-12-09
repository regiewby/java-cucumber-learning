@order
Feature: Order

  @order @positive
    Scenario: As user i should be able to order
    Given navigate to url "https://www.saucedemo.com/"
    * login as "standard_user"
    When user add products to cart
    Then user checkout
    Then current url should be "https://www.saucedemo.com/checkout-complete.html"
