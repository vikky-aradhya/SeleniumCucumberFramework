Feature: Login into an application

@Login_user_1
Scenario: Login

Given User opens browser
And user enters the username as "mercury"
And user enters the password as "mercury"
Then user clicks on Login
And the verify the title
Then user quits the browser