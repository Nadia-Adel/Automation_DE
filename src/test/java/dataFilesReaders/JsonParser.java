package dataFilesReaders;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {


	public static Object parseJson (String jsonPath)  {


		JSONParser jsonParser = new JSONParser();
		FileReader reader = null;   // Takes the path of the file we need to parse
		try {
			reader = new FileReader(jsonPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Read JSON file
		Object obj = null;
		try {
			obj = jsonParser.parse(reader); // here we have the file on json object format
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}





}
