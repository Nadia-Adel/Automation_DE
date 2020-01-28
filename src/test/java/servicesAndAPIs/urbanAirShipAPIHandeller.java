package servicesAndAPIs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class urbanAirShipAPIHandeller {
	
	public static void sendNotification(String userMDID, String Platform, String deepLink , String notificationMessage) {

		RestAssured.baseURI = "https://go.urbanairship.com/api";
		String requestBody = APIs_Body.returnUrbanAirShipBody(userMDID, Platform, deepLink,notificationMessage);

		Response response = null;

		try {
			response = RestAssured.given()
					.contentType(ContentType.JSON)
					.auth()
					.basic("YoKYauDWSBS5W9tMWblu_A", "FzzoLl6oTkuKjpPKIEnYsA")
					//.header("Authorization", "Basic WW9LWWF1RFdTQlM1Vzl0TVdibHVfQTogRnp6b0xsNm9Ua3VLanBQS0lFbllzQQ==")
					.body(requestBody)
					.post("/push/").then().log().all().contentType(ContentType.JSON).extract().response();                    
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("The response is  :  " + response.asString());
	}

	
	
	public static void main(String [] args)
	{
	  
		// https://www.vodafone.de/meinvodafone/app/tariff
		
		// https://www.vodafone.de/meinvodafone/app/tariff?tab=contract
		
		// https://www.vodafone.de/meinvodafone/app/netzinfo?tab=mobilenet
		
		// https://www.vodafone.de/meinvodafone/app/offer/details?mboxname=mbox_mv_app_gigalive_mvf_test2_3//concerned//cannot inspect web page 
		
		// https://www.vodafone.de/meinvodafone/app/quickcheck // concerned // load forever
		//https://www.vodafone.de/hilfe/rechnung/online-rechnung.html
		// https://www.vodafone.de/meinvodafone/app/recharge
		//https://www.vodafone.de/hilfe/vertrag/vertragsverlaengerung.html
		//https://www.vodafone.de/hilfe/vertrag/vertrag-laufzeit.html
		
		//https://www.vodafone.de/hilfe/tarife/red-plus.html // postpaid
		//https://www.vodafone.de/hilfe/vertrag/meine-daten.html // not for prepaid
		//https://www.vodafone.de/hilfe/vertrag/vertrag-laufzeit.html // not for prepaid 
		//https://www.vodafone.de/hilfe/rechnung/online-rechnung.html // not for prepaid 
		
		//https://www.vodafone.de/hilfe/vertrag/vertragsverlaengerung.html // not for prepaid
		
		//https://www.vodafone.de/hilfe/prepaid/callya-aufladen.html // good for prepaid 
		
		
		sendNotification("57fb6917-cb94-4207-a312-df26293616e6", "ios", "https://www.vodafone.de/meinvodafone/app/faq","new mapping Deep links");
		
	}
}

