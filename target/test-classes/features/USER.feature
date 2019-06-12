Feature: Administrator and User Accounts

As a User Administrator
I want to manage user accounts
In order to control the users of the application.


Scenario: Administrator creates a new user account
Given The details of the new user
When The details submitted for account creation
Then User account successfully created


Scenario: Administrator creates new accounts for multiple users
Given The details of each new user
When All the details of all users submitted for account creation
Then User accounts successfully created


Scenario: Administrator view account details of a user account
Given The username of the user
When View the user details
Then User details successfully shown


Scenario: Administrator updates account details of a user
Given The username of the user
When New details of users submitted to update account
Then User details successfully updated


Scenario: Administrator deletes a user account
Given The username of an existing acount
When Administrator deletes the user with that username
Then The user account successfully deleted



As a User
I want to successfully log in and log out in the application
In order to access the application


Scenario: User logs-in in the account
Given The valid username and password of the user
When Submitting the username and passowrd
Then User successfully logged-in


Scenario: User logs-out in the account
Given The user is already logged-in
When User logs out in the account
Then User successfully logged-out