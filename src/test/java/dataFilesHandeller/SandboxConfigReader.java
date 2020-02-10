package dataFilesHandeller;

import dataFilesReaders.PropertiesFileReader;

public class SandboxConfigReader extends PropertiesFileReader {

	
	// send the required property key
	public static String getProberty(String requiredProperty) {
		
		PropertiesFileReader.readProbFile("Configuration/SandboxStubsConfig.properties");
		// return required value
		return prop.getProperty(requiredProperty);	
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(getProberty("stubsName"));
		
	}
	
	
}
