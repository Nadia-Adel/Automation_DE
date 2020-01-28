package servicesAndAPIs;

public class APIs_Body {
	public static String requestBody;


	public static String returnUrbanAirShipBody(String userUDID, String Platform, String Deeplink , String notificationContent) {

		requestBody = "{\r\n" + 
				"  \"audience\": {\r\n" + 
				"    \"named_user\": \""+userUDID+"\"\r\n" + 
				"  },\r\n" + 
				"  \"device_types\": [\""+Platform+"\"],\r\n" + 
				"  \"notification\": {\r\n" + 
				"    \"alert\": \""+notificationContent+"\",\r\n" + 
				"    \"actions\": {\r\n" + 
				"      \"app_defined\": {\r\n" + 
				"            \"^d\": \""+Deeplink+"\"\r\n" + 
				"          }\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}";

		return requestBody;
	}

	public static String returnStartSessionBody_Mobile(String ServiceUsername, String ServiceUserPassword ) {
		requestBody ="{\r\n" +
				"    \"username\": \""+ServiceUsername+"\",\r\n" +
				"    \"credential\": \""+ServiceUserPassword+"\",\r\n" +
				"    \"authMethod\": \"MSISDN\",\r\n" +
				"    \"byPIN\": false,\r\n" +
				"    \"additionalParameters\": {\r\n" +
				"        \"deviceType\": \"Smartphone\"\r\n" +
				"    }\r\n" +
				"}";

		return requestBody;

	}

	public static String returnStartSessionBody_DSL(String ServiceUsername, String ServiceUserPassword ) {
		requestBody ="{\n" + 
				"    \"username\": \""+ServiceUsername+"\",\r\n" +
				"    \"password\": \""+ServiceUserPassword+"\",\r\n" +
				"	\"clientType\": \"Portal\"\n" + 
				"}";

		return requestBody;

	}






}
