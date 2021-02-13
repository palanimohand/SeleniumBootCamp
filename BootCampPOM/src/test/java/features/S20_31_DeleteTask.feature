Feature: Delete Task 

Scenario Outline: Verify the user is able to delete a task 
Given the user is able to enter username as <username>
And the user is able to enter password as <password>
And the user is able to click login
And the user is able to open app launcher 
And the user is able to open Sales 
And the user is able to open Tasks 
And the user is able to view Recently viewed tasks 
When the user is able to click on the delete option of the Boot Camp Task 
Then the task must be deleted

Examples:
|username|password|
|bowyakarthikeyan@testleaf.com|India@123|
|bowyakarthikeyan@testleaf.com|India@123|
|cypress@testleaf.com|Bootcamp@123|