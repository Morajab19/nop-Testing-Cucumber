@RegressionStart
Feature: user select a searching tag
  Background:
    Given user navigates to search page

    Scenario: user search with cool tag
    When user click on cool tag
    Then products tagged with cool are displayed