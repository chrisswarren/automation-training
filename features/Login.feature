#Each feature contains one feature
#Feature files use Gherkin language - business language
#A feature may have given different specific scenarios
#Scenarios use Given-When-Then structure
Feature: Test the login functionality on Evans Cycles

Scenario: the user should be able to login with correct username and password
Given user is on the login screen
When user entered correct email and password
Then user gets confirmation

Scenario Outline: the user should be able to log in
Given user is on the login screen
When user entered email <email>
And user entered password <password>
And user clicks login button
Then user gets confirmation

Examples:
| email | password |
| automation20@test.com | Password55! |
| automation21@test.com | Password56! |
| automation22@test.com | Password73! |
| automation23@test.com | Password62! |






