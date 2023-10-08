Feature: Search Page Tests

  Scenario: Search for a job with matching criteria
    Given I search for "Senior Software Development Engineer in Test"
    When I do search
    Then I see valid results