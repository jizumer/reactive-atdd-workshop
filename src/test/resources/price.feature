Feature: Represent assets based on the current public spot price
  Scenario: As a crypto wallet user, I want to retrieve public crypto currencies prices, to calculate the current value of my assets denominated in USD
    Given that public crypto currencies prices are available through APIs
    When I request the value of my assets un USD
    Then I retrieve the amounts of my assets from the database
    Then I retrieve the spot price of the crypto currency in USD
    Then I get the calculated the value of my assets specified in USD

  Scenario: As a crypto wallet user, I want to calculate the progression of my assets denominated in USD over time
    Given that I can retrieve the spot price of my crypto currencies in specific moments in the past
    When I request the progression of the value of my assets until today
    Then I get the list of increments of my assets denominated in USD based on the public prices over time