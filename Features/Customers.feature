Feature: Adding new customer

Background: Below are the common steps for each scenario
    Given User Launch Chrome Browser
	When User opens URL "https://admin-demo. nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
	And  User enters Email as "admin@yourstore.com" and Password as "admin"
	And click on Login
	Then User can view Dashboard

Scenario: Successfully adding New customer with valid data
	When User click on the customers Menu 
	And click on customers Menu Item
	And click on Add new button
	Then User can we Add new customer page
	When User enter customer info
	And click on save button
	Then User can view confirmation message "The new customer has been added successfully."
	And close browser
	
Scenario: Search Customer by EmailID
	When User click on the customers Menu 
	And click on customers Menu Item
	And Enter customer Email
	When click on search button
	Then User should found Email in the Search table
	And close browser
	
Scenario: Search Customer by Name 
	When User click on the customers Menu 
	And click on customers Menu Item
	And Enter customer FirstName
	And Enter customer LastName
	When click on search button
	Then User should found name in search table
	And close browser
	
	
	
	
	
	