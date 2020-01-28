package externalDataFilesHandeller;

import dataFilesReaders.PropertiesFileReader;

public class SandboxConfigReader extends PropertiesFileReader {

	
	public static String getProberty(String RequiredUsername) {
		
		PropertiesFileReader.readProbFile("Configuration/SandboxStubsConfig.properties");
		return prop.getProperty(RequiredUsername);	
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(getProberty("stubsName"));
		
	}
	
	
}
