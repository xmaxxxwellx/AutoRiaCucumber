Feature: MainLogo Action

  Scenario: Successful return to HomePage by clicking on MainLogo
    Given User is on Home Page
    When User Navigate to Result Page
    And User clicks on MainLogo
    Then User returns back to Home Page
