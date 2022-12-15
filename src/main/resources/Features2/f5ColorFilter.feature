@Regression
Feature: user can filter products by color
  Scenario:
    Given user navigate to shoes category page
    When user select red color
    Then the red shoes are displayed