Feature: Add E-Book to Cart

  Scenario: Add e-book to cart and validate invalid promo code
    Given the user navigates to the e-junkie demo page
    When the user clicks the "Add to Cart" button for the e-book
    Then the e-book should be successfully added to the cart
    When the user clicks the "Add Promo Code" link
    And the user enters an invalid promo code "ABCDE12345"
    And the user clicks the Apply promo code button
    Then an invalid promo code warning should be displayed