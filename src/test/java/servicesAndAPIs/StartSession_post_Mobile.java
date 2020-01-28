package servicesAndAPIs;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.GetUserFromJson;
import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StartSession_post_Mobile {
public String mintSession, mintSessionId,mintSSOToken;	

@Test
	public void startSession() throws IOException, ParseException{
		RestAssured.baseURI="https://www.vodafone.de";
		
		Response res = given().header("Content-Type","application/json").
		body(APIs_Body.returnStartSessionBody_Mobile(GetUserFromJson.getUsername("DSLUser"), GetUserFromJson.getpassword("DSLUser")))
		.when().post("/mint/rest/session/start").then()
		.assertThat().statusCode(200).log().body().extract().response();

		String res2 = res.asString();

		JsonPath js = new JsonPath(res2);

		Cookies cookie = res.detailedCookies();
		mintSession = cookie.getValue("mint");
		mintSessionId = cookie.getValue("mint-session-id");
		mintSSOToken = cookie.getValue("mint-sso-token");
		System.out.println(js);
		System.out.println(cookie);
		System.out.println(mintSession);	
	}

}
