package FeatureDefinitions;

import CommonDefinitions.mainDefinition;
import HTTPOps.HTTPOperations;
import com.jayway.restassured.response.Response;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class sampleDefinitions extends mainDefinition {
    /*
     1. sample class extends mainDefinition to reuse test data from external data source (Excel file)
     2. testData is map object that contains test data and be accessed as per: 'testData.get("key")'
     */
    Response response = null;
    Map<String, String> headers = new HashMap<>();
    @Given("^call google api$")
    public void callGoogleApi() throws Throwable {
        response = HTTPOperations.HTTPRequest(testData.get("sample_url"),
                testData.get("sample_type"),
                headers,
                testData.get("sample_body"));
    }
    @Then("^validate status code is (\\d+)$")
    public void validateStatusCodeIs(int expectedStatusCode) throws Throwable {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Status code is invalid");
    }
}