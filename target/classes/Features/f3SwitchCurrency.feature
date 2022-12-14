@RegressionStart
Feature: user switch the currency to other one
  Background:
    Given user navigates to home page

    Scenario: user switch from Dollar to Euro
      When user click on the currencies list
      And choose "euro"
      Then product currency is switched to "euro"