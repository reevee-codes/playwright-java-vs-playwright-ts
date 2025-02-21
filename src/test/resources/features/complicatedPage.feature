Feature: Testing the Complicated Page

  Scenario: Navigate to the Complicated Page and click a button
    Given I open the Complicated Page
    When I hover over the first button
    Then I see the button change color