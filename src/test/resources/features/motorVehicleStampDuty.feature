Feature: Motor vehicle Stamp Duty checks

  @mvsd
  Scenario: Check the motor vehicle stamp duty value
    Given the browser is open
    When A user is on the motor vehicle stamp duty page
    Then A user clicks the check online button
    And A user clicks yes
    And A user enters <purchaseValue>
    And A user clicks the calculate button
    Then A user checks the duty payable is <dutyPayable>

    Examples:
      | purchaseValue | dutyPayable | 
      | 10,000 | 300 |
