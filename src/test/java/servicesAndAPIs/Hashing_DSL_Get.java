package servicesAndAPIs;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.sql.Timestamp;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

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

	StartSession_post_DSL startSeesion;	

	String acnValue =null;
	String responseAsString;
//	@Test
	public void validateHashingService() throws IOException, ParseException{
		startSeesion = new StartSession_post_DSL();
		startSeesion.startSession();
		System.out.println(" Evidence " + startSeesion.iPlanetDirectoryProToken);

		RestAssured.baseURI = "https://www.vodafone.de";
		long TSInMilliSeconds = getTimeStamp();
		System.out.println(TSInMilliSeconds);
		Response res = given().
				header("Content-Type","application/JSON").
				header("Referer","https://www.vodafone.de/api").
				header("x-vf-api",TSInMilliSeconds).
				cookie("mint",startSeesion.mintSession).
				cookie("mint-session-id",startSeesion.mintSessionId).
				cookie("mint-sso-token",startSeesion.iPlanetDirectoryProToken).
				cookie("MDDKeks",startSeesion.MDDKeksToken).
				cookie("authHint",startSeesion.authHintToken).
				cookie("amlbcookie",startSeesion.amlbcookieToken).
				when()
				.get("/meinvodafone/services/api/hashing")
				.then().statusCode(200).log().all().contentType(ContentType.JSON).extract().response();

		responseAsString = res.asString();


	}


	public String getACN() throws IOException, ParseException {

		validateHashingService();
		JsonPath js = new JsonPath(responseAsString);
		return js.get("hashedIds[0].hash");
	}

	@Test
	public  void  runAPI() throws IOException, ParseException {
		
		System.out.println("acn"+ getACN());
	}


}
