Feature: Verify social media icons under footer

  Scenario Outline: Each social icon opens correct page
    Given I am on District.in home page
    And I dismiss the popup
    And I select city index 9
    When I scroll to the footer
    And I click the "<icon>" icon and verify title "<title>"
    Then I close the social media window

    Examples:
      | icon      | title                                           |
      | Facebook  | District Updates \| Facebook                     |
      | YouTube   | District Culture - YouTube                      |