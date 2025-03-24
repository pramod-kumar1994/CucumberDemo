Feature: User Registration

  Scenario: Successful Registration DDT
    Given the user launches Chrome browser
    When user opens URL "https://tutorialsninja.com/demo/"
    And user clicks on Register
    And user enters First Name "kumar"
    And user enters Last Name "rohit"
    And user enters Email "<email>"  
    And user enters Mobile Number "9853112233"
    And user enters Password "rohit123"
    And user enters Confirm Password "rohit123"
    And user checks the checkbox
    And user clicks on Continue
    Then user should see the registration success message
    And user closes the browser
