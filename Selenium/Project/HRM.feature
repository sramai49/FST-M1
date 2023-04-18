Feature: Get the url of the header image

  @FirstScenario
  Scenario: validate user is able to get the url of the header image of the HRM login page
    Given user is on the HRM website
    When print the URL of header image
    Then close the browser

  @SecondScenario
  Scenario: Verify the website title
    Given User open the browser and navigate to the URL
    When get the title of the website and Validate it matches “OrangeHRM” exactly
    Then If it matches, close the browser

  @ThirdScenario
  Scenario Outline: Logging into the site
    Given User open the browser
    When valid "<username>" and "<password>" is entered
    Then Click on the login button
    Then verify the home page has been displayed
    And close the HRM browser
    Examples:
      | username | password          |
      | orange   | orangepassword123 |






