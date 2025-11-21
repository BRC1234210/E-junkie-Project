Feature: Verify Unsuccessful Bill Payment

  Scenario: Paying with invalid credit card number

    When User navigates to home page
    Then User adds the demo e-book to the cart
    Then User clicks on "pay using debit or credit cart" button
    Then User fill in the mask with invalid credit cart number
    Then Verify invalid paying message
