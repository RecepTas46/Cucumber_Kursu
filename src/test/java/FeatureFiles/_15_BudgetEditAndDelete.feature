Feature:  Budget > Setup > Budget Groups

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to Budget page

    Scenario: Budget Groups and Edit
      When  Create a  "Description" and Started
      And   Create a Date
      Then Success message should be displayed

      Scenario: Create edit and delete a Cost Centers
        When Create a cost centers name as "veli" code as "0101" and expense "gelir,gider"