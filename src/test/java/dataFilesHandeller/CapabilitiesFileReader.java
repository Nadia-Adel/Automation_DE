package externalDataFilesHandeller;

import java.io.BufferedReader;
import java.io.FileReader;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesFileReader {

	public DesiredCapabilities getCapabilities() {

		DesiredCapabilities capabs = new DesiredCapabilities();

		BufferedReader reader ;
		try {

			reader = new BufferedReader(new FileReader(ConfigurationFileHandeller.getCapabsFilePath()));

			String line = reader.readLine();
			while (line!=null) {

				//System.out.println(line);
				String [] tempCap = line.split("=");
				capabs.setCapability(tempCap[0], tempCap[1]);
				//System.out.println(tempCap[1]);
				line = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return capabs ;
	}
	
	
	public static void main(String[] args) {
	CapabilitiesFileReader cabReader = new CapabilitiesFileReader();
	cabReader.getCapabilities();	
	
	}


}
