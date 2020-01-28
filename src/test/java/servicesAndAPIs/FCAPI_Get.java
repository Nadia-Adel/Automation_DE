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

//import io.restassured.http.ContentType;

public class FCAPI_Get {//extends restAssuredConfiguration{
	private static long getTimeStamp() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		long timeStampInMilliSeconds = ts.getTime();
		return timeStampInMilliSeconds;
	}

StartSession_post_DSL startSeesion;	
	@Test
	public void validatetariffPlan() throws IOException, ParseException{
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
				when()
				.get("/mint/vfssdublin/prx/fcapi")
				.then().statusCode(200).log().all().contentType(ContentType.JSON).extract().response();

		String res2 = res.asString();

		JsonPath js = new JsonPath(res2);

		//System.out.println("Required Token is : " + js.get("subscriptionVBO[0].accountId"));
	}
}
