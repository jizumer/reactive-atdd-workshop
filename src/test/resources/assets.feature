Feature: Retrieve the amount of my assets
  Scenario: As a crypto wallet user, I want to retrieve my past assets increments to know my overall amount of crypto assets
    Given that we have stored data on the amount of crypto assets we have acquired in the past
    When I request the amount of my assets
    Then I get the list of the increments of amount of my assets