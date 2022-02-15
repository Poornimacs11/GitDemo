Feature: Login application feature

Scenario: Application login with valid credentials
Given Initialize the browser with Chrome
And Navigate to "https://rahulshettyacademy.com/" site
And click on login link in home page to land on Secure signin page
When the user enters "poornimacs11@gmail.com" and "Chokkaspoo11@" and logs in
Then verify that the user is successfully logged in