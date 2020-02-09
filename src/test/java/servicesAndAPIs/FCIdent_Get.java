package servicesAndAPIs;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.sql.Timestamp;

import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

//import io.restassured.http.ContentType;

public class FCIdent_Get {//extends restAssuredConfiguration{
	private static long getTimeStamp() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		long timeStampInMilliSeconds = ts.getTime();
		return timeStampInMilliSeconds;
	}

	// startSeesion;	
	Hashing_DSL_Get  hashngDSL;
	static String  umdid,responseAsString;
	static Cookies cookie;

	//@Test
	public static void validateFCIdent(String username , String password) throws IOException, ParseException{
		//startSeesion = new StartSession_post_DSL();
		StartSession_post_DSL.startSession( username, password);

		
		RestAssured.baseURI = "https://fc.vodafone.de";
		long TSInMilliSeconds = getTimeStamp();
		System.out.println(TSInMilliSeconds);
		Response res = given().
				//header("Content-Type","application/JSON").
				header("Referer","https://www.vodafone.de/api").
				header("x-vf-target-auth-system","M").
				header("x-vf-api",TSInMilliSeconds).
				header("x-client-application","VFAPP").
				header("x-vf-rep-from","app").
				header("Platform","ios").
				//header("accept","application/JSON").
				queryParam("s2s", "2").
				queryParam("acn", Hashing_DSL_Get.getACN(username,password)).
				cookie("mint",StartSession_post_DSL.mintSession).
				cookie("mint-session-id",StartSession_post_DSL.mintSessionId).
				cookie("mint-sso-token",StartSession_post_DSL.iPlanetDirectoryProToken).log().all().
				when().
				get("/op/meinvf-apps-ident/ident").
				then().
				statusCode(200).log().all().
				extract().response();

				responseAsString = res.asString();



		 cookie = res.detailedCookies();
		System.out.println("A5eeeeeraaaaan COOOOKIESSSSSS "+ cookie.getValue("umdid"));
	}

	public static String getUmdid(String username, String password) throws IOException, ParseException {
		validateFCIdent(username,password);
		umdid = cookie.getValue("umdid");
		return umdid; 
	}

//	@Test
//	public void testGettingValue() throws IOException, ParseException {
//		System.out.println("UMDID is :   "+ getUmdid());;
//	}


}
