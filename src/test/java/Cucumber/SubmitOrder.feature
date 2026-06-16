@tag
Feature: Purchase the order from Ecommerce Website

Background:
Given I landed on Ecommerce Page 
@Regression
Scenario Outline: Postivive Test of Submitting the order
Given Logged in with username <name> and password <password>
When I add product <productName> to cart
And Checkout <productName> and submit the order
Then "THANKYOU FOR THE ORDER." message is displayed  on ConfirmationPage

Examples:
| name               | password | productName  | 
|nidhi21@yopmail.com | nidhi@21 | IPHONE 13 Pro|


