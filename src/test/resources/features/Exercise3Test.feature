Feature: HW5 - BDD

  Scenario: User Table Page test
    Given I open JDI GitHub site
    And I perform login as "Roman" and password "Jdi1234"
    And I click on Service button in Header
    And I click on "User Table" button in Service dropdown
    When I select vip checkbox for "Sergey Ivan"
    Then 1 log row has "Vip: condition changed to true" text in log section