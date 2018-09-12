Feature: Action - Order T-Shirt and Verify in Order History

Scenario: Navigate to SignIn Page of Website from Home page
	Given User is on Home Page
	When User clicks on SignIn Button
	Then User navigates to SignIn page

Scenario: Successful Login with Valid Credentials
	When User enters UserName and Password
	Then Message displayed Login Successfully

Scenario: Select & add product to shooping Cart and proceeds for checkout option
	When User searches for Product
	And User adds product to cart
	And User clicks on Checkout button
	Then User navigates to Summary page

Scenario: Place order by entering other information
	When User clicks on checkout button on Summary Tab
	And User clicks on checkout button on Address Tab after Entering Additional Message 
	And User clicks on checkout button on Shipping Tab after Selecting Term of Servcive option
	And User select payment option
	And User confirms order 
	Then User should get Confirmation message for order along with Order reference number

Scenario: View recently placed order in Order history
	When User clicks on Order History option under my account
	Then User should get information about recently placed order
		
Scenario: Successful Logout from Customer account 
	When User LogOut from the Application
	Then Message displayed LogOut Successfully