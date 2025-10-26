Feature: Testing API functions for Open Library Authors

  @author
  Scenario: Check response from Open Library
    Given a REST API endpoint
    When a user sends a GET request
    Then a user validates the <name> and <value>

    Examples:
      | name            | value                      |
      | personal_name   | Sachi Rautroy              |
      | alternate_names | Yugashrashta Sachi Routray |
