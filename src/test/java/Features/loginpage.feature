Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: Validate forgot password link displayed on UI
Given user is on login page
Then forgot your password link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enters username "jbpatilswt123@gmail.com"
And user enters password "test1234"
And user click on login button
Then user gets the title of the page
