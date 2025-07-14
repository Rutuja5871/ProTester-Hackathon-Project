Feature: Verify social media icons under footer

  Scenario Outline: Each social icon opens correct page
    Given The user is on District.in home page
    And The user changes the location
    And The user selects city index 9
    When The user scroll to the footer
    And The user click the "<icon>" icon and verify title "<title>"
    Then The user close the social media window

    Examples:
      | icon      | title                                           |
      | Facebook  | District Updates \| Facebook                     |
      | YouTube   | District Culture - YouTube                      |