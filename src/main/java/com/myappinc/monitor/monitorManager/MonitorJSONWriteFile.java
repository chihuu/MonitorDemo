package com.myappinc.monitor.monitorManager;

import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.io.IOException;
import java.io.Reader;


public class MonitorJSONWriteFile {
  public void writeFile(String strLink) throws IOException {
	  JSONObject obj = new JSONObject();
		obj.put("link", strLink);
		
		// try-with-resources statement based on post comment below :)
		try (FileWriter file = new FileWriter("/Users/huu/file1.txt")) {
			file.write(obj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		}
	}
	  
  public String readFile() throws IOException {
	  JSONParser parser = new JSONParser();
	  String linkName = null;
	  
      try {
    	  	//Reader reader = new FileReader("/Users/huu/file1.txt");
    	  	BufferedReader reader = new BufferedReader(new FileReader("/Users/huu/file1.txt"));
    	  	if(reader.readLine() != null) {
    	  		Object obj = parser.parse(reader);
    	          if(obj != null) {
    	        	  	JSONObject jsonObject = (JSONObject) obj;
    	              linkName = (String) jsonObject.get("link");
    	          }
    	  	}
          
        		  
        
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      } catch (ParseException e) {
          e.printStackTrace();
      }
      return linkName;
  }
  
}

