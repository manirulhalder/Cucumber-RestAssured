package HTTPOps;

import static com.jayway.restassured.RestAssured.given;

import java.util.Map;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.EncoderConfig;
import com.jayway.restassured.response.Response;

public class HTTPOperations {
	/*
	1. This class handles Rest-Assured operations
	2. It handles different types of http/https request types such as GET, POST, DELETE, .... etc
	3. You can more request types when needed
	4. "HTTPRequest" is static method accepts api url, type, headers and body(if mandatory) and returns the whole response
	5. Rest-Assured response object contains body, headers, cookies and response code.
	 */
	
	public static Response HTTPRequest(String URL, String Type, Map<String, String> headersMap, String body){
		Response res = null;
		if(Type.trim().equalsIgnoreCase("POSTFormData")){
			String [] params = body.split("=");
			if(headersMap.size()>0){
				res = given()
						.multiPart(params[0], params[1])
						.config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
								.relaxedHTTPSValidation().headers(headersMap)
						.when()
						.post(URL);
			}else{
				res = given()
						.multiPart(params[0], params[1])
						.config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
								.relaxedHTTPSValidation()
						.when()
						.post(URL);
			}
		}
		if(Type.trim().equalsIgnoreCase("SOAP")){
			res = given().config(RestAssured.config()
					.encoderConfig(EncoderConfig.encoderConfig()
							.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
				    .relaxedHTTPSValidation().headers(headersMap)
				    .body(body)
				    .when()
				    .post(URL);	
		}else if(Type.trim().equalsIgnoreCase("GET")){
			if(headersMap.size()>0){
				res = given().config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
								.relaxedHTTPSValidation().headers(headersMap)
						.when()
						.get(URL);
			}else{
				res = given().config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
								.relaxedHTTPSValidation()
						.when()
						.get(URL);
			}			
		}else if(Type.trim().equalsIgnoreCase("DELETE")){
			if(headersMap.size()>0){
				res = given().config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
								.relaxedHTTPSValidation().headers(headersMap)
						.body(body)
						.when()
						.delete(URL);
			}else{
				res = given().config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
								.relaxedHTTPSValidation()
						.body(body)
						.when()
						.delete(URL);
			}			
		}else if(Type.trim().equalsIgnoreCase("POST")){
			if(headersMap.size()>0){
				res = given().config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
								.relaxedHTTPSValidation().headers(headersMap)
						.body(body)
						.when()
						.post(URL);
			}else{
				res = given().config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
								.relaxedHTTPSValidation()
						.body(body)
						.when()
						.post(URL);
			}
		}else if(Type.trim().equalsIgnoreCase("PATCH")){
			if(headersMap.size()>0){
				res = given().config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
								.relaxedHTTPSValidation().headers(headersMap)
						.body(body)
						.when()
						.patch(URL);
			}else{
				res = given().config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
								.relaxedHTTPSValidation()
						.body(body)
						.when()
						.patch(URL);
			}
		}else if(Type.trim().equalsIgnoreCase("PUT")){
			if(headersMap.size()>0){
				res = given().config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
								.relaxedHTTPSValidation().headers(headersMap)
						.body(body)
						.when()
						.put(URL);
			}else{
				res = given().config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
								.relaxedHTTPSValidation()
						.body(body)
						.when()
						.put(URL);
			}
		}
		return res;
	}
}
