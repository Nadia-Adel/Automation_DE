package servicesAndAPIs;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.sql.Timestamp;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import externalDataFilesHandeller.GetUserFromJson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

//import io.restassured.http.ContentType;

public class UnbilledUsage_Get {//extends restAssuredConfiguration{
	private static long getTimeStamp() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		long timeStampInMilliSeconds = ts.getTime();
		return timeStampInMilliSeconds;
	}


	public static String msisdn_ ;


	public static JsonPath validateUnbilledUsage(String msisdn) throws IOException, ParseException{
	
		RestAssured.baseURI = "https://www.vodafone.de";
		long TSInMilliSeconds = getTimeStamp();

		Response res = given().
				header("Content-Type","application/JSON").
				header("x-vf-target-auth-system","M").
				header("Referer","https://www.vodafone.de/api").
				header("x-vf-api",TSInMilliSeconds).
				queryParam("market-code", "MMC").
				cookie("mint",StartSession_post_Mobile.mintSession).
				cookie("mint-session-id",StartSession_post_Mobile.mintSessionId).
				cookie("mint-sso-token",StartSession_post_Mobile.mintSSOToken).
				when()
				.get("/api/enterprise-resources/core/bss/sub-nil/mobile/payment/service-usages/subscriptions/" + msisdn +"/unbilled-usage?market-code=MMC")
				.then().statusCode(200).log().all().contentType(ContentType.JSON).extract().response();

		String res2 = res.asString();
		JsonPath js= new JsonPath(res2);
		return js;

	}

	public static String getHomeScreenActualCost_ServiceValue(String username ,String password) throws IOException, ParseException  {
		username = GetUserFromJson.getUsername("PostpaidUSer_Enojymore");
		password = GetUserFromJson.getpassword("PostpaidUSer_Enojymore"); 
		msisdn_ = StartSession_post_Mobile.getMSISDN(username, password);

		JsonPath js = validateUnbilledUsage(msisdn_);

		return js.get("serviceUsageVBO.usageAccounts[0].details.amount");		
	} 

	public static String getServiceDescription(String username, String password) throws IOException, ParseException {
		username = GetUserFromJson.getUsername("PostpaidUSer_Enojymore");
		password = GetUserFromJson.getpassword("PostpaidUSer_Enojymore"); 
		msisdn_ = StartSession_post_Mobile.getMSISDN(username, password);

		JsonPath js = validateUnbilledUsage(msisdn_);
		return js.get("serviceUsageVBO.usageAccounts[0].usageGroup[0].usage[1].description");

	}


	public static String getHomeScreenVfpassUsedAmount(String username ,String password) throws IOException, ParseException {

		username = GetUserFromJson.getUsername("PostpaidUSer_Enojymore");
		password = GetUserFromJson.getpassword("PostpaidUSer_Enojymore"); 
		msisdn_ = StartSession_post_Mobile.getMSISDN(username, password);

		JsonPath js = validateUnbilledUsage(msisdn_);

		return js.get("serviceUsageVBO.usageAccounts[0].usageGroup[2].usage[1].used");
	}

	public static String getHomeScreenVfpassUsedServiceIdentfier(String username ,String password) throws IOException, ParseException {

		username = GetUserFromJson.getUsername("PostpaidUSer_Enojymore");
		password = GetUserFromJson.getpassword("PostpaidUSer_Enojymore"); 
		msisdn_ = StartSession_post_Mobile.getMSISDN(username, password);

		JsonPath js = validateUnbilledUsage(msisdn_);

		return js.get("serviceUsageVBO.usageAccounts[0].usageGroup[2].usage[1].name");
	}
	
	public static String getHomeScreenVfpassUsedUnitOfMeasure(String username ,String password) throws IOException, ParseException {

		username = GetUserFromJson.getUsername("PostpaidUSer_Enojymore");
		password = GetUserFromJson.getpassword("PostpaidUSer_Enojymore"); 
		msisdn_ = StartSession_post_Mobile.getMSISDN(username, password);

		JsonPath js = validateUnbilledUsage(msisdn_);

		return js.get("serviceUsageVBO.usageAccounts[0].usageGroup[2].usage[1].unitOfMeasure");
	}
	
	
	@Test
	public void testunbilledUsage() throws IOException, ParseException {

		System.out.println(getHomeScreenVfpassUsedUnitOfMeasure(GetUserFromJson.getUsername("PostpaidUSer_Enojymore"),GetUserFromJson.getpassword("PostpaidUSer_Enojymore")));
		//System.err.println(getServiceDescription(GetUserFromJson.getUsername("PostpaidUSer_Enojymore"),GetUserFromJson.getpassword("PostpaidUSer_Enojymore")));	
	}

}
