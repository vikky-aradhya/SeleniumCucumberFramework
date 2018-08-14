Feature: Login into an application

@Login_user_2
Scenario: Login

Given User opens browser
And user enters the username and password
|mercury |mercury |
Then user clicks on Login
And the verify the title
Then user quits the browser