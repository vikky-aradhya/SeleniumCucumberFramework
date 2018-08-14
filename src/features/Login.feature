Feature: Login into an application

@Login_user
Scenario: Login

Given test data is read from excel "Login" under "Sheet1"
When User opens browser
And user enters the username
And user enters the password
Then user clicks on Login
And the verify the title
Then user quits the browser