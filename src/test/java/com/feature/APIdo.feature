Feature: To test the Api integration

@getmethod
Scenario: To specify the get method 
Given First get the endpoint "https://reqres.in/api/users?page=2"
Then  get the responce from endpoint
And Print the responce
Then Check the status code "200" of responce  received 
And user verify the json "data[0].id" and the responce for that is  "7"


@singleuserget
Scenario: To specify the get method 
Given First get the endpoint "https://reqres.in/api/users/2"
Then  get the responce from endpoint
And Print the responce
Then Check the status code "200" of responce  received 
And user verify the json "data.id" and the responce for that is  "2"
And user verify the jason "ad.text" and responce for contains "A weekly newsletter"

@post(create)
Scenario: check the Post method

Given First get the endpoint "https://reqres.in/api/users"
When Insert the body of the file '{"name": "morpheus","job": "leader"}'
Then Give the Post request
Then Print the responce
And Check the status code "201" of responce  received
And check the value of jason "id" present or not

@put
Scenario: check the PUT method

Given First get the endpoint "https://reqres.in/api/users/2"
When Insert the body of the file '{"name": "morpheus","job": "zion resident"}'
Then Give the Put request
And Print the responce
And Check the status code "200" of responce  received
And check the value of jason "updatedAt" present or not

@deleteuser
Scenario: Delete the user
Given First get the endpoint "https://reqres.in/api/users/2"
Then delete the endpoint
And Check the status code "204" of responce  received