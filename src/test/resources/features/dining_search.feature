Feature: Dining Search and Café Info
 
  Scenario: Retrieve details of a specific café
    Given The user is on District.in home page
    And The user changes the location
    And The user selects city index 9
    When The user search for café "Kerala Cafe"
    Then Print the café’s name, rate, price, time, and address to console