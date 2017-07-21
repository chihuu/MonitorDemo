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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

			try (FileWriter file = new FileWriter(monitor.createFile())) {
				file.write(arr.toJSONString());
				System.out.println(" createfile :" + monitor.createFile());
				System.out.println("Successfully Copied JSON Object to File...");
				System.out.println("\nJSON Object 12: " + arr);
			}
		} else {
			HashMap<String, JSONObject> map = new HashMap<String, JSONObject>();

			json.put("name", strName);
			json.put("url", strLink);
			map.put("json", json);
			arr.add(json);
			try (FileWriter file = new FileWriter(monitor.createFile())) {
				file.write(arr.toJSONString());
				System.out.println(" creatfile :" + monitor.createFile());
				System.out.println("Successfully Copied JSON Object to File...");
				System.out.println("\nJSON Object: " + arr);
			}

			System.out.println(arr);
		}

	}

	public void writeConfigFile(String urlFFmpeg, String urlFFmprobe) throws IOException {
		JSONArray arr = new JSONArray();
		JSONObject json = new JSONObject();
		MonitorJSONWriteFile monitor = new MonitorJSONWriteFile();
		if (arr != null && arr.size() > 0) {
			json.put("ffmprobeUrl", urlFFmprobe);
			json.put("ffmpegUrl", urlFFmpeg);

			try (FileWriter file = new FileWriter(monitor.createConfigFile())) {
				file.write(json.toJSONString());
				System.out.println(" createfile :" + monitor.createConfigFile());
				System.out.println("Successfully Copied JSON Object to File...");
				System.out.println("\nJSON Object 12: " + json.toJSONString());
			}
		} else {
			json.put("ffmprobeUrl", urlFFmprobe);
			json.put("ffmpegUrl", urlFFmpeg);
			try (FileWriter file = new FileWriter(monitor.createConfigFile())) {
				file.write(json.toJSONString());
				System.out.println(" creatfile :" + monitor.createFile());
				System.out.println("Successfully Copied JSON Object to File...");
				System.out.println("\nJSON Object: " + json.toJSONString());
			}

		}

	}

	public ArrayList<String> readFile() throws IOException {
		JSONParser parser = new JSONParser();
		String linkName = null;
		String url = null;
		ArrayList arrUrl = new ArrayList();
		Object obj = null;

		MonitorJSONWriteFile monitor = new MonitorJSONWriteFile();
		String c = monitor.createFile();
		

		try {
			BufferedReader br = new BufferedReader(new FileReader(c));

			if (br.readLine() != null) {
				obj = parser.parse(new FileReader(c));
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONArray jsonArray = (JSONArray) obj;

		if (jsonArray != null && jsonArray.size() > 0) {
			for (int i = 0; i < jsonArray.size(); i++) {

				JSONObject jsonObjectRow = (JSONObject) jsonArray.get(i);
				url = (String) jsonObjectRow.get("url");

				arrUrl.add(url);

			}
		}

		return arrUrl;
	}

	public String readConfigFFmpeg() throws IOException {
		JSONParser parser = new JSONParser();
		String linkName = null;
		String urlFFmpeg = null;
		ArrayList arrUrl = new ArrayList();
		Object obj = null;

		MonitorJSONWriteFile monitor = new MonitorJSONWriteFile();
		String c = monitor.createConfigFile();

		try {
			BufferedReader br = new BufferedReader(new FileReader(c));

			if (br.readLine() != null) {
				obj = parser.parse(new FileReader(c));
				JSONObject jsonObject = (JSONObject) obj;
				urlFFmpeg = (String) jsonObject.get("ffmpegUrl");
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return urlFFmpeg;
	}

	public String readConfigFFmprobe() throws IOException {
		JSONParser parser = new JSONParser();
		String linkName = null;
		String urlFFmprobe = null;
		ArrayList arrUrl = new ArrayList();
		Object obj = null;

		MonitorJSONWriteFile monitor = new MonitorJSONWriteFile();
		String c = monitor.createConfigFile();

		try {
			BufferedReader br = new BufferedReader(new FileReader(c));

			if (br.readLine() != null) {
				obj = parser.parse(new FileReader(c));
				JSONObject jsonObject = (JSONObject) obj;
				urlFFmprobe = (String) jsonObject.get("ffmprobeUrl");
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return urlFFmprobe;
	}

	public String createFile() throws IOException {
		File dir = new File("tmp/test");
		dir.mkdirs();
		File tmp = new File(dir, "fileprocess.txt");
		if (!tmp.exists()) {
			tmp.createNewFile();
		}

		System.out.println("file name : " + tmp.getAbsolutePath());
		return tmp.getAbsolutePath();

	}

	public String createConfigFile() throws IOException {
		File dir = new File("tmp/test");
		dir.mkdirs();
		File tmp = new File(dir, "config.txt");
		if (!tmp.exists()) {
			tmp.createNewFile();
		}

		System.out.println("file name : " + tmp.getAbsolutePath());
		return tmp.getAbsolutePath();

	}

	public ArrayList<String> readName() throws IOException {
		JSONParser parser = new JSONParser();
		String linkName = null;
		String url = null;
		ArrayList arrUrl = new ArrayList();
		Object obj = null;
		MonitorJSONWriteFile monitor = new MonitorJSONWriteFile();
		String c = monitor.createFile();

		try {

			BufferedReader br = new BufferedReader(new FileReader(c));

			if (br.readLine() != null) {
				obj = parser.parse(new FileReader(c));
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONArray jsonArray = (JSONArray) obj;

		if (jsonArray != null && jsonArray.size() > 0) {
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
			obj = parser.parse(new FileReader(monitor.createFile()));
			jsonObject = (JSONArray) obj;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		jsonObject.remove(index);
		FileWriter file = new FileWriter(monitor.createFile());
		file.write(jsonObject.toJSONString());
		file.flush();

	}

	public JSONArray getDataFile() throws IOException {
		JSONParser parser = new JSONParser();
		JSONArray jsonObject = new JSONArray();
		String linkName = null;
		MonitorJSONWriteFile monitor = new MonitorJSONWriteFile();
		String url = null;
		Object obj = null;

		try {
			obj = parser.parse(new FileReader(monitor.createFile()));
			jsonObject = (JSONArray) obj;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}
