Feature: Payment Confirmation and Download Receipt.


  Scenario: Completing payment using debit card and downloading the e-book
    When the browser is opened and the user navigates to the website
    And the customer clicks the "Pay Using Debit Card" option
    And the customer clicks the "Add to Cart" button
    And the customer fills in all required fields
    And the customer clicks the Pay button

    Then the customer should be able to verify the confirmation message
    And the customer clicks the "Download" button to download the e-book
