Feature: To validate the login functionality of facebook application

Background:
Given To launch the browser and maximize the window
Scenario: To validate login with email and password
When To get the current url of facebook appilction
And To pass the data in email field
And To pass the data in password field
And To click the login button After entered the datas
Then To close the browser


Scenario Outline: To validate the positive and negative combination of facebook application
When User has to pass the url of facebook appilcation
And User should pass the data in "<emaildatas>" email field
And User should pass the data in "<passworddatas>"  password field
And User must click the login in button for the proper process
Then User should close the browser

Examples:

| emaildatas             | passworddatas     |
| abi1311@gmail.com      | abi1311           |
| jeenu@gmail.com        | jeenujs           |
| arun@gmail.com         | 2707ak            |
| surya@gmail.com        | suryavip0214      |