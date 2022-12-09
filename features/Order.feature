@order
Feature: Order

  @order @positive
  Scenario: As a user i should be able to Order
    Given navigate to url "https://www.saucedemo.com/"
    * login as "standard_user"
    * current url should be "https://www.saucedemo.com/inventory.html"
    * user choose product and click button cart
    * user should be navigate to url "https://www.saucedemo.com/cart.html" and click button checkout
    * user fill firstname, lastname and zipcode and click button continue
    When user click button finish
    Then user should be navigate to url "https://www.saucedemo.com/checkout-complete.html"
    * user take screenshot full page with name "test order positive"