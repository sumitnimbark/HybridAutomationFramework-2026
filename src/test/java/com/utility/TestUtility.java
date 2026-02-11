package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import com.google.gson.Gson;

public class TestUtility {
	
	public static String convertPOJOToJson(Object object) {
		
		Gson gson = new Gson();
		String json = gson.toJson(object);
		return json;
		
	}
	
	public static String readConfigFile()
	{
		 /*
		  * Steps to read data from properties file:
		  * 1. Tell java where the file is located File. Create the pointer of the File class and give the path of the file to it
		  * 2. Give path of the file pointer to FileReader to read the file
		  * 3. Create an object of Properties class
		  * 4. Load the file into the Properties object
		  */
		
		File configFile = new File("D:\\AutomationFramework\\HybridAutomationFramework-2026\\Config\\QA.properties");
		FileReader fileReader=null;
		try {
			
		fileReader = new FileReader(configFile);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties properties = new Properties();
		try {
			
		properties.load(fileReader);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String data = properties.getProperty("BASE_URL");
		return data;
	}

}
