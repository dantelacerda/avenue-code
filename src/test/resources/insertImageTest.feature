Feature: Valid if the Image is Inserted Correctly

Scenario: Configure an Image Object to insert in the database

Given The Image params

When Save the Image with success

Then Verify is there was Value on Image Type