Feature: Dining Search and Café Info
 
  Scenario: Retrieve details of a specific café
    Given I am on District.in home page
    And I dismiss the popup
    And I select city index 9
    When I search for café "Kerala Cafe"
    Then I print the café’s name, rate, price, time, and address to console