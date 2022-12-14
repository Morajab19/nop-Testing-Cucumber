@Regression
Feature: user can manage his cart by adding, updating or deleting items
  Background:
    Given Initiate manage cart

    Scenario: user add product to his/her cart
      When user scrolls to Apple MacBook Pro 13-inch and clicks Add to cart Button
      And enter quantity of "2" and click on ADD TO CART Button and open cart
      Then the product "Apple MacBook Pro 13-inch" is added successfully to the cart

      Scenario: user updates the quantity of added item
        When user opens the cart
        And type the updated quantity "4" and click on update cart
        Then the product quantity is updated to "4"

        Scenario: user deletes a product from cart
          When user opens the cart
          And click on remove product
          Then product is deleted from the cart

  Scenario: user add existing product to his/her cart
    When user scrolls to Apple MacBook Pro 13-inch and clicks Add to cart Button
    And enter quantity of "10" and click on ADD TO CART Button and open cart
    Then the product "Apple MacBook Pro 13-inch" is added successfully to the cart
