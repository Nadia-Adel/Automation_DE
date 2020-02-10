package dataFilesHandeller;

import dataFilesReaders.PropertiesFileReader;

public class ConfigurationFileHandeller extends PropertiesFileReader{


	public static String getPlatformName(){
		
		PropertiesFileReader.readProbFile("Configuration/Config.properties");
		return prop.getProperty("PLATFORM_NAME");

	}
	public static String getAppiumServerURL(){

		PropertiesFileReader.readProbFile("Configuration/Config.properties");
		return prop.getProperty("APPIUM_SERVER_URL");

	}

	public static String getCapabsFilePath(){
		PropertiesFileReader.readProbFile("Configuration/Config.properties");
		return prop.getProperty("CAPABS_FILE_PATH");

	}

	public static void main (String [] args) {
		
		System.out.println(getAppiumServerURL());
		
	}
	
	


}

