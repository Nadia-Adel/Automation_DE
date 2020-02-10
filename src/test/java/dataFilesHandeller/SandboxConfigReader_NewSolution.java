package externalDataFilesHandeller;

import dataFilesReaders.PropertiesFileReader;

public class SandboxConfigReader_NewSolution extends PropertiesFileReader {

	
	public static String getProberty(String RequiredUsername) {
		
		PropertiesFileReader.readProbFile("Configuration/SandboxStubsConfig_NewSolution.properties");
		return prop.getProperty(RequiredUsername);	
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(getProberty("startSession_401"));
		
	}
	
	
}
