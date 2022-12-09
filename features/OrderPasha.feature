@Order
Feature: Order

  @Login @Positive @Order
    Scenario: I should be able to order item
    Given open browser "chrome" and go to url "https://www.saucedemo.com/"
    * login as "standard_user"
    * current url should be "https://www.saucedemo.com/inventory.html"
    When order item
    Then fillout buyer information as "pasha"
    * current url should be "https://www.saucedemo.com/checkout-complete.html"

