Feature: Login Functionality



  Scenario: Unsuccessful login with invalid credentials

    Given the user is on the login page
    When  the user enters invalid credentials
    Then  the user should see an error message