Feature: Sample Login scenario

  Scenario Outline: validate login scenario

    Given Navigate to Login page
    When User enters valid username "<userName>" and password "<password>"
    Then User must be logged in and MyAccount icon must be displayed

    Examples:
      | userName  | password|
      |a@a.com |password|