package externalDataFilesHandeller;

import dataFilesReaders.PropertiesFileReader;

public class UrbanAirshipAPI_NotificationBody_Handeller extends PropertiesFileReader {
	
	public static String getRequiredMessage(String reqMessage){

		
		PropertiesFileReader.readProbFile("Configuration/urbanAirShipAPIConfig_NotificationMessage.properties");
		return prop.getProperty(reqMessage);

		
	}
	
	public static void main(String [] args) {
		
		System.out.println(getRequiredMessage("Transfer_DEEPLINK_NotificationMessage"));
	}
	
}

