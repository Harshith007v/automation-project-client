Feature: Login

  Scenario Outline: Validate that user is able to login
    Given I opened the app using following <URL>
    And I enter <username> and <password> and press submit
    Then validate login with <NEWURL> and <text> and logout button

    Examples: 
      | URL                                                     | username | password    | NEWURL                                                     | text                   |
      | https://practicetestautomation.com/practice-test-login/ | student  | Password123 | https://practicetestautomation.com/logged-in-successfully/ | Logged In Successfully |

  Scenario Outline: Validate that user is not able to login with wrong username
    Given I opened the app using following <URL>
    And I enter <username> and <password> and press submit
    Then user error message <err> is shown

    Examples: 
      | URL                                                     | username | password    | err                       |
      | https://practicetestautomation.com/practice-test-login/ | abc      | Password123 | Your username is invalid! |

  Scenario Outline: Validate that user is not able to login with wrong password
    Given I opened the app using following <URL>
    And I enter <username> and <password> and press submit
    Then password error message <err> is shown

    Examples: 
      | URL                                                     | username | password | err                       |
      | https://practicetestautomation.com/practice-test-login/ | student  | abc      | Your username is invalid! |
