@Regression
Feature: user can manage his wishlist
  Background:
    Given Initiate wishlist

    Scenario: user add item to wishlist
      When user scrolls to Apple MacBook Pro 13-inch and clicks Add to wishlist Button
      And user click on add to wishlist
      Then item is added to wishlist