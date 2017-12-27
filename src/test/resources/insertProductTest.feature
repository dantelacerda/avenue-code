Feature: Valid if the Product is Inserted Correctly

Scenario: Configure an Product Object to insert in the database

Given The Product params

When Save the Product with success

Then Verify is there was Value on all the Product fields 