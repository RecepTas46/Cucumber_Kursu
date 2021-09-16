Feature: ApachiPOI Citizen Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to Citizenship page

  Scenario: Create an delete citizenShip from Excel
    When User Create citizenship with ApachePOI
    Then User Delete citizenship with ApachePOI