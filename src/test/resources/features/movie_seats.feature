Feature: Movie Seat Selection 

 Scenario Outline: Validate seat count after selection
    Given The user is on District.in home page
    And The user changes the location
    And The user selects city index 9
    When The user choose <seatCount> seats for movie "<movie>" on date "<date>" at time "<time>"
    Then The user should see exactly <seatCount> seats selected

    Examples:
      | seatCount | movie              | date | time      |
      | 5         | Metro In Dino      | 15   | 01:15 PM  |