package dataFilesReaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import dataFilesHandeller.SandboxConfigReader_NewSolution;


public class TextFileReader {
	
	public static String readTextFilAsString(String FilePath) throws IOException {
		  File file = new File(FilePath); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  StringBuilder sb = new StringBuilder();

		    String line = br.readLine();
		     while (line != null) {
		      sb.append(line).append("\n");
		      line = br.readLine();
		    }

		    String fileAsString = sb.toString();
		
		    return fileAsString;
	}
	
//	public static void main(String [] args) throws IOException {
//		
//		
//		System.out.println("file is  :  "+ readTextFilAsString(SandboxConfigReader_NewSolution.getProberty("startSession_401")));
//	}
//	
}
