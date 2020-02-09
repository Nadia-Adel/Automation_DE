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

public class SubscribtionsDSL_Get {//extends restAssuredConfiguration{
	private static long getTimeStamp() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		long timeStampInMilliSeconds = ts.getTime();
		return timeStampInMilliSeconds;
	}

StartSession_post_Mobile startSeesion;

	@Test
	public void validatetariffPlan() throws IOException, ParseException{
		
		//startSeesion = new StartSession_post_Mobile();
		//startSeesion.startSession();
		
		//System.out.println(" Evidence " + startSeesion.mintSSOToken);
		
		RestAssured.baseURI = "https://www.vodafone.de";
		long TSInMilliSeconds = getTimeStamp();
		System.out.println(TSInMilliSeconds);
		Response res = given().
				header("Content-Type","application/JSON").
				header("x-vf-target-auth-system","M").
				header("Referer","https://www.vodafone.de/api").
				header("x-vf-api",TSInMilliSeconds).
				queryParam("market-code", "MMC").
				cookie("mint",StartSession_post_DSL.mintSession).
				cookie("mint-session-id",StartSession_post_DSL.mintSessionId).
				cookie("mint-sso-token",StartSession_post_DSL.mintSSOToken).
				when()
				.get("/api/enterprise-resources/core/bss/sub-nil/mobile/subscriptions/491624113644/tariff-plan")
			    .then().statusCode(200).log().all().contentType(ContentType.JSON).extract().response();

		String res2 = res.asString();

		JsonPath js = new JsonPath(res2);

		System.out.println("Required Token is : " + js.get("subscriptionVBO[0].accountId"));
		
	}
}
