@login
Feature: Login

  @login @positive
  Scenario: As a user i should be able to login
    Given open browser "chrome" and go to url "https://www.saucedemo.com/"
    When login as "standard_user"
    Then current url should be "https://www.saucedemo.com/inventory.html"
    And close browser

    @login @negative
    Scenario: As a user i should not be able to login because credential is not valid
      Given open browser "chrome" and go to url "https://www.saucedemo.com/"
      When login as "invalid_user"
      Then user verify error message with value "<errorMessage>"
        | errorMessage                                                              |
        | Epic sadface: Username and password do not match any user in this service |

