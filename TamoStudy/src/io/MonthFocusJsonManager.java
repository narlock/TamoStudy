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

import model.time.MonthFocus;
import model.time.MonthFocusEntry;
import resources.Debug;

public class MonthFocusJsonManager extends JsonManager<List<MonthFocus>> {
	
	public static final String monthFocusPath = System.getProperty("user.home") + File.separatorChar + "Documents" + File.separatorChar + "TamoStudy" 
			+ File.separatorChar + "monthfocus.json";

	@Override
	public List<MonthFocus> readJson() {
		Debug.info("MonthFocusJsonMAnager.readJson", "Attempting to read monthfocus.json");
		File monthFocusJsonFile = new File(monthFocusPath);
		
		if(monthFocusJsonFile.exists()) {
			JSONParser parser = new JSONParser();
			try {
				Reader reader = new FileReader(monthFocusPath);
				JSONArray monthFocusJsonArray = (JSONArray) parser.parse(reader);
				Debug.info("MonthFocusJsonManager.readJson", "Read JSONArray monthFocusJsonArray. monthFocusJsonArray.size = " + monthFocusJsonArray.size());
				return monthFocusJsonArrayToMonthFocusList(monthFocusJsonArray);
			} catch (IOException | ParseException e) {
				Debug.error("MonthFocusJsonManager.readJson", "Exception throw while reading monthfocus.json");
                e.printStackTrace();
            }
		}
		
		Debug.info("MonthFocusJsonManager.readJson", "No MonthFocus objects were found");
		return Collections.emptyList();
	}

	@Override
	public boolean writeJsonToFile(List<MonthFocus> monthFocusList) {
		try {
			File monthFocusJsonFile = new File(monthFocusPath);
			FileWriter fileWriter = new FileWriter(monthFocusJsonFile);
			JSONArray monthFocusJson = monthFocusListToMonthFocusJson(monthFocusList);
			try {
				
				fileWriter.write(monthFocusJson.toJSONString());
				return true;
			} catch (IOException e) {
				Debug.error("MonthFocusJsonManager.writeJsonToFile", "Error occurred writing profiles to monthfocus.json");
				e.printStackTrace();
				return false;
			} finally {
				try {
					fileWriter.flush();
					fileWriter.close();
				} catch (IOException e) {
					Debug.error("MonthFocusJsonManager.writeJsonToFile", "Error occurred while closing file writer.");
					e.printStackTrace();
					return false;
				}
			}
		} catch (IOException e) {
			Debug.error("MonthFocusJsonManager.writeJsonToFile", "Error occurred while instantiating fileWriter");
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

	public List<MonthFocus> monthFocusJsonArrayToMonthFocusList(JSONArray monthFocusJsonArray) {
		List<MonthFocus> monthFocusList = new ArrayList<>();
		for(int i = 0; i < monthFocusJsonArray.size(); i++) {
			monthFocusList.add(monthFocusJsonToMonthFocus((JSONObject) monthFocusJsonArray.get(i)));
		}
		return monthFocusList;
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray monthFocusListToMonthFocusJson(List<MonthFocus> monthFocusList) {
		JSONArray monthFocusJsonArray = new JSONArray();
		for(MonthFocus monthFocus : monthFocusList) {
			monthFocusJsonArray.add(monthFocusToMonthFocusJson(monthFocus));
		}
		return monthFocusJsonArray;
	}
	
	public MonthFocus monthFocusJsonToMonthFocus(JSONObject monthFocusJson) {
		List<MonthFocusEntry> monthFocusEntries = new ArrayList<>();
		JSONArray monthFocusEntriesJsonList = (JSONArray) monthFocusJson.get("monthFocusEntries");
		for(int i = 0; i < monthFocusEntriesJsonList.size(); i++) {
			monthFocusEntries.add(monthFocusEntryJsonToMonthFocusEntry((JSONObject) monthFocusEntriesJsonList.get(i)));
		}
		return new MonthFocus(
					(long) monthFocusJson.get("profileId"),
					monthFocusEntries
				);
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject monthFocusToMonthFocusJson(MonthFocus monthFocus) {
		JSONObject monthFocusJson = new JSONObject();
		monthFocusJson.put("profileId", monthFocus.getProfileId());
		
		JSONArray monthFocusEntries = new JSONArray();
		for(MonthFocusEntry monthFocusEntry : monthFocus.getMonthFocusEntries()) {
			monthFocusEntries.add(monthFocusEntryToMonthFocusEntryJson(monthFocusEntry));
		}
		monthFocusJson.put("monthFocusEntries", monthFocusEntries);
		
		return monthFocusJson;
	}
	
	public MonthFocusEntry monthFocusEntryJsonToMonthFocusEntry(JSONObject monthFocusEntryJson) {
		return new MonthFocusEntry(
					(long) monthFocusEntryJson.get("month"),
					(long) monthFocusEntryJson.get("year"),
					(long) monthFocusEntryJson.get("time")
				);
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject monthFocusEntryToMonthFocusEntryJson(MonthFocusEntry monthFocusEntry) {
		JSONObject monthFocusEntryJson = new JSONObject();
		monthFocusEntryJson.put("month", monthFocusEntry.getMonth());
		monthFocusEntryJson.put("year", monthFocusEntry.getYear());
		monthFocusEntryJson.put("time", monthFocusEntry.getTime());
		return monthFocusEntryJson;
	}
}
