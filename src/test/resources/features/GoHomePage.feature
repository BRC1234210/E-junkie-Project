Feature: Navigating to the Home Page

  Scenario: Accessing the E-Junkie Home Page
    Given the browser is opened and the user navigates to the website
    When the customer clicks the "E-Commerce by E-Junkie" button located at the bottom-right corner
    Then the customer verifies that the URL is "https://www.e-junkie.com/"
