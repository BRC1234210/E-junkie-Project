Feature: Incorrect payment

  Scenario: Incorrect payment test
    Given Navigate to the webpage
    Then Find Demo ebook and click add to cart button
    Then Select payment method,using credit card
    Then Leave fields blank on the payment page and click pay button
    Then Verify that the Invalid field errors are displayed simultaneously