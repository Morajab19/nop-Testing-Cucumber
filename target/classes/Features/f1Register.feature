@RegressionStart
Feature: User register in the website

  Background:
    Given user navigates to registration page

    Scenario: User register with valid data
      When user choose gender "male" , enter firstname "Mohammed" and enter lastname "Rajab"
      And user enter date of birth day "2" month "10" year "1999"
      And user enter email "moRajab@gmail.com" , password "Asdfgh" and confirm with "Asdfgh"
      And click on register button
      Then user is registered successfully message appears

    Scenario: user left mandatory field firstname empty
        When user choose gender "male" , enter firstname "" and enter lastname "Rajab"
        And user enter date of birth day "2" month "10" year "1999"
        And user enter email "moRajagb@gmail.com" , password "Asdfgh" and confirm with "Asdfgh"
        And click on register button
        Then empty fname error

    Scenario: user entered different passwords
        When user choose gender "male" , enter firstname "Mohammed" and enter lastname "Rajab"
        And user enter date of birth day "2" month "10" year "1999"
        And user enter email "moRajgfab@gmail.com" , password "Asdfgh" and confirm with "fffgh"
        And click on register button
        Then confirm password error

    Scenario: user entered already existing Email
        When user choose gender "male" , enter firstname "Mohammed" and enter lastname "Rajab"
        And user enter date of birth day "2" month "10" year "1999"
        And user enter email "moRajab@gmail.com" , password "Asdfgh" and confirm with "Asdfgh"
        And click on register button
        Then mail already exist error

    Scenario: user short password
      When user choose gender "male" , enter firstname "Mohammed" and enter lastname "Rajab"
      And user enter date of birth day "2" month "10" year "1999"
      And user enter email "moRafdjab@gmail.com" , password "1234" and confirm with "1234"
      And click on register button
      Then password is too short error


