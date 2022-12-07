@login
Feature: Login

  @login @positive
  Scenario: As a user i should be able to login
    Given open browser "chrome" and go to url "https://www.saucedemo.com/"
    When login as "standard_user"
    Then current url should be "https://www.saucedemo.com/inventory.html"
