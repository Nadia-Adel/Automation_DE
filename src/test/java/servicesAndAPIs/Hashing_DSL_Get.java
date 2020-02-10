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

public class Hashing_DSL_Get {//extends restAssuredConfiguration{
	private static long getTimeStamp() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		long timeStampInMilliSeconds = ts.getTime();
		return timeStampInMilliSeconds;
	}

	//StartSession_post_DSL startSeesion;	

	static String acnValue =null;
	static String responseAsString;
//	@Test
	public static JsonPath validateHashingService(String username, String password) throws IOException, ParseException{
	//	startSeesion = new StartSession_post_DSL();
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
				cookie("MDDKeks",StartSession_post_DSL.MDDKeksToken).
				cookie("authHint",StartSession_post_DSL.authHintToken).
				cookie("amlbcookie",StartSession_post_DSL.amlbcookieToken).
				when()
				.get("/meinvodafone/services/api/hashing")
				.then().statusCode(200).log().all().contentType(ContentType.JSON).extract().response();

		responseAsString = res.asString();
		
		JsonPath js = new JsonPath(responseAsString);
		return js;


	}


	public static String getACN( String username, String password ) throws IOException, ParseException {
		username = GetUserFromJson.getUsername("DSLUser");
		password = GetUserFromJson.getpassword("DSLUser");
		
		JsonPath js = validateHashingService(username,password);
		return js.get("hashedIds[0].hash");
	}

	@Test
	public  void  runAPI() throws IOException, ParseException {
		
		System.out.println("acn"+ getACN(GetUserFromJson.getUsername("DSLUser"),GetUserFromJson.getpassword("DSLUser")));
	}


}
