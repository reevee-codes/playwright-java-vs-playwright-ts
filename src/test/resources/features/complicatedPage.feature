Feature: Testing the Complicated Page

  Scenario: Navigate to the Complicated Page and click a button
    Given I open the Complicated Page
    When I hover over the first button
    Then I see the button change color

    #todo
  Scenario: Navigate to the Complicated Page and complete the first form - negative scenario
    Given I open the Complicated Page
#    When I enter text into name field
#    And I enter text into email field
#    And I enter text into message field
#    And I enter incorrect text into captcha calculation field
#    Then I see the "You entered the wrong number in captcha." message