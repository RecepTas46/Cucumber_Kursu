Feature: Country Create Edit Delete

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to education page

  Scenario: Create a Education
    When Create a education name as "MySubjectCat" code as "code99"
    Then Success message should be displayed

  Scenario: Create a Subject Education
    When Create a subject new education name as "subjectSyleyman" code as "code5"
    Then Success message should be displayed

  Scenario: Delete a Education
    When User delete the education "MySubjectCat"
    Then Can not be deleted message should be displayed

  Scenario: Create Subject delete
    When User delete the subject education "subjectSyleyma"
    Then Success message should be displayed


  Scenario: Delete a Education
    When User delete the education "MySubjectCat"
    Then Can not be deleted message should be displayed
