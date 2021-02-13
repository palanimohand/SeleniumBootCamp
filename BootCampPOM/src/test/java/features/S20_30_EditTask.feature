Feature: Edit Task

Background:
Given the user is able to enter username as bowyakarthikeyan@testleaf.com
And the user is able to enter password as India@123
And the user is able to click login

Scenario Outline: Verify the user is able to edit task
And the user is able to open app launcher
And the user is able to open Sales
And the user is able to open Tasks
And the user is able to view Recently viewed tasks
When the user is able to click on Edit option of BootCamp Task
And the user is able to select todays date as Due Date
And the user is able to select Priority as <priority>
And Click on Save
Then Verify the subject of the BootCamp Task

Examples:
|priority|
|Low|
|Normal|