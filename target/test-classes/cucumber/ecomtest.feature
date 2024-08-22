
@tag
Feature: Ecomtest test case


Background: 
Given Landed on ecom site



  @Regression
  Scenario Outline: Submit the order positive case
    Given Logged in with username <user> and password <password>
    When Product added to the cart
    Then User navigates to checkout page
    And The Order is placed
    Then Verify the message "Thankyou for the order."
    
    

    Examples: 
      | user  | password |
      | malagamjagdesh@gmail.com |   Jagan@102419 |
