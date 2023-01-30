Feature: HW5 - BDD

  Scenario: Exercise 1 - User goes to Website, perform login, and then goes to Different Elements Page where make some logs by selecting UI elements
  Given I open JDI GitHub site
    Then Browser title should be 'Home Page'
    And Perform login as "Roman" and password "Jdi1234"
    Then User is logged as "ROMAN IOVLEV"
    When Open through the header menu Service -> Different Elements Page
    And I select checkbox Wind
    And I select checkbox Water
    And I select radio Selen
    And I select in dropdown Yellow
    Then Checkbox Water should be logged
    And Checkbox Wind should be logged
    And Radiobutton Selen should be logged
    And Dropdown Yellow should be logged