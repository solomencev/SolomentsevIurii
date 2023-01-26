Feature: Test1
  Test1

  Scenario: Test1
  Given User opens website
    Then Browser title equals 'Home Page'
    And Perform login as "Roman" and password "Jdi1234"
    Then User is logged as "ROMAN IOVLEV"
    When Open through the header menu Service -> Different Elements Page
    And Select checkbox Wind
    And Select checkbox Water
    And Select radio Selen
    And Select in dropdown Yellow