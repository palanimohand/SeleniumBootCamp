Feature: Create Task Negative Scenario

Background:
Given the user is able to enter username as bowyakarthikeyan@testleaf.com
And the user is able to enter password as India@123
And the user is able to click login

Scenario Outline: User must be able to create a Task
And the user is able to open app launcher
And the user is able to open Sales
And the user is able to open Tasks dropdown
And the user is able to click on New Task
And select name as <name>
And enter comments as <comment> 
And click on save
But verify the mandatory message

Examples:
|name|comment|
|Sarath M|SALES FORCE Automation Using Selenium|
|Sarath|Test|