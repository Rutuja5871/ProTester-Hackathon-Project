Feature: Fetch and sort events by price

  Scenario: List Pune events sorted by ascending price
    Given The user is on District.in home page
    And The user changes the location
    And The user selects city index 9
    And The user navigate to the Events tab
    When The user scroll until all events are loaded
    And The user fetch and sort events by price
    Then Print the sorted event list