package dataFilesHandeller;

import java.io.IOException;

import dataFilesReaders.PropertiesFileReader;

public class CMSConfigFilesReader extends PropertiesFileReader{

public static String getRequiredPath(String cmsSourcePath)throws IOException, InterruptedException{

		
		PropertiesFileReader.readProbFile("Configuration/CMSFilesConfig.properties");
		return prop.getProperty(cmsSourcePath);

	}


public static void main(String [] args) throws IOException, InterruptedException {
	
	System.out.println(getRequiredPath("ActualCost_FirstEligible_SquareTile"));
}



}
