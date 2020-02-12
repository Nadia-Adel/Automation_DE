package servicesAndAPIs;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import dataFilesHandeller.GetUserFromJson;
import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StartSession_post_Mobile {
	public static String mintSession, mintSessionId,mintSSOToken,MSISDN;	

	//@Test
	public static JsonPath startSession(String username,String password ) throws IOException, ParseException{
		RestAssured.baseURI="https://www.vodafone.de";

		Response res = given().header("Content-Type","application/json").
				body(APIs_Body.returnStartSessionBody_Mobile(username, password))
				.when().post("/mint/rest/session/start").then()
				.assertThat().statusCode(200).log().body().extract().response();

		String res2 = res.asString();



		Cookies cookie = res.detailedCookies();
		mintSession = cookie.getValue("mint");
		mintSessionId = cookie.getValue("mint-session-id");
		mintSSOToken = cookie.getValue("mint-sso-token");

		//System.out.println(cookie);
		//System.out.println(mintSession);	

		return new JsonPath(res2);


	}

	public static String getMSISDN(String username , String password) throws IOException, ParseException {

		MSISDN = startSession(username,password).get("msisdn");
		return MSISDN;

	}

	//@Test	
	public void testMSISDN() throws IOException, ParseException {

		System.out.println(getMSISDN(GetUserFromJson.getUsername("PostpaidUSer_Enojymore"),GetUserFromJson.getpassword("PostpaidUSer_Enojymore")));

	}
}
