Feature: User Login

  Scenario: Successful Login
    Given the user launches the Chrome browser
    When the user navigates to "https://tutorialsninja.com/demo/"
    And the user enters valid credentials (Username: "harikumar123@gmail.com", Password: "hari123")
    And the user clicks on the Login button
    Then the page title should be "My Account"
    And the browser is closed
    
    
  