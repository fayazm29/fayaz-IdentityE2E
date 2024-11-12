Feature: Car Valuation Details - WeBuyAnyCar Website

  @smoke
  Scenario: Compare the car valuation details returned from webuyanycar with a given output file
    Given I have a car "input file version 1" containing vehicle reg numbers
    And I have all the vehicle registration numbers extracted from it
    When I get the all vehicle details from the website search with the vehicle reg number and mileage
    Then I compare the website vehicle details with "output file version 1" details for any mismatches
