# new feature
# Tags: optional

Feature: Home page tests

  Background:
    Given I open the Home Page

  @SeverityLevel.MAJOR
  @TestCaseId("Shorten1")
  Scenario: Try to shorten an empty url - get an error message
    When I click on 'shorten' button on home page
    Then I get warning message with 'Error' title and 'The link URL field is required.' text

  @SeverityLevel.CRITICAL
  @TestCaseId("Shorten2")
  Scenario: Try to shorten a valid URL
    When I enter 'https://www.youtube.com/watch?v=dQw4w9WgXcQ' URL into a text box
    And I click on 'shorten' button on home page
    Then I open the page using the shortened link and verify it's the same page 'https://www.youtube.com/watch?v=dQw4w9WgXcQ'

  @SeverityLevel.MAJOR
  @TestCaseId("Shorten3")
  Scenario: Try to shorten a valid URL and then try to shorten again
    When I enter 'https://www.youtube.com/watch?v=dQw4w9WgXcQ' URL into a text box
    And I click on 'shorten' button on home page
    When I click on 'shorten another' button on shorten page
    Then Home page is opened

  @SeverityLevel.MAJOR
    @TestCaseId("SignUp1")
  Scenario Outline: I enter partial data into Register page
    When I click on 'Sign Up' button in the navigation panel
    Then Registration page is opened
    When I write '<Username>' value to the 'USERNAME' field
    And I write '<Password>' value to the 'PASSWORD' field
    Then I click Register button
    Then I get warning message with 'Error' title and 'The email field is required.' text
    Examples:
      | Username                  | Password |
      | Pika Chu                  | Pika Pi  |
      | Charmander                |  234444  |








