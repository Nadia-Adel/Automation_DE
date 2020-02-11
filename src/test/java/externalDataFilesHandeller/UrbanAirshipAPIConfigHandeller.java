package externalDataFilesHandeller;

import dataFilesReaders.PropertiesFileReader;

public class UrbanAirshipAPIConfigHandeller extends  PropertiesFileReader {
	
	public static String getPlatformName_IOS(){

		PropertiesFileReader.readProbFile("Configuration/urbanAirShipAPIConfig.properties");
		return prop.getProperty("PLATFORM_NAME_IOS");

	}
	public static String getUserUDID(String userUDID){

		PropertiesFileReader.readProbFile("Configuration/urbanAirShipAPIConfig.properties");
		return prop.getProperty(userUDID);

	}

	public static String getReguiredDEEPLINK(String Deeplink){
		PropertiesFileReader.readProbFile("Configuration/urbanAirShipAPIConfig.properties");
		return prop.getProperty(Deeplink);

	}
}

