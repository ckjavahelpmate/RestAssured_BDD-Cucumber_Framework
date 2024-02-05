
Feature: GitHub Create Repo Endpoint Scenarios 
  the feature file has both positive and negative scenarios for Create Repo POST Endpoints
  
  @json
  Scenario: Create organization repository
    Given path param "orgName" with value "ckjavahelpmate"
    And body param from file "createRepo.json"
    And header param "Authorization" with value "Bearer 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"
    When I do POST request with URL "orgs/{orgName}/repos"
    Then I validate the status code is 201
    
  @deserialization
  Scenario: Create organization repository
    Given path param "orgName" with value "ckjavahelpmate"
    And body param input keys "name,description,private" and values "DemoRepo-09,Deserialization repo-05,true"
    And header param "Authorization" with value "Bearer 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"
    When I do POST request with URL "orgs/{orgName}/repos"
    Then I validate the status code is 201
    Then I validate the "name" is "DemoRepo-09"
    Then I validate create repo response keys "name,description,private" and values "DemoRepo-09,Deserialization repo-05,true"
   
