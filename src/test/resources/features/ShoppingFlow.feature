Feature: Shopping Flow
  As a User
  I want to browse and purchase products
  So that I can complete my shopping seamlessly

  Background:
    Given I am on the Sauce Demo login page
    When I enter valid username "standard_user"
    And I enter valid password 'secret_sauce'
    And I click the login button


  Scenario: Validate product details dynamically
    Given I am on Products page
    When I add the selected products to the cart and add to cart button change to remove button
    | Sauce Labs Backpack |
    | Sauce Labs Bike Light |
    | Sauce Labs Fleece Jacket |
    Then the cart should contain exactly those products and no others





#  Scenario Outline: View Product details
#      When I select a product named <ProductName>
#      Then I should see the product details page with title <ProductName>
#      Examples:
#        | ProductName |
#        | "Sauce Labs Backpack" |

