Feature: Fetch and sort events by price

  Scenario: List Pune events sorted by ascending price
    Given I am on District.in home page
    And I dismiss the popup
    And I select city index 9
    And I navigate to the Events tab
    When I scroll until all events are loaded
    And I fetch and sort events by price
    Then I print the sorted event list