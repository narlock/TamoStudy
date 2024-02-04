package io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.time.DailyFocus;
import model.time.DailyFocusEntry;
import resources.Debug;

public class DailyFocusJsonManager extends JsonManager<List<DailyFocus>> {
	
	public static final String dailyFocusPath = System.getProperty("user.home") + File.separatorChar + "Documents" + File.separatorChar + "TamoStudy" 
			+ File.separatorChar + "dailyfocus.json";

	@Override
	public List<DailyFocus> readJson() {
		Debug.info("DailyFocusJsonManager.readJson", "Attempting to read dailyfocus.json");
		File dailyFocusJsonFile = new File(dailyFocusPath);
		
		if(dailyFocusJsonFile.exists()) {
			JSONParser parser = new JSONParser();
			try {
				Reader reader = new FileReader(dailyFocusPath);
				JSONArray dailyFocusJsonArray = (JSONArray) parser.parse(reader);
				Debug.info("DailyFocusJsonManager.readJson", "Read JSONArray dailyFocusJsonArray. dailyFocusJsonArray.size = " + dailyFocusJsonArray.size());
				return dailyFocusJsonArrayToDailyFocusList(dailyFocusJsonArray);
			} catch (IOException | ParseException e) {
				Debug.error("DailyFocusJsonManager.readJson", "Exception throw while reading dailyfocus.json");
                e.printStackTrace();
            }
		}
		
		Debug.info("DailyFocusJsonManager.readJson", "No DailyFocus objects were found");
		return Collections.emptyList();
	}

	@Override
	public boolean writeJsonToFile(List<DailyFocus> dailyFocusList) {
		try {
			File dailyFocusJsonFile = new File(dailyFocusPath);
			FileWriter fileWriter = new FileWriter(dailyFocusJsonFile);
			JSONArray dailyFocusJson = dailyFocusListToDailyFocusJson(dailyFocusList);
			try {
				
				fileWriter.write(dailyFocusJson.toJSONString());
				return true;
			} catch (IOException e) {
				Debug.error("DailyFocusJsonManager.writeJsonToFile", "Error occurred writing profiles to dailyfocus.json");
				e.printStackTrace();
				return false;
			} finally {
				try {
					fileWriter.flush();
					fileWriter.close();
				} catch (IOException e) {
					Debug.error("DailyFocusJsonManager.writeJsonToFile", "Error occurred while closing file writer.");
					e.printStackTrace();
					return false;
				}
			}
		} catch (IOException e) {
			Debug.error("DailyFocusJsonManager.writeJsonToFile", "Error occurred while instantiating fileWriter");
			e.printStackTrace();
			return false;
		}
	}
	
	/*
	 * ##################################
	 * ##################################
	 * MAPPINGS
	 * ##################################
	 * ##################################
	 */

	public List<DailyFocus> dailyFocusJsonArrayToDailyFocusList(JSONArray dailyFocusJsonArray) {
		List<DailyFocus> dailyFocusList = new ArrayList<>();
		for(int i = 0; i < dailyFocusJsonArray.size(); i++) {
			dailyFocusList.add(dailyFocusJsonToDailyFocus((JSONObject) dailyFocusJsonArray.get(i)));
		}
		return dailyFocusList;
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray dailyFocusListToDailyFocusJson(List<DailyFocus> dailyFocusList) {
		JSONArray dailyFocusJsonArray = new JSONArray();
		for(DailyFocus dailyFocus : dailyFocusList) {
			dailyFocusJsonArray.add(dailyFocusToDailyFocusJson(dailyFocus));
		}
		return dailyFocusJsonArray;
	}
	
	public DailyFocus dailyFocusJsonToDailyFocus(JSONObject dailyFocusJson) {
		List<DailyFocusEntry> dailyFocusEntries = new ArrayList<>();
		JSONArray dailyFocusEntriesJsonList = (JSONArray) dailyFocusJson.get("dailyFocusEntries");
		for(int i = 0; i < dailyFocusEntriesJsonList.size(); i++) {
			dailyFocusEntries.add(dailyFocusEntryJsonToDailyFocusEntry((JSONObject) dailyFocusEntriesJsonList.get(i)));
		}
		
		return new DailyFocus(
					(long) dailyFocusJson.get("profileId"),
					dailyFocusEntries
				);
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject dailyFocusToDailyFocusJson(DailyFocus dailyFocus) {
		JSONObject dailyFocusJson = new JSONObject();
		dailyFocusJson.put("profileId", dailyFocus.getProfileId());
		
		JSONArray dailyFocusEntries = new JSONArray();
		for(DailyFocusEntry dailyFocusEntry : dailyFocus.getDailyFocusEntries()) {
			dailyFocusEntries.add(dailyFocusEntryToDailyFocusEntryJson(dailyFocusEntry));
		}
		dailyFocusJson.put("dailyFocusEntries", dailyFocusEntries);
		
		return dailyFocusJson;
	}
	
	public DailyFocusEntry dailyFocusEntryJsonToDailyFocusEntry(JSONObject dailyFocusEntryJson) {
		return new DailyFocusEntry(
					(long) dailyFocusEntryJson.get("day"),
					(long) dailyFocusEntryJson.get("month"),
					(long) dailyFocusEntryJson.get("year"),
					(long) dailyFocusEntryJson.get("time")
				);
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject dailyFocusEntryToDailyFocusEntryJson(DailyFocusEntry dailyFocusEntry) {
		JSONObject dailyFocusEntryJson = new JSONObject();
		dailyFocusEntryJson.put("day", dailyFocusEntry.getDay());
		dailyFocusEntryJson.put("month", dailyFocusEntry.getMonth());
		dailyFocusEntryJson.put("year", dailyFocusEntry.getYear());
		dailyFocusEntryJson.put("time", dailyFocusEntry.getTime());
		return dailyFocusEntryJson;
	}
}
