Feature: Contact Us Functionality

  Scenario:

  Scenario Outline:
    When Navigate to the Web Page
    Then Click on the Contact Us Link
    Then Fill in the form "<name>" "<email>" "<subjectBox>"
    Then Send a message as "Contact Us Message example"
    Then Click on the Send Message Button
    Then Verify "Recaptcha didn't match" pop up
    Examples:
      | name | email           | subjectBox |
      | User | angle@gmail.com | Customer   |



