Feature: Create Task

Background:
Given the user is able to enter username as bowyakarthikeyan@testleaf.com
And the user is able to enter password as India@123
And the user is able to click login

Scenario Outline: User must be able to create a Task
And click on global actions icon
And click on New Task icon from GA
When enter subject as Bootcamp from GA
And select name from GA as <name>
And select status as <status>
And click on save from GA
Then verify the Task has been created from GA

Examples:
|name|status|
|Sarath M|Waiting on someone else|
|Sarath|In Progress|