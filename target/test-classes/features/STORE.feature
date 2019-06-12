Feature: Store Sales Operation

//As a user
//I want to manage my orders and view my pet inventory
//In order to organize the sale operation of my store.


Scenario: User view his inventory of pets
Given I have succesfully logged in my account
When User view his pet inventory
Then Inventory of pets by status successfully shown


Scenario: User place an order in the store
Given The details of the order
When The order has been placed
Then Order succesfully created with the provided details


Scenario: User places an order in the store
Given The invalid details of the order
When Submit the order details
Then Order is not created


Scenario: User view an existing order
Given The reference number of an existing order
When User search for the order
Then Details of the order shown successfully


Scenario: User delete an existing order
Given The reference number of existing order
When User deletes the order
Then Order successfully deleted

