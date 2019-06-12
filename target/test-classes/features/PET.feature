Feature: PET Feature

As a User
I want to manage my pets
In order to organize my pets in store


Scenario: User successfully added a new pet
Given User has pet details
When User submit the pet details
Then Pet is added successfully


Scenario: User views the details of an existing pet
Given The user has an existing pet
When User view the details of the pet
Then Pet details successfully shown
 
 
Scenario: User searches all available pets in the ssore
Given The available status of pets to be search
When Submit the status
Then Available pets shown successfully


Scenario: User searches all sold pets in the ssore
Given The sold status of pets to be search
When Submit the status
Then Sold pets shown successfully


Scenario: User searches all pending pets in the ssore
Given The pending status of pets to be search
When Submit the status
Then Pending pets shown successfully


Scenario: User updates the status of an existing pet
Given The user has an existing pet
When New status of the existing pet submitted
Then Pet status has been correctly updated


Scenario: User updates the name of an existing pet
Given The user has an existing pet
When New name of the existing pet submitted
Then Pet name has been correctly updated


Scenario: User updates an existing pet with new tag
Given The pet details
When New pet details submitted
Then Pet details has been updated successfully


Scenario: User updates an existing pet with new category
Given The pet details
When New pet details submitted
Then Pet details has been updated successfully


Scenario: User uploads a new photo an existing pet
Given User has an existing pet and image to upload
When Image upload submitted
Then New image of pet sucessfully shown


Scenario: User deletes an existing pet
Given User has an existing pet
When User submitted to delete the pet
Then Pet deletion successful

