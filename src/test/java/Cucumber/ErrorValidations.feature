@tag
Feature: Error validation
I Want to use this remplate for my feature file

@ErrorValidation
Scenario Outline: Title of your scenerio outline
Given I landed on Ecommerce Page 
When Logged in with username <name> and password <password>
Then I landed on Ecommerce Page 
Examples:
| name               | password | productName  | 
|nidhi21@yopmail | nidhi@21 | IPHONE 13 Pro|

