package com.Stepdefenition;

import java.io.File;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Stepdefenition {

	static RequestSpecification req = RestAssured.given();
	static Response responce;
	static String endpoint; 

@Given("^First get the endpoint \"([^\"]*)\"$")
public void first_get_the_endpoint(String arg1) throws Throwable {
 	endpoint = arg1;
}

//@When("^First specify header key '(.*)' and value '(.*)' $")
//public void user_specify_header_key_and_value(String key,String value) {
//
//	req = req.header(key, value);
//}

@When("^First specify header key '(.*)' and value '(.*)'$")
public void first_specify_header_key_Content_Type_and_value_application_json(String key,String value) throws Throwable {
	req = req.header(key, value);
}



@Then("^user pass the password$")
public void user_pass_the_password() throws Throwable {
	req = req.auth().preemptive().basic("guru31182@gmail.com", "1MxnC0474IuaI11U6J516CB7");
}

@Then("^get the responce from endpoint$")
public void get_the_responce_from_endpoint() throws Throwable {
       
	  responce = req.get(endpoint);
}

@Then("^Print the responce$")
public void print_the_responce() throws Throwable {
	responce.prettyPrint();
}

@Then("^Check the status code \"([^\"]*)\" of responce  received$")
public void check_the_status_code_of_responce_received(String arg1) throws Throwable {
	Assert.assertEquals(arg1, String.valueOf(responce.getStatusCode()));
}


@When("^Insert the body of the file '(.*)'$")
public void insert_the_body_of_the_file(String body) throws Throwable {
             
	req = req.when().body(body);
}

@When("^Insert the body of the file from file '(.*)'$")
public void insert_the_body_of_the_file_from_file(String body) throws Throwable {
             
	File f = new File(System.getProperty("user.dir")+"\\"+body);
	req = req.when().body(f);
}

@Then("^Give the Post request$")
public void give_the_Post_request() throws Throwable {
	
responce = req.post(endpoint);

}


@Then("^Give the Put request$")
public void give_the_Put_request() throws Throwable {

  responce = req.put(endpoint);
}

@Then("^check the value of jason \"([^\"]*)\" present or not$")
public void check_the_value_of_jason_present_or_not(String arg1) throws Throwable {
	Assert.assertNotNull(arg1);
}


@Then("^delete the endpoint$")
public void delete_the_endpoint() throws Throwable {
responce = req.delete(endpoint);
	
}

@Then("^user verify the json \"([^\"]*)\" and the responce for that is  \"([^\"]*)\"$")
public void user_verify_the_json_and_the_responce_for_that_is(String arg1, String arg2) throws Throwable {
 
	JsonPath jsonPath = responce.jsonPath();
	Object object = jsonPath.get(arg1);
	Assert.assertEquals(arg2, String.valueOf(object));
	
}

@Then("^user verify the jason \"([^\"]*)\" and responce for contains \"([^\"]*)\"$")
public void user_verify_the_jason_and_responce_for_contains(String arg1, String arg2) throws Throwable {

	JsonPath jsonPath = responce.jsonPath();
	Object object = jsonPath.get(arg1);
	Assert.assertTrue(String.valueOf(object).contains(arg2));
}






}
