Feature: Verify Successful Bill Payment


  Scenario: Paying with valid credit card number

    When User navigates to home page
    Then User adds the demo e-book to the cart
    Then User clicks on "pay using debit or credit cart" button
    Then User fill in the mask with valid credit cart number
    Then Verify success paying message
