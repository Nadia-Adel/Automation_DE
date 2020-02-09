package sandboxNewSolution;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import terminalOperatgions.CMDFeatures;


public class SandBoxes {

	 static String  batFileLocation = null ;	
	
	public static HashMap<String,String> ReplaceAPI (String API_Name , String NewBody ) 	{
		SandBoxes_APIS SB = new SandBoxes_APIS();
	
		HashMap<String,String> map = SB.main(null);

		map.replace(API_Name , NewBody );
		//		System.out.print(map);
		return map ;
	}

	public static void WriteSandBox (HashMap<String,String> map ) 

	{

		// .bat file to commit changes 
		
		String Content ="state.users = state.users || []\r\n";

		for (Map.Entry mapy : map.entrySet()) {
			Content = Content.concat(mapy.getValue().toString()+ "\r\n"); 
		}

		String newResponseFilePath = "/Users/medhatali/Documents/MobileFramework/Sandbox_Clone_Stubs/cycc-n_StubsVersion/main.js";

		File NeWFile = new File(newResponseFilePath);
		FileWriter writer = null;

		try
		{
			//Rewriting the input text file with newContent
			writer = new FileWriter(NeWFile);        
			writer.write(Content);
			writer.close();


			// commit the changes 
			//	Runtime. getRuntime().exec("cmd /c start \"\"  " + fileLocation);
			batFileLocation = "/Users/medhatali/Desktop/MacConfig/UpdateGithubSandbox.sh";
			try {
				CMDFeatures.RunBashScriptToUpdateCMSFile(batFileLocation);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e)   {   e.printStackTrace();    }

	}


	public static void UpdateSandBox (String API_Name , String NewBody)
	{

		HashMap<String,String> map ;

		map = ReplaceAPI( API_Name , NewBody ) ;
		WriteSandBox( map) ;
	}
}