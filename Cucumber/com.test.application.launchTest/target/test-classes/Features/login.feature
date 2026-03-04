Feature: To Test the Login Page

  Scenario: To check the login page with valid credentials
    Given user is in login page
    When user enters valid credentials username and password
    And user clicks the login button
    Then user will navigate to the dashboard

 
