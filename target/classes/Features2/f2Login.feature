@Regression
Feature: User login to the website

  Background:
    Given user navigate to the login page

  Scenario: User enter valid email and valid password
    When enter email "moRajab@gmail.com"
    And enter password as "Asdfgh"
    And click on Login Button
    Then user is navigated to the home page


    Scenario: User enters invalid non existing email and password
      When enter email "moRajgcgcab@gmail.com"
      And enter password as "Asdfgh"
      And click on Login Button
      Then invalid login error message appears

    Scenario: user enters email with invalid format
      When enter email "moRajabgcom"
      And enter password as "Asdfgh"
      And click on Login Button
      Then wrong email error message appears

  Scenario: user want to recover a forgotten password
    Given user clicks on forget password button
    When enter email as "moRajab@gmail.com"
    And click on Recover Button
    Then Email with instructions has been sent to user




