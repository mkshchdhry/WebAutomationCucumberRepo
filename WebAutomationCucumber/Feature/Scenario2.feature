Feature: Action - Update Personal Information i.e. First Name in My Account

Scenario: Navigate to SignIn Page of Website from Home page.
	Given User is on Home Page
	When User clicks on SignIn Button
	Then User navigates to SignIn page

Scenario: Successful Login with Valid Credentials
	When User enters UserName and Password
	Then Message displayed Login Successfully

Scenario: Update Personal Information under My Acount Section
	When User navigates to personal information Section
	And User saves personal information after entering First name and Email id
	Then User should get Confirmation message for personal information updation

Scenario: Validate recently Updated Personal Information in My Account section
	When User navigates to personal information Section
	Then User should able to see updated information for First Name
		
Scenario: Successful Logout from Customer account 
	When User LogOut from the Application
	Then Message displayed LogOut Successfully