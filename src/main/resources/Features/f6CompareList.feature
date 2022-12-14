@Regression
Feature: user manage the comparelist
  Background:
  Given user initiate comparelist

    Scenario: user add two items to compare list
      When user open home page and navigates to Cell phones category
      And click on add to compare list button for HTC One M8 Android L 5.0 Lollipop and HTC One Mini Blue
      And click on open compare list notification
      Then the "HTC One M8 Android L 5.0 Lollipop" and "HTC One Mini Blue" are in the compare list