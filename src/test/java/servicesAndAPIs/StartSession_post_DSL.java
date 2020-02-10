package servicesAndAPIs;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import dataFilesHandeller.GetUserFromJson;
import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StartSession_post_DSL {
public static String mintSession, mintSessionId,mintSSOToken,iPlanetDirectoryProToken,umdidToken,MDDKeksToken,authHintToken,amlbcookieToken;	


	public static void startSession(String username, String password) throws IOException, ParseException{
		RestAssured.baseURI="https://www.vodafone.de";
		
		Response res = given().header("Content-Type","application/json").
		body(APIs_Body.returnStartSessionBody_DSL(username,password))
		.when().post("/mint/session/start").then()
		.assertThat().statusCode(200).log().all().extract().response();

		String res2 = res.asString();

		JsonPath js = new JsonPath(res2);

		Cookies cookie = res.detailedCookies();
		mintSession = cookie.getValue("mint");
		mintSessionId = cookie.getValue("mint-session-id");
		iPlanetDirectoryProToken = cookie.getValue("iPlanetDirectoryPro");
		MDDKeksToken=cookie.getValue("MDDKeks");
		authHintToken=cookie.getValue("authHint");
		amlbcookieToken=cookie.getValue("amlbcookie");
		
		//umdidToken=cookie.getValue("UMDID");
		//System.out.println(js);
		//System.out.println(cookie);
//		System.out.println("Mint session token"+mintSession);	
//		System.out.println("iPlanetDirectoryProToken is " +  iPlanetDirectoryProToken );
//		System.out.println("MDDKeks IS " + MDDKeksToken);
//		System.out.println("auth IS " + authHintToken);
//		System.out.println("amlb IS " + amlbcookieToken);
//		
		//System.out.println("UMDID is : " + umdidToken);
		
	}
	
	//@Test
	public void testStart() throws IOException, ParseException {
		
		startSession(GetUserFromJson.getUsername("DSLUser"), GetUserFromJson.getpassword("DSLUser"));	
	}

}
