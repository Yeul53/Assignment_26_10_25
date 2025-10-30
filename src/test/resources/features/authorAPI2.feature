@openLibraryAPI
Feature: Testing API functions for Open Library APIs

  @GET_author
  Scenario: Validate GET response from Open Library
    Given a REST API endpoint
    When a user sends a GET request
    Then a user validates the <name> and <value>

    Examples:
      | name            | value                      |
      | personal_name   | Sachi Rautroy              |
      | alternate_names | Yugashrashta Sachi Routray |
