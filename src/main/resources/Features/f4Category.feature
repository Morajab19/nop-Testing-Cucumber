@RegressionStart
Feature: user select different category
  Background:
    Given initialize hover to categories feature


    Scenario: user Select random category or sub-category
      When user click on random category he is navigated to it
