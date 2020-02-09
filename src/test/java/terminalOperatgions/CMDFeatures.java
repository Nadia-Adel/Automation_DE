package terminalOperatgions;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class CMDFeatures {

	public static String utils = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "shared" + File.separator;
	public static void OpenTerminal()
	{
		try {
			Runtime.getRuntime().exec("/usr/bin/open -a Terminal");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Something Wrong With ");
			e.printStackTrace();
		}
	}
	public static void TerminalOpenSpecificFolder(String fileLocation)
	{
		try {

			String[] cmd = {"/usr/bin/open", "-a" , "Terminal", fileLocation};
			Runtime.getRuntime().exec(cmd);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Something Wrong With ");
			e.printStackTrace();
		}
	}
	public static void RunJarFileWithpackageClassName(String JarLocation,String jarFileName,String packageClassName)
	{
		try
		{
			// String jarFileName = "someJar.jar";
			String scriptFileName = "/tmp/script.sh";

			PrintWriter writer = new PrintWriter(scriptFileName, "UTF-8");
			writer.println("#!/usr/bin/env bash");
			writer.println("/usr/bin/java - jar '" + jarFileName + "'");
			writer.close();
			Runtime.getRuntime().exec("chmod u+x " + scriptFileName);
			Runtime.getRuntime().exec(new String[] {"/usr/bin/open", "-a", "Terminal", scriptFileName});

		}
		catch (Exception e)
		{
			System.out.println("HEY Buddy ! U r Doing Something Wrong ");
			e.printStackTrace();
		}
	}

	public static void RunBashScriptToUpdateCMSFile_Parameterized(String scriptFileName, String cmsSourcePath) throws IOException, InterruptedException {

		String[] command = new String[] {"/bin/bash", "-c", scriptFileName + " " + cmsSourcePath};
		Process process = new ProcessBuilder(command).start();

		StringBuilder output = new StringBuilder();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(process.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			output.append(line + "\n");
		}
		
		int exitVal = process.waitFor();
		if (exitVal == 0) {
			System.out.println("Success!");
			System.out.println(output);
			
		} else {
			System.out.println("Failure!");
			System.exit(0);
		}
	}

	public static void RunBashScriptToUpdateCMSFile(String scriptFileName) throws IOException, InterruptedException {

		String[] command = new String[] {"/bin/bash", "-c", scriptFileName};
		Process process = new ProcessBuilder(command).start();

		StringBuilder output = new StringBuilder();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(process.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			output.append(line + "\n");
		}
		
		int exitVal = process.waitFor();
		if (exitVal == 0) {
			System.out.println("Success!");
			System.out.println(output);
			//System.exit(0);
		} else {
			System.out.println("Failure!");
		}
	}
	
	public static void main(String[] args)
	{
		try
		{
			//RunBashScriptToUpdateCMSFile(CMSConfigFilesReader.getRequiredPath("bashScriptToUploadCMS_Path"), CMSConfigFilesReader.getRequiredPath("ActualCost_FirstEligible_SquareTile"));
			
			RunBashScriptToUpdateCMSFile_Parameterized("/Users/medhatali/Desktop/MacConfig/UpdateGithub_Parameterized.sh","/Users/medhatali/Documents/MobileFramework/cms_ActualCost_FirstEligible_SquareTile_InvalidDeeplink/cms/cms");

		}
		catch (Exception e)
		{
			System.out.println("HEY Buddy ! U r Doing Something Wrong ");
			e.printStackTrace();
		}
	}
}