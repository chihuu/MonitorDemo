package com.myappinc.monitor.monitorManager;

import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.common.util.concurrent.Monitor;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.io.IOException;
import java.io.Reader;
import java.sql.Array;

public class MonitorJSONWriteFile {
	public void writeFile(String strName, String strLink) throws IOException {
		JSONArray arr = new JSONArray();
		JSONObject json = new JSONObject();
		MonitorJSONWriteFile monitor = new MonitorJSONWriteFile();
		arr = monitor.getDataFile();
		System.out.print(arr);
		if (arr != null && arr.size() > 0) {
			json.put("name", strName);
			json.put("url", strLink);
			arr.add(json);

			try (FileWriter file = new FileWriter("/Users/huu/file1.txt")) {
				file.write(arr.toJSONString());
				System.out.println("Successfully Copied JSON Object to File...");
				System.out.println("\nJSON Object 12: " + arr);
			}
		} else {
			HashMap<String, JSONObject> map = new HashMap<String, JSONObject>();

			json.put("name", strName);
			json.put("url", strLink);
			map.put("json", json);
			arr.add(json);
			try (FileWriter file = new FileWriter("/Users/huu/file1.txt")) {
				file.write(arr.toJSONString());
				System.out.println("Successfully Copied JSON Object to File...");
				System.out.println("\nJSON Object: " + arr);
			}

			System.out.println(arr);
		}

	}

	public ArrayList<String> readFile() throws IOException {
		JSONParser parser = new JSONParser();
		String linkName = null;
		String url = null;
		ArrayList arrUrl = new ArrayList();
		Object obj = null;
		File file = new File("/Users/huu/file1.txt");
		if(!file.exists()) {
			file.createNewFile();	
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/huu/file1.txt"));
			
			if (br.readLine() != null) {
			    obj = parser.parse(new FileReader("/Users/huu/file1.txt"));
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONArray jsonArray = (JSONArray) obj;
		
		if(jsonArray != null && jsonArray.size() > 0) {
			for (int i = 0; i < jsonArray.size(); i++) {

				JSONObject jsonObjectRow = (JSONObject) jsonArray.get(i);
				url = (String) jsonObjectRow.get("url");

				arrUrl.add(url);

			}
		}
		
		return arrUrl;
	}
	public ArrayList<String> readName() throws IOException {
		JSONParser parser = new JSONParser();
		String linkName = null;
		String url = null;
		ArrayList arrUrl = new ArrayList();
		Object obj = null;
		File file = new File("/Users/huu/file1.txt");
		if(!file.exists()) {
			file.createNewFile();	
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/huu/file1.txt"));
			
			if (br.readLine() != null) {
			    obj = parser.parse(new FileReader("/Users/huu/file1.txt"));
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONArray jsonArray = (JSONArray) obj;
		
		if(jsonArray != null && jsonArray.size() > 0) {
			for (int i = 0; i < jsonArray.size(); i++) {

				JSONObject jsonObjectRow = (JSONObject) jsonArray.get(i);
				url = (String) jsonObjectRow.get("name");

				arrUrl.add(url);

			}
		}
		
		return arrUrl;
	}
	
	
	public void deleteJson(int index) throws FileNotFoundException, IOException {
		MonitorJSONWriteFile monitor = new MonitorJSONWriteFile();
		JSONParser parser = new JSONParser();
		JSONArray jsonObject = new JSONArray();
		String linkName = null;
		String url = null;
		Object obj = null;
		jsonObject = monitor.getDataFile();

		try {
			obj = parser.parse(new FileReader("/Users/huu/file1.txt"));
			jsonObject = (JSONArray) obj;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		jsonObject.remove(index);
		FileWriter file = new FileWriter("/Users/huu/file1.txt");
		file.write(jsonObject.toJSONString());
		file.flush();
		
	} 
	

	public JSONArray getDataFile() throws IOException {
		JSONParser parser = new JSONParser();
		JSONArray jsonObject = new JSONArray();
		String linkName = null;
		String url = null;
		Object obj = null;

		try {
			obj = parser.parse(new FileReader("/Users/huu/file1.txt"));
			jsonObject = (JSONArray) obj;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}
