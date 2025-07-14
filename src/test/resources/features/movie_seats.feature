Feature: Movie Seat Selection 

 Scenario Outline: Validate seat count after selection
    Given I am on District.in home page
    And I dismiss the popup
    And I select city index 9
    When I choose <seatCount> seats for movie "<movie>" on date "<date>" at time "<time>"
    Then I should see exactly <seatCount> seats selected

    Examples:
      | seatCount | movie              | date | time      |
      | 5         | Metro In Dino      | 15   | 01:15 PM  |