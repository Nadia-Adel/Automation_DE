package servicesAndAPIs;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.sql.Timestamp;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import dataFilesHandeller.GetUserFromJson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

//import io.restassured.http.ContentType;

public class FCAPI_Get {//extends restAssuredConfiguration{
	private static long getTimeStamp() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		long timeStampInMilliSeconds = ts.getTime();
		return timeStampInMilliSeconds;
	}

 	
	
	public void validateFCAPI_GET(String username, String password) throws IOException, ParseException{
		//startSeesion = new StartSession_post_DSL();
		//startSeesion.startSession();
		//System.out.println(" Evidence " + startSeesion.iPlanetDirectoryProToken);
		
		
		StartSession_post_DSL.startSession(username, password);
		RestAssured.baseURI = "https://www.vodafone.de";
		long TSInMilliSeconds = getTimeStamp();
		System.out.println(TSInMilliSeconds);
		Response res = given().
				header("Content-Type","application/JSON").
				header("Referer","https://www.vodafone.de/api").
				header("x-vf-api",TSInMilliSeconds).
				cookie("mint",StartSession_post_DSL.mintSession).
				cookie("mint-session-id",StartSession_post_DSL.mintSessionId).
				cookie("mint-sso-token",StartSession_post_DSL.iPlanetDirectoryProToken).
				when()
				.get("/mint/vfssdublin/prx/fcapi")
				.then().statusCode(200).log().all().contentType(ContentType.JSON).extract().response();

		String res2 = res.asString();

		//JsonPath js = new JsonPath(res2);

		//System.out.println("Required Token is : " + js.get("subscriptionVBO[0].accountId"));
	}
	@Test
	public void callAPI() throws IOException, ParseException {
		
		validateFCAPI_GET(GetUserFromJson.getUsername("DSLUser"), GetUserFromJson.getpassword("DSLUser"));
		
	}
}
