Feature: Login

Scenario: Successful Login with valid Credentials
	Given User Launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
	And  User enters Email as "admin@yourstore.com" and Password as "admin"
	And click on Login
	Then Page title Should be "Dashboard / nopCommerce administration"
	When The user click on logout link
	Then Page title Should be "Your store. Login"
	And close browser
	
Scenario Outline: Successful Login with valid Credentials
	Given User Launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
	And  User enters Email as "<email>" and Password as "<password>"
	And click on Login
	Then Page title Should be "Dashboard / nopCommerce administration"
	When The user click on logout link
	Then Page title Should be "Your store. Login"
	And close browser

	Examples:
	|      email          |       password       |
	|     admin@yourstore.com       |      admin      |
	|     admin1@yourstore.com       |      admin123      |
