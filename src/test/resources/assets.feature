Feature: Show the value of my assets
  Scenario: We can know the value of my assets
    When I request the value of my assets
    Then I get the list of the values of my assets