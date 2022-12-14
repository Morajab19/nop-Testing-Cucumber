@RegressionStart
Feature: user search for product
  Background:
    Given initiate search feature

    Scenario: user search for existing item
      When user enters the product name "HTC One Mini"
      And Click on search button
      Then the item "HTC One Mini" is displayed in the search results

  Scenario: user search for non existing item
    When user enters the product name "iphoneee"
    And Click on search button
    Then item not found message