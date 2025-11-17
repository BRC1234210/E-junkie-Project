Feature: Access Information Video

  Background:
    Given the user navigates to the demo shop homepage

  Scenario: Successfully access and play the information video
    When the user clicks the "e-commerce by e-junkie" link in the footer
    Then the user should be redirected to the e-junkie homepage
    When the user clicks the "How It Works" button
    Then the information video pop-up should appear
    When the user plays the video
    And the user waits for 10 seconds
    Then the user closes the video pop-up