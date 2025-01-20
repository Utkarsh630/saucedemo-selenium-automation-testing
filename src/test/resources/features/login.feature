Feature: Sauce Demo(Swag Labs) Login

  @regression
  Scenario: Happy Path - Successful login with valid credentials
    Given I am on the Sauce Demo login page
    When I enter valid username "standard_user"
    And I enter valid password 'secret_sauce'
    And I click the login button
    Then I should see the products page
@regression
  Scenario: Unhappy Path - Failed login with invalid credentials
    Given I am on the Sauce Demo login page
    When I enter invalid username "invalid_user"
    And I enter valid password 'secret_sauce'
    And I click the login button
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"


