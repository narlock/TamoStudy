package io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.GlobalSettings;
import model.language.EnglishLanguage;
import model.language.Language;
import resources.Debug;

public class GlobalSettingsJsonManager extends JsonManager<GlobalSettings> {
	
	public static final String globalSettingsPath = System.getProperty("user.home") + File.separatorChar + "Documents" + File.separatorChar + "TamoStudy" 
													+ File.separatorChar + "globalSettings.json";

	@Override
	public GlobalSettings readJson() {
		Debug.info("GlobalSettingsJsonManager.readJson", "Attempting to read globalSettings.json");
		File globalSettingsJsonFile = new File(globalSettingsPath);
		
		if(globalSettingsJsonFile.exists()) {
			JSONParser parser = new JSONParser();
			try {
				Reader reader = new FileReader(globalSettingsPath);
				return globalSettingsJsonToGlobalSettingsModel((JSONObject) parser.parse(reader));
			} catch (IOException | ParseException e) {
				Debug.error("GlobalSettingsJsonManager.readJson", "Exception throw while reading globalSettings.json");
                e.printStackTrace();
            }
		} else {
			try {
				//Check if the documents directory exists, if not, create it
				File documentsDirectory = new File(documentsPath);
				documentsDirectory.mkdir(); //Creates the Documents/ directory if it does not exist.
				
				//Check if the TamoStudy directory exists, if not, create it
				File kaizenDirectory = new File(directoryPath);
				kaizenDirectory.mkdir(); //Creates the Documents/TamoStudy/ directory if it does not exist.
				
				globalSettingsJsonFile.createNewFile();
				writeJsonToFile(new GlobalSettings());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Debug.info("GlobalSettingsJsonManager.readJson", "No Json file was read, returning new object");
		return new GlobalSettings();
	}

	@Override
	public boolean writeJsonToFile(GlobalSettings globalSettings) {
		try {
			File globalSettingsJsonFile = new File(globalSettingsPath);
			FileWriter fileWriter = new FileWriter(globalSettingsJsonFile);
			JSONObject globalSettingsJson = globalSettingsModelToGlobalSettingsJson(globalSettings);
			try {
				
				fileWriter.write(globalSettingsJson.toJSONString());
				return true;
			} catch (IOException e) {
				Debug.error("GlobalSettingsJsonManager.writeJsonToFile", "Error occurred writing global settings to globalSettings.json");
				e.printStackTrace();
				return false;
			} finally {
				try {
					fileWriter.flush();
					fileWriter.close();
				} catch (IOException e) {
					Debug.error("GlobalSettingsJsonManager.writeJsonToFile", "Error occurred while closing file writer.");
					e.printStackTrace();
					return false;
				}
			}
		} catch (IOException e) {
			Debug.error("GlobalSettingsJsonManager.writeJsonToFile", "Error occurred while instantiating fileWriter");
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
	
	private GlobalSettings globalSettingsJsonToGlobalSettingsModel(JSONObject globalSettingsJson) {
		return new GlobalSettings(
				globalSettingsJson.get("language") == null ? new EnglishLanguage() : Language.getLanguage((String) globalSettingsJson.get("language")),
				globalSettingsJson.get("defaultLocalProfile") == null ? -1 : (long) globalSettingsJson.get("defaultLocalProfile"),
				globalSettingsJson.get("receiveUpdateNotifications") == null ? true : (boolean) globalSettingsJson.get("receiveUpdateNotifications")
			);
	}
	
	@SuppressWarnings("unchecked")
	private JSONObject globalSettingsModelToGlobalSettingsJson(GlobalSettings globalSettings) {
		JSONObject globalSettingsJson = new JSONObject();
		globalSettingsJson.put("language", globalSettings.getLanguage().toString());
		globalSettingsJson.put("defaultLocalProfile", globalSettings.getDefaultLocalProfile());
		globalSettingsJson.put("receiveUpdateNotifications", globalSettings.getReceiveUpdateNotifications());
		return globalSettingsJson;
	}
}
