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

public class Info_Post {//extends restAssuredConfiguration{
	private static long getTimeStamp() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		long timeStampInMilliSeconds = ts.getTime();
		return timeStampInMilliSeconds;
	}

StartSession_post_DSL startSeesion;	

	//@Test
	public static void validateInfo_Post(String username , String password) throws IOException, ParseException{
		//startSeesion = new StartSession_post_DSL();
		StartSession_post_DSL.startSession(username,password);
		
		//fcIdentGet = new FCIdent_Get();
		
		RestAssured.baseURI = "https://fc.vodafone.de";
		long TSInMilliSeconds = getTimeStamp();
		System.out.println(TSInMilliSeconds);
		Response res = given().
				header("Content-Type","application/JSON").
				header("Referer","https://www.vodafone.de/api").
				header("x-vf-api",TSInMilliSeconds).
				body(APIs_Body.returnInfoPostBody()).
				queryParam("permissions").
				queryParam("notifications").
				queryParam("attributes").
				queryParam("out", "json").
				queryParam("umdid", FCIdent_Get.getUmdid(username,password)).
				cookie("mint",StartSession_post_DSL.mintSession).
				cookie("mint-session-id",StartSession_post_DSL.mintSessionId).
				cookie("mint-sso-token",StartSession_post_DSL.mintSSOToken).log().all().
				when().
				post("/op/vfde-apps/info").
				then().statusCode(200).log().all().
				contentType(ContentType.JSON).
				extract().response();
		
		
	//	{{url_base_info}}op/vfde-apps/info?permissions&notifications&attributes&out={{out}}&umdid={{umdid}}

		String res2 = res.asString();

		JsonPath js = new JsonPath(res2);

		//System.out.println("Required Token is : " + js.get("subscriptionVBO[0].accountId"));
	}
	
	@Test
	public void testInfoPost() throws IOException, ParseException {
		validateInfo_Post(GetUserFromJson.getUsername("DSLUser"), GetUserFromJson.getpassword("DSLUser"));
	}
}
