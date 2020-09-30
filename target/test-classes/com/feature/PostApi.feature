Feature: JIRA automation Testing

@createissue
Scenario: Create  a issue uing post
Given First get the endpoint "https://dheenaguru03.atlassian.net/rest/api/2/issue/"
When First specify header key 'Content-Type' and value 'application/json' 
And user pass the password
And Insert the body of the file from file 'src/test/java/com/Stepdefenition/guruapi.json'
And Give the Post request
And Print the responce 
Then check the value of jason "id" present or not
Then check the value of jason "key" present or not

@getMethod
Scenario: Verify the get method
Given First get the endpoint "https://dheenaguru03.atlassian.net/rest/api/2/issue/createmeta?projectKeys=GUR&issuetypeNames=Task&expand=projects.issuetypes.fields"
When First specify header key 'Content-Type' and value 'application/json'
Then user pass the password
When get the responce from endpoint
Then Print the responce

@updateissue
Scenario: verify the put method
Given First get the endpoint "https://dheenaguru03.atlassian.net/rest/api/2/issue/GUR-6"
When First specify header key 'Content-Type' and value 'application/json'
Then user pass the password
And Insert the body of the file '{ "fields" : { "summary": "Summary",  "description": "Description"  }}'
And Give the Put request
And Print the responce