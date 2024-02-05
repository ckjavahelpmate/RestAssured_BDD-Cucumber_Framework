 
Feature: List Organization repositories Endpoint Scenarios
 the feature file has both positive and negative scenarios for List Repositories GET Endpoints

 #With valid Organization ,with path param, with no token
 @smoke
  Scenario: Fetch all the public repos for valid org
    Given path param "orgName" with value "ckjavahelpmate"
    When I do GET request with URL "orgs/{orgName}/repos"
    Then I validate the status code is 200
    
 #With invalid organization ,with path param, with no token
 @negative
  Scenario: Fetch all the public repos for inavlid org
    Given path param "orgName" with value "abcd"
    When I do GET request with URL "orgs/{orgName}/repos"
    Then I validate the status code is 404
    
 #With valid Organization ,with path param, with token
  Scenario: Fetch all the public repos for valid org with token
    Given path param "orgName" with value "ckjavahelpmate"
    And header param "Authorization" with value "Bearer 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"
    When I do GET request with URL "orgs/{orgName}/repos"
    Then I validate the status code is 200
    
 #With valid Organization ,with path param, with token
  Scenario: Fetch all the private repos for valid org with token
    Given path param "orgName" with value "ckjavahelpmate"
    And query param "type" with value "private"
    And header param "Authorization" with value "Bearer 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"
    When I do GET request with URL "orgs/{orgName}/repos"
    Then I validate the status code is 200
    
 #With valid Organization, with path param, with token , with query param
    Scenario: Fetch all the public repos for valid org with per page
    Given path param "orgName" with value "ckjavahelpmate"
    And query param "per_page" with value "10"
    And query param "page" with value "1"
    And header param "Authorization" with value "Bearer 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"
    When I do GET request with URL "orgs/{orgName}/repos"
    Then I validate the status code is 200
    
 #With valid Organization, with path param, with token , with query param With Examples
    Scenario Outline: Fetch all the public repos for valid org with per page
    Given path param "orgName" with value "<orgName>"
    And query param "type" with value "<type>"
    And header param "authorization" with value "<token>"
    When I do GET request with URL "orgs/{orgName}/repos"
    Then I validate the status code is <statusCode>
    
    Examples:
		|	orgName				|	type		|	token																						|	statusCode	|
		|ckjavahelpmate	|public		|Bearer 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	|200					|
		|ckjavahelpmate	|private	|Bearer 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	|200					|
		|abcd						|public		|Bearer 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	|404					|



