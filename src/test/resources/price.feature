Feature: Show the value of our crypto denominated in $

  Scenario: We can retrieve the price of an asset in specific moment of time
    When I request the price of a crypto asset in an specific moment in time
    Then I get the spot price of the asset in $

  Scenario: We can calculate the real-time value of my assets specified in $
    When I request the value of my assets
    Then I retrieve my assets from the database
    Then I retrieve the spot price of the asset in $ and calculate the value of my assets specified in $