package stepDefinitions;

import org.assertj.core.api.Assertions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorSteps {

	RequestSpecification requestSpecification;
	Response response;

	@Given("a REST API endpoint")
	public void setEndpoint() {
		// Set the API
		RestAssured.baseURI = "https://openlibrary.org/authors/OL1A.json";
	}

	@When("a user sends a GET request")
	public void sendGETRequest() {
		// Send GET Request
		requestSpecification = RestAssured.given();
		response = requestSpecification.get();
		CommonSteps.addAPILog(response, "Status code is " + response.getStatusCode());
	}

	@Then("a user validates the (.*) and (.*)$")
	public void verifyResponse(String name, String value) {
		// Extract the value from the body
		String actualValue = response.jsonPath().getString(name);
		CommonSteps.addAPILog(response, "Checking if " + name + " contains " + value);
		// Check the value returned
		Assertions.assertThat(actualValue.contains(value));
		CommonSteps.addAPILog(response, "Comparison successful");
		
	}
}
