Feature: HW5 - BDD

  Scenario: Exercise 1 - User goes to Website, perform login, and then goes to Different Elements Page where make some logs by selecting UI elements
  Given User opens website
    Then Browser title equals 'Home Page'
    And Perform login as "Roman" and password "Jdi1234"
    Then User is logged as "ROMAN IOVLEV"
    When Open through the header menu Service -> Different Elements Page
    And Select checkbox Wind
    And Select checkbox Water
    And Select radio Selen
    And Select in dropdown Yellow
    Then Checkbox Water is logged
    And Checkbox Wind is logged
    And Radiobutton Selen is logged
    And Dropdown Yellow is logged